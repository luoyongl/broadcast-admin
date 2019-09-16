package cn.wtu.broadcast.parent.utils;
  
import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.security.Security;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;  
  
 
public class EmailSslUtil {  
  
    private static final String userName = "service@wtu.cn";  
  
    private static final String password = "Aicode?1:0";  
  
    private static final String host = "smtp.exmail.qq.com";  
  
    private static final String port = "465";  
  
    private static final Logger logger = Logger.getLogger(EmailSslUtil.class);  
  
    /*** 
     * 发送项目异常 代码提醒 
     * @param msg 
     */  
    public static boolean sendEmail(String email,String subject,String content) {
        //开启线程异步发送  防止发送请求时间过长  
        new Thread(new Runnable() {  
			@Override  
            public void run() {
            	try {
                    logger.error("===================开始发送邮件================");  
                    Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                    final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
                    //设置邮件会话参数
                    Properties props = new Properties();
                    //邮箱的发送服务器地址
                    props.setProperty("mail.smtp.host",host);
                    props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
                    props.setProperty("mail.smtp.socketFactory.fallback", "false");
                    //邮箱发送服务器端口,这里设置为465端口
                    props.setProperty("mail.smtp.port",port);
                    props.setProperty("mail.smtp.socketFactory.port",port);
                    props.put("mail.smtp.auth", "true");
                    //获取到邮箱会话,利用匿名内部类的方式,将发送者邮箱用户名和密码授权给jvm
                    Session session = Session.getDefaultInstance(props, new Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(userName, password);
                        }
                    });
                    //通过会话,得到一个邮件,用于发送
                    Message msg = new MimeMessage(session);
                    //设置发件人
//                    msg.setFrom(new InternetAddress("service@wtu.cn"));
                    //设置自定义发件人昵称    
                    String nick="";    
                    try {    
                        nick=javax.mail.internet.MimeUtility.encodeText("Reetour");    
                    } catch (UnsupportedEncodingException e) {    
                		logger.error(e.getMessage(),e);
                    }     
                    msg.setFrom(new InternetAddress(nick+" <"+userName+">"));
                    //设置收件人,to为收件人,cc为抄送,bcc为密送
                    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email, false));
//                    msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(to, false));
//                    msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(to, false));
                    msg.setSubject(subject);
                    //设置邮件消息
                    msg.setContent(content, "text/html;charset=utf-8");;
                    //设置发送的日期
                    msg.setSentDate(new Date());
                    //调用Transport的send方法去发送邮件
                    Transport.send(msg);
                    logger.error("==================结束发送邮件================");  
                } catch (Exception e) {
                    logger.error("===================邮件发送错误信息"+e.getMessage()+"================");  
                } 
            }  
        }).start();
        return true;
    }  
  
  
    public static void main(String[] args) {  
        boolean a = sendEmail("785512483@qq.com","代码开始抽风报警了------","测试邮件");  
        logger.error("===================fdfdfdfdd"+a+"================");  

    }  
}