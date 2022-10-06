package com.greedy.goodeat.admin.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdmMemberController {
	
	@GetMapping("/member")
	public String memberList() {
		
		return "admin/member/adm-member";
	}

}
