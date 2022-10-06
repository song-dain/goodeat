package com.greedy.goodeat.admin.post.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdmPostController {
	
	@GetMapping("/post")
	public String postList() {
		
		return "/admin/post/adm-post";
	}
	
}
