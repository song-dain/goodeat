package com.greedy.goodeat.user.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String goLogin() {
		return "user/login/login";
	}
}
