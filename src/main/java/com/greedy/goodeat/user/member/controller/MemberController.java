package com.greedy.goodeat.user.member.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.greedy.goodeat.common.dto.MemberDTO;
import com.greedy.goodeat.user.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
	
	private final PasswordEncoder passwordEncoder;
	public final MemberService memberService;
	
	public MemberController(MemberService memberService, PasswordEncoder passwordEncoder) {
		this.memberService = memberService;
		this.passwordEncoder = passwordEncoder;
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
	public ResponseEntity<Boolean> checkDuplication(@RequestBody MemberDTO member){
		
		boolean result = true;
		
		if(memberService.selectMemberById(member.getMemberId())) {
			result = false;
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

//		java.sql.Date birthDate = java.sql.Date.valueOf(year + "-" + month + "-" + day);
//		member.setBirthDate(birthDate);
		member.setPhone(member.getPhone().replace("-", ""));
		
		log.info("[MemberController] joinMember request Member : " + member); 
		
		memberService.joinMembership(member);
		
		return "redirect:/";
		
		
	}

	

}
