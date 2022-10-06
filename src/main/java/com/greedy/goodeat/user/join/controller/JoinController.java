package com.greedy.goodeat.user.join.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.greedy.goodeat.common.dto.MemberDTO;

@Controller
public class JoinController {
	
	@GetMapping("/join")
	public String goJoin() {
		return "user/join/join";
	}
	
	@PostMapping("/checkId")
	public ResponseEntity<String> checkId(@RequestBody MemberDTO member){
		
		String result = "사용 가능한 아이디입니다.";
		
		
	}

}
