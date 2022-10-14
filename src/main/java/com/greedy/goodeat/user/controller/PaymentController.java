package com.greedy.goodeat.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greedy.goodeat.common.dto.MemberDTO;
import com.greedy.goodeat.common.dto.OrderPageDTO;
import com.greedy.goodeat.common.dto.OrderPageItemDTO;
import com.greedy.goodeat.user.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user")
public class PaymentController {
	
	private final PaymentService paymentService;
	
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	

	@PostMapping("/payment")
	public String memberList(OrderPageDTO opd, Model model,OrderPageItemDTO orders) {
		
		int memberNo = 2;
		
		MemberDTO member = paymentService.selectMember(memberNo);
		
		model.addAttribute("order", opd.getOrders());
		model.addAttribute("ordertotal", opd.getTotalPrice());
		
		model.addAttribute("member", member);
		
		System.out.println("orders : " + opd.getOrders());
		System.out.println(opd.getTotalPrice());
		
		return "user/cart/payment";
	}
	
	@GetMapping("/complete")
	public String goComplete() {
		
		return "user/cart/complete";
	}
	@PostMapping("/complete")
	public String complete() {
		
		return "user/cart/complete";
	}
	
}