package com.greedy.goodeat.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greedy.goodeat.common.dto.CartDTO;
import com.greedy.goodeat.common.dto.CartListDTO;
import com.greedy.goodeat.user.service.CartService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user")
public class CartController {
	
	private CartService cartService;
	
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@GetMapping("/cartList")
	public String cartList(Model model) {
		
		log.info("[CartController] ========================================= ");
		
		List<CartListDTO> cartList = cartService.selectCartList();
		
		log.info("[CartController] cartList : {}", cartList);
		
		model.addAttribute("cartList", cartList);
		
		
		log.info("[CartController] ========================================= ");
		
		return "user/cart/cart";
	}
	
	@PostMapping("/cart/update") 
	public String updateCartPOST(CartDTO cart){
		
		
		return "redirect:/user/cart/";
		
	}
	
}
