package cn.wtu.broadcast.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

public class EBHttpClientUtil {

	private static Logger logger = LoggerFactory.getLogger(EBHttpClientUtil.class);
	
	/**
	 * 请求封装，类似于表单的类型为multipart/form-data
	 * @param urlToRequest
	 * @param postParam
	 * @return
	 */
	public static JSONObject multipartEntityBuilder(String urlToRequest, Map<String, String> postParam) {
		JSONObject json = null;
		try {
			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		    builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		    
		    for (Map.Entry<String, String> entry : postParam.entrySet()) {
		    	builder.addTextBody(entry.getKey(), entry.getValue(), ContentType.TEXT_PLAIN.withCharset("UTF-8"));
			}
		    HttpPost httpPost = new HttpPost(urlToRequest);
			httpPost.setEntity(builder.build());
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpResponse response = httpclient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			String retult = EntityUtils.toString(entity, "UTF-8");
			logger.info("请求地址：" + urlToRequest + " 请求结果：" + retult);
			json = JSONObject.fromObject(retult);			
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}

		return json;
	}
	
	/**
	 * 注意提交的post参数是以form表单提交，而不是body提交，
	 * 类似于传统的application/x-www-form-urlencoded表单上传
	 * @param urlToRequest
	 * @param postParam
	 * @return
	 */
	public static Boolean urlEncodedFormEntity(String urlToRequest, Map<String, String> postParam) {
		try {
			// 遍历map 将其中的数据转化为表单数据
			List<NameValuePair> formParams = new ArrayList<NameValuePair>();
			for (Map.Entry<String, String> entry : postParam.entrySet()) {
				formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
			HttpPost httpPost = new HttpPost(urlToRequest);
			httpPost.setEntity(new UrlEncodedFormEntity(formParams, "UTF-8"));

			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpResponse response = httpclient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			String retult = EntityUtils.toString(entity, "UTF-8");
			logger.info("请求地址：" + urlToRequest + " 请求结果：" + retult);
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}

		return false;
	}
}