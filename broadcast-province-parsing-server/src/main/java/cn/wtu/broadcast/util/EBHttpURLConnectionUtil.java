package cn.wtu.broadcast.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.wtu.broadcast.common.PropertyConstants;

/**
 * HttpURLConnection的connect()函数，实际上只是建立了一个与服务器的tcp连接，并没有实际发送http请求。
 * 无论是post还是get请求，http请求实际上直到HttpURLConnection的getInputStream()这个函数里面才正式发送出去。
 * 所以对outputStream的写操作，必须要在inputStream的读操作之前，效率高
 * 1.通过统一资源定位器（java.net.URL）获取连接器（java.net.URLConnection） 2.设置请求的参数 3.发送请求
 * 4.以输入流的形式获取返回内容 5.关闭输入流 上传文件到服务器
 */
public class EBHttpURLConnectionUtil {

	private static Logger logger = LoggerFactory.getLogger(EBHttpURLConnectionUtil.class);
	
	private static final String PROVINCIAL_HTTP_URL = PropertyConstants.getPropertiesKey("provincial_http_url");

	private static final String REQUEST_METHOD_POST = "POST";

	private static final String ACCEPT_LANGUAGE = "zh-CN,zh-TW;q=0.8,zh-HK;q=0.6,zh-MO;q=0.4,zh-SG;q=0.2";

	private static final String USER_AGENT = "WinHttpClient";

	private static final String CONNECTION = "Keep-Alive";

	private static final String CHARSET = "UTF-8";

	private static final String CONTENT_TYPE = "multipart/form-data;boundary=";

	private static final String end = "\r\n";

	private static final String twoHyphens = "--";

	/**
	 * 发送tar包到省平台
	 * @param tarFileNamePath 包文件全路径，文件路径和名称
	 * @return
	 */
	public static String sendTarToProvince(String tarFileNamePath) {
		DataOutputStream ds = null;
		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader reader = null;
		StringBuffer resultBuffer = new StringBuffer();
		try {
			// 统一资源
			URL url = new URL(PROVINCIAL_HTTP_URL);
			// 连接类的父类，抽象类
			URLConnection urlConnection = url.openConnection();
			// http的连接类
			HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
			// 设置是否从httpUrlConnection读入，默认情况下是true;
			httpURLConnection.setDoInput(true);
			// 设置是否向httpUrlConnection输出
			httpURLConnection.setDoOutput(true);
			// Post 请求不能使用缓存
			httpURLConnection.setUseCaches(false);
			// 设定请求的方法，默认是GET
			httpURLConnection.setRequestMethod(REQUEST_METHOD_POST);
			// 设置当前浏览器的语言
			httpURLConnection.setRequestProperty("Accept-Language", ACCEPT_LANGUAGE);
			// 设置浏览器User-Agent
			httpURLConnection.setRequestProperty("User-Agent", USER_AGENT);
			// 设置字符编码连接参数
			httpURLConnection.setRequestProperty("Connection", CONNECTION);
			// 设置字符编码
			httpURLConnection.setRequestProperty("Charset", CHARSET);
			// 设置请求内容类型
			String boundary = twoHyphens + System.currentTimeMillis();
			httpURLConnection.setRequestProperty("Content-Type", CONTENT_TYPE + boundary);
			// 设置请求文件类型以及DataOutputStream
			ds = new DataOutputStream(httpURLConnection.getOutputStream());
			setFiles(tarFileNamePath, ds, boundary);
			// 获取响应结果
			getResult(httpURLConnection, inputStream, inputStreamReader, reader, resultBuffer);
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		} finally {
			close(ds, inputStream, inputStreamReader, reader);
		}
		
		return resultBuffer.toString();
	}

	/**
	 * 文件格式封装
	 * @param tarName tar包名称
	 * @param destFolderPath tar包路径（ 以"/"结尾）
	 * @param ds DataOutputStream
	 * @param boundary boundary
	 * @throws IOException
	 */
	private static void setFiles(String tarFileNamePath, DataOutputStream ds, String boundary) throws IOException {
		String tarName = tarFileNamePath.substring(tarFileNamePath.lastIndexOf("\\") + 1);
		ds.writeBytes(twoHyphens + boundary + end);
		ds.writeBytes("Content-Disposition: form-data; " + "name=\"file\";filename=\"" + tarName + "\"" + end);
		//ds.writeBytes("Content-Type: application/x-tar");
		ds.writeBytes(end);
		FileInputStream fStream = new FileInputStream(tarFileNamePath);
		int bufferSize = 1024;
		byte[] buffer = new byte[bufferSize];
		int length = -1;
		while ((length = fStream.read(buffer)) != -1) {
			ds.write(buffer, 0, length);
		}
		ds.writeBytes(end);
		fStream.close();
		ds.writeBytes(twoHyphens + boundary + twoHyphens + end);
		ds.flush();
	}

	/**
	 * 获取响应结果
	 * @param httpURLConnection
	 * @param inputStream
	 * @param inputStreamReader
	 * @param reader
	 * @param resultBuffer
	 * @return
	 * @throws IOException
	 */
	private static StringBuffer getResult(HttpURLConnection httpURLConnection, InputStream inputStream,
			InputStreamReader inputStreamReader, BufferedReader reader, StringBuffer resultBuffer)
			throws IOException {
		if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
			//调用HttpURLConnection连接对象的getInputStream()函数,将内存缓冲区中封装好的完整的HTTP请求电文发送到服务端
			inputStream = httpURLConnection.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream);
			reader = new BufferedReader(inputStreamReader);
			String tempLine = null;
			while ((tempLine = reader.readLine()) != null) {
				resultBuffer.append(tempLine);
				resultBuffer.append("\n");
			}
			return resultBuffer;
		} else {
			reader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream(), "UTF-8"));
            StringBuffer errorMessage = new StringBuffer();
            String temp = null;
            while ((temp = reader.readLine()) != null) {
            	errorMessage.append(temp);
            	errorMessage.append("\r\n");
            }
			throw new IOException(errorMessage.toString());
		}
	}

	/**
	 * 释放资源
	 * 
	 * @param ds
	 * @param inputStream
	 * @param inputStreamReader
	 * @param reader
	 */
	private static void close(DataOutputStream ds, InputStream inputStream, InputStreamReader inputStreamReader,
			BufferedReader reader) {
		try {
			if (ds != null) {
				ds.close();
			}
			if (inputStream != null) {
				inputStream.close();
			}
			if (inputStreamReader != null) {
				inputStreamReader.close();
			}
			if (reader != null) {
				reader.close();
			}
		} catch (IOException e) {
			logger.error(e.getMessage() + e);
		}
	}
}