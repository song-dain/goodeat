package com.greedy.goodeat.user.controller;

import java.util.List;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greedy.goodeat.common.dto.CartListDTO;
import com.greedy.goodeat.common.dto.MemberDTO;
import com.greedy.goodeat.user.service.CartService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user")
public class CartController {
	
	private final CartService cartService;
	private final MessageSourceAccessor messageSourceAccessor;
	
	public CartController(CartService cartService, MessageSourceAccessor messageSourceAccesor) {
		this.cartService = cartService;
		this.messageSourceAccessor = messageSourceAccesor;
	}

	@GetMapping("/cartList")
	public String cartList(CartListDTO cart, @AuthenticationPrincipal MemberDTO member, Model model) {
		
		log.info("[CartController] ========================================= ");
		
		List<CartListDTO> cartList = cartService.selectCartList();
		
		log.info("[CartController] cartList : {}", cartList);
		
		
		model.addAttribute("cartList", cartList);
		
		
		log.info("[CartController] ========================================= ");
		
		return "user/cart/cart";
	}
	
	
//	@PostMapping("/update") public String updateCartPOST(@ModelAttribute
//	  CartListDTO updateCart,
//	  
//	  @RequestParam String cartId, @RequestParam String productCount ,
//	  RedirectAttributes rttr){
//	  
//	  log.info("[CartContorller] modifyCart =============================");
//	  
//	  //updateCart.setCartCode(Integer.parseInt(cartId));
//	  updateCart.setProductAmount(Integer.parseInt(productCount));
//	  updateCart.setMemberNo(2);
//	  
//	  log.info("[CartContorller] modifyCart request Cart : {}", updateCart);
//	  
//	  cartService.updateCartList(updateCart);
//	  
//	  rttr.addFlashAttribute("message",
//	  messageSourceAccessor.getMessage("cart.update"));
//	  
//	  
//	  return "redirect:/user/cartList";
//	  
//	  }
	 
	
}
