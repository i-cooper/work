package com.juvenxu.mvnbook.account.email;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class AccountEmailServiceImpl implements AccountEmailService {

	private JavaMailSender javaMailSender;
	private String systemEmail;
	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}
	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	public String getSystemEmail() {
		return systemEmail;
	}
	public void setSystemEmail(String systemEmail) {
		this.systemEmail = systemEmail;
	}
	
	public void sendMail(String to, String subject, String htmlText) throws Exception {

		try{
			MimeMessage msg=javaMailSender.createMimeMessage();
			MimeMessageHelper msgHelper=new MimeMessageHelper(msg);
			msgHelper.setFrom(systemEmail);
			msgHelper.setTo(to);
			msgHelper.setSubject(subject);
			msgHelper.setText(htmlText,true);
			javaMailSender.send(msg);
		}
		catch(Exception e)
		{
			throw new Exception("Failed to send email:"+e);
		}
		
	}

}
