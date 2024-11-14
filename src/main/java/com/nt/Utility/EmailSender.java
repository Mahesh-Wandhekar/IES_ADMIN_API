package com.nt.Utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailSender {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public boolean sendEmail(String to,String body,String subject) {
		boolean issent=false;
		try {
		MimeMessage mime= javaMailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(mime);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(body, true);
		javaMailSender.send(mime);
		issent=true;
		} catch (MessagingException e) {
		}
		
		return true;
	}
}
