package com.greedy.goodeat.user.member.service;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.greedy.goodeat.common.dto.MemberDTO;
import com.greedy.goodeat.user.member.repository.MemberRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MailSendService {
	
	private final JavaMailSender mailSender;
	private final MemberRepository memberRepository;
	private int authNumber;
	
	public MailSendService(JavaMailSender mailSender, MemberRepository memberRepository) {
		this.mailSender = mailSender;
		this.memberRepository = memberRepository;
	}
	
	public void makeRandomNumber() {
		Random r = new Random();
		int checkNum = r.nextInt(888888) + 111111;
		authNumber = checkNum;
	}
	
	public String makeRandomPwd() {
		
		char[] charSet = new char[] {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
		};
		
		StringBuffer sb = new StringBuffer();
		SecureRandom sr = new SecureRandom();
		sr.setSeed(new Date().getTime());
		
		int idx = 0;
		int len = charSet.length;
		for(int i = 0; i < 10; i++) {
			idx = sr.nextInt(len);
			sb.append(charSet[idx]);
		}

		return sb.toString();
	}
	
	public String sendEmailForm(String email) {

		makeRandomNumber();
		String setFrom = "goodeattest@gmail.com";
		String toMail = email;
		String title = "Good Eat 이메일 인증번호 안내드립니다";
		String content = "<h3>Good Eat 회원가입을 위해 이메일 인증을 완료해주세요.</h3> " 
					   + "<br>"
					   + "인증번호는 <b>" + authNumber + "</b>입니다.";
		mailSend(setFrom, toMail, title, content);
		
		return Integer.toString(authNumber);
	}
	
	public String findPwdEmailForm(MemberDTO member) {
		
		member.setMemberPwd(makeRandomPwd());
		
		String setFrom = "goodeattest@gmail.com";
		String toMail = member.getEmail();
		String title = "[Good Eat] 임시 비밀번호 발급 안내드립니다";
		String content = "<h3>요청하신 GoodEat 임시 비밀번호입니다.</h3> " 
					   + "<br>"
					   + "회원님의 임시 비밀번호는 <b>" + member.getMemberPwd() + "</b>입니다.";
		mailSend(setFrom, toMail, title, content);
		
		return member.getMemberPwd();
		
	}
	
	public void findIdEmailForm(String findId, String email) {
		
		log.info("[MailSendService] email : {} ", email);
		log.info("[MailSendService] findId : {} ", findId);
		
		String setFrom = "goodeattest@gmail.com";
		String toMail = email;
		String title = "[Good Eat] 요청하신 아이디 안내드립니다";
		String content = "<h3>요청하신 GoodEat 아이디 안내드립니다.</h3> " 
					   + "<br>"
					   + "회원님의 아이디는 <b>" + findId + "</b>입니다.";
		mailSend(setFrom, toMail, title, content);
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
