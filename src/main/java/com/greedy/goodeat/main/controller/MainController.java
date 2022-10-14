package com.greedy.goodeat.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
	
	@GetMapping(value = {"/", "/main"})
	public String main() {
		
		return "main/main";
	}
	
	@PostMapping("/")
	public String redirectMain() {
		
		return "redirect:/";
	}
	
	@GetMapping("/main2")
	public String main2() {
		
		return "main/main2";
	}
	
}







