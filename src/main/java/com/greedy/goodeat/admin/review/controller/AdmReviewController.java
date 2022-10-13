package com.greedy.goodeat.admin.review.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdmReviewController {
	
	@GetMapping("/review")
	public String reviewList() {
		
		return "/admin/review/adm-review";
	}

}
