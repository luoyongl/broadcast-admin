package cn.wtu.broadcast.parent.utils;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class EmailUtil {
	
	private static Logger logger = LoggerFactory.getLogger(EmailUtil.class);

	
	public static void send(String emailAddress, String newPassword) {
		boolean isSSL = true;
		String host = "smtp.exmail.qq.com";
		int port = 465;
		String from = "service@wtu.cn";
		boolean isAuth = true;
		final String username = "service@wtu.cn";
		final String password = "Aicode?1:0";
		Properties props = new Properties();
		props.put("mail.smtp.ssl.enable", isSSL);
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", isAuth);
		Session session = Session.getDefaultInstance(props,
				new Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailAddress));
			message.setSubject("密码重置成功");
			message.setText("密码重置为："+newPassword+",\r\n本次邮件由系统发出,请勿回复");
			Transport.send(message);
		} catch (AddressException e) {
			logger.error(e.getMessage(),e);
		} catch (MessagingException e) {
			logger.error(e.getMessage(),e);
		}
	}
	
	public static void main(String[] args) {
		String code = String.valueOf((int)((Math.random()*9+1)*1000));
		logger.info(code);
		send("972916023@qq.com", code);
	}
}
