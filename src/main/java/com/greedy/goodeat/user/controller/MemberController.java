package com.greedy.goodeat.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@GetMapping("/login")
	public String goLogin() {
		return "user/login/login";
	}
	

}
