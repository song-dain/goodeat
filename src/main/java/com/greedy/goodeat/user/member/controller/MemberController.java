package com.greedy.goodeat.user.member.controller;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.greedy.goodeat.common.dto.MemberDTO;
import com.greedy.goodeat.user.member.service.MailSendService;
import com.greedy.goodeat.user.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
	
	private final PasswordEncoder passwordEncoder;
	private final MemberService memberService;
	private final MailSendService mailSendService;
	private final MessageSourceAccessor messageSourceAccessor;
	
	public MemberController(MemberService memberService, PasswordEncoder passwordEncoder, 
			MessageSourceAccessor messageSourceAccessor, MailSendService mailSendService) {
		this.memberService = memberService;
		this.passwordEncoder = passwordEncoder;
		this.messageSourceAccessor = messageSourceAccessor;
		this.mailSendService = mailSendService;
	}
	
	@GetMapping("/login")
	public String goLogin() {
		return "user/login/login";
	}
	
	@GetMapping("/join")
	public String goJoin() {
		return "user/join/join";
	}
	
	@PostMapping("/idDupCheck")
	public ResponseEntity<String> checkDuplication(@RequestBody MemberDTO member){
		
		String result = "canUse";
		
		if(memberService.selectMemberById(member.getMemberId())) {
			result = "cannotUse";
		}
		
		return ResponseEntity.ok(result);
	}
	
	@ResponseBody
	@PostMapping(value = "/emailCheck", produces="text/html; charset=UTF-8")
	public String emailCheck(@RequestBody MemberDTO member){
		
		return mailSendService.sendEmailForm(member.getEmail());
	}
	
	
	@PostMapping("/join")
	public String joinMembership(@ModelAttribute MemberDTO member, String email, String email2, 
				String year, String month, String day, RedirectAttributes rttr) {
		
		member.setMemberPwd(passwordEncoder.encode(member.getMemberPwd()));
		member.setEmail(email + "@" + email2);
		
		if(!year.equals("") && !month.equals("") && !day.equals("")) {
			java.sql.Date birthDate = java.sql.Date.valueOf(year + "-" + month + "-" + day);
			member.setBirthDate(birthDate);
		}	
		
		member.setPhone(member.getPhone().replace("-", ""));
		
		memberService.joinMembership(member);
		
		rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.join"));
		
		return "redirect:/login";
	}

	

}
