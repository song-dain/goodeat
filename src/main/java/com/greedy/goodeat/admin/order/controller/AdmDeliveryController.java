package com.greedy.goodeat.admin.order.controller;

import java.util.List;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.greedy.goodeat.admin.order.service.AdmOrderService;
import com.greedy.goodeat.common.dto.DeliveryDTO;

import lombok.extern.slf4j.Slf4j;


@Slf4j
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
	public String deliveryModify(Model model, DeliveryDTO delivery) {
		
		admOrderService.modifyDelivery(delivery);
		
		model.addAttribute(delivery);
		
		return "redirect:/admin/orderList";
		
		
	}
	

}
