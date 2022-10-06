package com.greedy.goodeat.admin.inquiry;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdmInquiryController {

	@GetMapping("/inquiry")
	public String inquiryList() {
		
		return "/admin/inquiry/adm-inquiry";
	}
}
