package com.greedy.goodeat.admin.order.controller;
 
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestClientException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.greedy.goodeat.admin.order.dto.JyOrderDTO;
import com.greedy.goodeat.admin.order.dto.MessageDTO;
import com.greedy.goodeat.admin.order.dto.SmsResponseDTO;
import com.greedy.goodeat.admin.order.service.AdmOrderService;
import com.greedy.goodeat.admin.order.service.SmsService;

@Controller
@RequestMapping("/admin")
public class SmsController {
	
	private final SmsService smsService;
	private final AdmOrderService admOrderService;
	private final MessageSourceAccessor messageSourceAccessor;
	
	
	public SmsController(SmsService smsService, MessageSourceAccessor messageSourceAccessor, AdmOrderService admOrderService) {
		
		this.smsService = smsService;
		this.admOrderService = admOrderService;
		this.messageSourceAccessor = messageSourceAccessor;
		
	}
	

	@PostMapping("/sms/send")
	public String sendSms(MessageDTO messageDto, Model model,RedirectAttributes rttr) throws JsonProcessingException, RestClientException, URISyntaxException, InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
		SmsResponseDTO response = smsService.sendSms(messageDto);
		model.addAttribute("response", response);
		rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("sms.success"));
		return "redirect:/admin/orderList";
	}
 
	
}