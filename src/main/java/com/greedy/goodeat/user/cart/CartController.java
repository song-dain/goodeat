package com.greedy.goodeat.user.cart;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greedy.goodeat.common.Pagenation;
import com.greedy.goodeat.common.PagingButtonInfo;
import com.greedy.goodeat.common.dto.CartDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user")
public class CartController {
	
	private final CartService cartService;
	
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@GetMapping("/cartList")
	public String cartList(@RequestParam(defaultValue="1") int page,
			@RequestParam(required=false) String searchValue, Model model) {
		
		Page<CartDTO> cartList = cartService.slectCartList(page, searchValue);
		PagingButtonInfo paging = Pagenation.getPagingButtonInfo(cartList);
		
		model.addAttribute("cartList", cartList);
		
		return "user/cart/cart";
	}
}
