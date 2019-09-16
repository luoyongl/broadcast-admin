package cn.wtu.broadcast.parent.utils;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtil {

	private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

	public static String DEFAUT_ENCODING = "GBK";

	private static int CONNECT_TIMEOUT = 10 * 1000; //单位毫秒
	private static int SOCKET_TIMEOUT = 10 * 1000;//单位毫秒

	public static void initHttpUtil(int connectTimeOut, int socketTimeout) {
		CONNECT_TIMEOUT = connectTimeOut;
		SOCKET_TIMEOUT = socketTimeout;
	}

	private static String execute(HttpRequestBase httpRequestBase,Exceptionhandle exceptionhandle) throws IOException, ClientProtocolException {
		CloseableHttpClient httpclient = null;
		try {
			httpclient = HttpClients.createDefault();
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(SOCKET_TIMEOUT).setConnectTimeout(CONNECT_TIMEOUT).build();// 设置请求和传输超时时间
			httpRequestBase.setConfig(requestConfig);
			String responseText = httpclient.execute(httpRequestBase, new ResponseHandler<String>() {

				@Override
				public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
					try {
						HttpEntity entity = response.getEntity();
						if (entity != null) {

							return EntityUtils.toString(entity);
						} else {
							return null;
						}
					} catch (Throwable t) {
						t.printStackTrace();
						logger.error("handleResponse 1", t);
						return null;
					} finally {
						if ((response instanceof CloseableHttpResponse) && response != null) {
							CloseableHttpResponse closeableHttpResponse = (CloseableHttpResponse) response;
							closeableHttpResponse.close();
						}
					}

				}
			});
			return responseText;
		} catch (Exception e) {
			
			if(exceptionhandle != null){
				exceptionhandle.onException();
			}else{
				e.printStackTrace();
				logger.error("handleResponse 2", e);
			}
			return null;
		} finally {
			if (httpclient != null) {
				try {
					httpclient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static String get(String url) {
	    
	    return get(url, null, DEFAUT_ENCODING);
	}
	
	public static String get(String url, List<? extends NameValuePair> formparams) {

		return get(url, formparams, DEFAUT_ENCODING);
	}

	public static String get(String url, List<? extends NameValuePair> formparams, String encoding) {

		try {

			HttpGet httpGet = new HttpGet(url);
			if (formparams != null) {
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, encoding);
				httpGet.setURI(new URI(httpGet.getURI() + "?" + EntityUtils.toString(entity)));
			}

			return execute(httpGet,null);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("http get", e);
			return null;
		}
	}

	public static String post(String url, List<? extends NameValuePair> formparams, String encoding,Exceptionhandle exceptionhandle) {

		try {

			HttpPost httppost = new HttpPost(url);
			httppost.setEntity(new UrlEncodedFormEntity(formparams, encoding));
			return execute(httppost,exceptionhandle);
			// System.out
			// .println("响应结果:-------------------------start-----------------------------------------");
			// System.out.println(responseText);
			// System.out
			// .println("响应结果:-------------------------end-----------------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("post formparams异常,错误信息为:", e);
			return null;
		}
	}

	public static String post(String url, String str, String encoding) {

		try {

			HttpPost httppost = new HttpPost(url);
			StringEntity stringEntity = new StringEntity(str, encoding);
			httppost.setEntity(stringEntity);

			return execute(httppost,null);
			// System.out
			// .println("响应结果:-------------------------start-----------------------------------------");
			// System.out.println(responseText);
			// System.out
			// .println("响应结果:-------------------------end-----------------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("post str异常,错误信息为:", e);
			return null;
		}
	}

	public static String post(String url, List<? extends NameValuePair> formparams) {
		return post(url, formparams, DEFAUT_ENCODING,null);
	}
	
	public static String post(String url, List<? extends NameValuePair> formparams,Exceptionhandle exceptionhandle) {
		return post(url, formparams, DEFAUT_ENCODING,exceptionhandle);
	}
	
	public static String post(String url, List<? extends NameValuePair> formparams,String encoding) {
		return post(url, formparams, encoding,null);
	}
	
	public interface Exceptionhandle{
		public void onException();
	}
}
