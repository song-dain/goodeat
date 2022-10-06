package com.greedy.goodeat.user.member.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.greedy.goodeat.common.dto.MemberDTO;
import com.greedy.goodeat.config.SpringSecurityConfiguration;
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
	public ResponseEntity<String> checkDuplication(@RequestBody MemberDTO member){
		
		String result = "사용 가능한 아이디입니다.";
		
		if(memberService.selectMemberById(member.getMemberId())) {
			result = "중복된 아이디가 존재합니다.";
		}
		
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/join")
	public String joinMembership(@ModelAttribute MemberDTO member) {
		
		member.setMemberPwd(passwordEncoder.encode(member.getMemberPwd()));
		member.setPhone(member.getPhone().replace("-", ""));
		
		log.info("[MemberController] registMember request Member : " + member);
		
		memberService.joinMembership(member);
		
		return "redirect:/";
		
		
	}

	

}
