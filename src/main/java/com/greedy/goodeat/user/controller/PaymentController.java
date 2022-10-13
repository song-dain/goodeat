package com.greedy.goodeat.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greedy.goodeat.common.dto.CartListDTO;
import com.greedy.goodeat.user.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user")
public class PaymentController {
	

	@GetMapping("/payment")
	public String cartList(Model model) {
		
		
		return "user/cart/payment";
	}
	
	@GetMapping("/complete")
	public String complete() {
		
		return "user/cart/complete";
	}
	
}