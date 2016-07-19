package com.makerstreet.hdb.util;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;

/**
 * 发送者需要把邮箱的 stmp 协议打开，才能发送邮件
 * @author zhuzi
 *
 */
public class SendEmail {
	public  void sedemail(String user_email,HttpServletRequest request,long id){
		try {
			String userName = "njhuidai_company@163.com";//发送者的邮箱名
			String password = "kgycglcgkadgvaer";//发送者的密码
			String smtp_server = "smtp.163.com";//发送邮箱的服务器 SMTP服务器地址 163 的SMTP地址
			String from_mail_address = userName;
			String to_mail_address = user_email;//收件人的邮箱
			Authenticator auth = new PopupAuthenticator(userName, password);
			Properties mailProps = new Properties();
			mailProps.put("mail.smtp.host", smtp_server);
			mailProps.put("mail.smtp.auth", "true");
			mailProps.put("username", userName);
			mailProps.put("password", password);

			Session mailSession = Session.getDefaultInstance(mailProps, auth);
			mailSession.setDebug(true);
			MimeMessage message = new MimeMessage(mailSession);
			message.setFrom(new InternetAddress(from_mail_address));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(
					to_mail_address));
			message.setSubject("慧网金服验证");

			MimeMultipart multi = new MimeMultipart();
			BodyPart textBodyPart = new MimeBodyPart();
			String param ="id="+id+"";
			//进行id参数加密
			param = new String(Email_Base64.encode(param.getBytes()));
			String messageString="http://www.huiwang365.com/custom/renzheng?"+param;
			textBodyPart.setText(messageString);
//			textBodyPart.setContent();
			// textBodyPart.setFileName("37af4739a11fc9d6b311c712.jpg");
			
			request.getSession().getServletContext().getContextPath();

			multi.addBodyPart(textBodyPart);
			message.setContent(multi);
			message.saveChanges();
			Transport.send(message);
		} catch (Exception ex) {
			System.err.println("邮件发送失败的原因是：" + ex.getMessage());
			System.err.println("具体的错误原因");
			ex.printStackTrace(System.err);
		}
	} 
}

class PopupAuthenticator extends Authenticator {
	private String username;
	private String password;

	public PopupAuthenticator(String username, String pwd) {
		this.username = username;
		this.password = pwd;
	}

	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(this.username, this.password);
	}
}