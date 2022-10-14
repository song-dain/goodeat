package com.greedy.goodeat.admin.order.controller;


import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.greedy.goodeat.admin.order.dto.JyDeliveryDTO;
import com.greedy.goodeat.admin.order.service.AdmOrderService;



@Controller
@RequestMapping("/admin")
public class AdmDeliveryController {
	
	private final AdmOrderService admOrderService;
	private final MessageSourceAccessor messageSourceAccessor;
	
	public AdmDeliveryController(AdmOrderService admOrderService, MessageSourceAccessor messageSourceAccessor) {
		
		this.admOrderService = admOrderService;
		this.messageSourceAccessor = messageSourceAccessor;
		
	}
	
	
	@PostMapping("/deliveryModify")
	public String deliveryModify(Model model, JyDeliveryDTO delivery, RedirectAttributes rttr) {
		
		admOrderService.modifyDelivery(delivery);
		
		model.addAttribute(delivery);
		rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("deliveryModify.success"));
		
		return "redirect:/admin/orderList";
		
		
	}
	

}