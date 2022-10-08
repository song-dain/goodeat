package com.greedy.goodeat.user.member.controller;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.greedy.goodeat.common.dto.MemberDTO;
import com.greedy.goodeat.user.member.service.MemberService;

@Controller
public class MemberController {
	
	private final PasswordEncoder passwordEncoder;
	public final MemberService memberService;
    private final MessageSourceAccessor messageSourceAccessor;
	
	public MemberController(MemberService memberService, PasswordEncoder passwordEncoder, MessageSourceAccessor messageSourceAccessor) {
		this.memberService = memberService;
		this.passwordEncoder = passwordEncoder;
		this.messageSourceAccessor = messageSourceAccessor;
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
	
	@PostMapping("/join")
	public String joinMembership(@ModelAttribute MemberDTO member, String email, String email2, 
				String year, String month, String day) {
		
		member.setMemberPwd(passwordEncoder.encode(member.getMemberPwd()));
		
		if(email2.equals("직접입력")) {
			member.setEmail(email);
		} else {
			member.setEmail(email + "@" + email2);
		}
		
		if(!year.equals("") && !month.equals("") && !day.equals("")) {
			java.sql.Date birthDate = java.sql.Date.valueOf(year + "-" + month + "-" + day);
			member.setBirthDate(birthDate);
		}	
		
		member.setPhone(member.getPhone().replace("-", ""));
		
		memberService.joinMembership(member);
		
		return "/user/login/login";
		
	}

	

}
