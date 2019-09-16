package cn.wtu.broadcast.controller.instruction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import cn.wtu.broadcast.openapi.protocol.SendProtocolTools;
import cn.wtu.broadcast.parent.vo.cmd.CertificateIssueVo;

public class IssueCertificateTool {

	public static CertificateIssueVo  getCertificateIssueVo(String path,String SMSN)  throws Exception {
		
		CertificateIssueVo certificateIssueVo = new CertificateIssueVo();
		
		//String url = "http://124.127.49.183:809/MAV/zcqq?path=00000000131D.00000000131E&opt=REG&SMSN=00000000131C";
		String url = "http://124.127.49.183:809/MAV/zcqq?path="+path+"&opt=REG&SMSN="+SMSN;
		
		HttpGet httpGet = new HttpGet(url);
		
		CloseableHttpClient hc = HttpClients.createDefault();
		
		CloseableHttpResponse response = hc.execute(httpGet);
		
	   // int status = response.getStatusLine().getStatusCode();
	    
	    //if (status != 200)

	    String str = EntityUtils.toString(response.getEntity(), "gb2312");
	    
	    //System.out.println(str);
	    

	    String[] contentArr = str.split(",", 3);
	    
	    Document doc = Jsoup.parse(contentArr[2]);
        Elements certCtxs = doc.getElementsByTag("CertCtx");
        List<String> certCtxList = certCtxs.eachText();
        //CertCtx
        //System.out.println(certCtxList);
        
        certificateIssueVo.setCertCtx(certCtxList);
        
	    //获得LIST
        String[] contentArr2 = str.split(",");
        
        List<String> list = Arrays.asList(new String[] { contentArr2[2] });
        
        List<String> certificateLIST = new ArrayList<String>();
        
        for (String string : list) {
        	String str2 = string.substring(string.indexOf("=")+1);
			//System.out.println(str2);
			
			String base64ToHex = SendProtocolTools.Base64ToHex(str2);
			//System.out.println(base64ToHex);
			
			certificateLIST.add(base64ToHex);
		}
        System.out.println("-------------------------下发证书解析完毕------------------------------------");
        
        certificateIssueVo.setCertificateLIST(certificateLIST);
        
        
		return certificateIssueVo;
	}
}
