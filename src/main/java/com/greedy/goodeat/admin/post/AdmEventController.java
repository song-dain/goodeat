package com.greedy.goodeat.admin.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdmEventController {
	
	@GetMapping("/event")
	public String eventList() {
		
		return "/admin/post/adm-event";
	}

}
