package com.greedy.goodeat.user.member.service;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MailSendService {
	
	private final JavaMailSender mailSender;
	private int authNumber;
	
	public MailSendService(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void makeRandomNumber() {
		Random r = new Random();
		int checkNum = r.nextInt(888888) + 111111;
		log.info("[MailSendService] checkNum : {} ", checkNum);
		authNumber = checkNum;
	}
	
	public String sendEmailForm(String email) {
		
		log.info("[MailSendService] email : {} ", email);
		
		makeRandomNumber();
		String setFrom = "goodeattest@gmail.com";
		String toMail = email;
		String title = "Good Eat 회원가입 인증 이메일입니다";
		String content = "<h3>Good Eat 회원가입을 위해 이메일을 인증해주세요.</h3> " 
					   + "<br>"
					   + "인증번호는 <b>" + authNumber + "</b>입니다.";
		mailSend(setFrom, toMail, title, content);
		
		return Integer.toString(authNumber);
	}
	
	public void mailSend(String setFrom, String toMail, String title, String content) {
		
		MimeMessage message = mailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content,true);
			mailSender.send(message);
		} catch(MessagingException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
}
