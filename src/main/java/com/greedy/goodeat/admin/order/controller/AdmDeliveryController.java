package com.greedy.goodeat.admin.order.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greedy.goodeat.admin.order.dto.JyDeliveryDTO;
import com.greedy.goodeat.admin.order.service.AdmOrderService;



@Controller
@RequestMapping("/admin")
public class AdmDeliveryController {
	
	private final AdmOrderService admOrderService;
	
	public AdmDeliveryController(AdmOrderService admOrderService) {
		
		this.admOrderService = admOrderService;
		
	}
	
	
	@PostMapping("/deliveryModify")
	public String deliveryModify(Model model, JyDeliveryDTO delivery) {
		
		admOrderService.modifyDelivery(delivery);
		
		model.addAttribute(delivery);
		
		return "redirect:/admin/orderList";
		
		
	}
	

}
