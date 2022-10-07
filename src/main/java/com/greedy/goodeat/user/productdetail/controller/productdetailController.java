package com.greedy.goodeat.user.productdetail.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class productdetailController {

	@GetMapping("/productdetail")
	public String getproductdetail() {
		
		return "/user/productdetail/product-list";
		
	}
	
}