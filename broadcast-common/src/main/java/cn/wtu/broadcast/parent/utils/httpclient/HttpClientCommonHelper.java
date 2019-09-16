package cn.wtu.broadcast.parent.utils.httpclient;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientCommonHelper {
	
	static {
		System.setProperty("java.net.useSystemProxies", "true");
	}
	
	private static final CloseableHttpClient httpclient = HttpClients.createDefault();
	
    /**
     * 发送HttpGet请求
     * @param url
     * @return
     */
    public static String sendGet(String url, int timeOut) throws Exception{
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        String result = null;
        try {
        	/**
        	 * setConnectTimeout：设置连接超时时间，单位毫秒   
             * setConnectionRequestTimeout：设置从connect Manager(连接池)获取Connection 超时时间
             * setSocketTimeout：请求获取数据的超时时间(即响应时间)
        	 */
        	RequestConfig requestConfig = RequestConfig.custom()  
                    .setConnectTimeout(timeOut).setConnectionRequestTimeout(timeOut)  
                    .setSocketTimeout(timeOut).build();
            httpGet.setConfig(requestConfig);
            response = httpclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }
        } finally {
        	if(response != null){
				response.close();
			}
        }
        
        return result;
    }
 
    /**
     * 发送HttpPost请求，参数为map
     * @param url
     * @param map
     * @return
     */
    public static String sendPost(String url, Map<String, String> map, int timeOut) throws Exception{
    	String result = null;
    	CloseableHttpResponse response = null;
    	try {
    		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
            HttpPost httppost = new HttpPost(url);
            httppost.setEntity(entity);
            /**
        	 * setConnectTimeout：设置连接超时时间，单位毫秒   
             * setConnectionRequestTimeout：设置从connect Manager(连接池)获取Connection 超时时间
             * setSocketTimeout：请求获取数据的超时时间(即响应时间)
        	 */
        	RequestConfig requestConfig = RequestConfig.custom()  
                    .setConnectTimeout(timeOut).setConnectionRequestTimeout(timeOut)  
                    .setSocketTimeout(timeOut).build();
        	httppost.setConfig(requestConfig);
            response = httpclient.execute(httppost);
            HttpEntity entity1 = response.getEntity();
            result = EntityUtils.toString(entity1);
		} finally {
			if(response != null){
				response.close();
			}
		}
    	
        return result;
    }
 
    /**
     * 发送不带参数的HttpPost请求
     * @param url
     * @return
     */
    public static String sendPost(String url, int timeOut) throws Exception {
    	String result = null;
    	CloseableHttpResponse response = null;
    	try {
        HttpPost httppost = new HttpPost(url);
        /**
    	 * setConnectTimeout：设置连接超时时间，单位毫秒   
         * setConnectionRequestTimeout：设置从connect Manager(连接池)获取Connection 超时时间
         * setSocketTimeout：请求获取数据的超时时间(即响应时间)
    	 */
    	RequestConfig requestConfig = RequestConfig.custom()  
                .setConnectTimeout(timeOut).setConnectionRequestTimeout(timeOut)  
                .setSocketTimeout(timeOut).build();
        httppost.setConfig(requestConfig);
        response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();
        result = EntityUtils.toString(entity);
    	} finally {
			if(response != null){
				response.close();
			}
		}
    	
        return result;
    }
}
