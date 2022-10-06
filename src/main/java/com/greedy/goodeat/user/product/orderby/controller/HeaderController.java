package com.greedy.goodeat.user.product.orderby.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class HeaderController {

//	private ProductService productService;
//	
//	@Autowired 
//	public HeaderController(ProductService productService) {
//		this.productService = productService;
//	}
//	
	
	@GetMapping("/mil")
	public String milMapping() {
	
		
		return "/user/product/productmain/mil";
	}
	
	
	@GetMapping("/lunchbox")
	public String lunchboxMapping() {
	
		
		return "/user/product/productmain/lunchbox";
	}
	
	
	@GetMapping("/chicken")
	public String chickenbreastMapping() {
	
		
		return "user/product/productmain/chickenbreast";
	}
	
	@GetMapping("/convenince")
	public String conveninceMapping() {
	
		
		return "user/product/productmain/convenince";
	}
	
	@GetMapping("/vegan")
	public String veganMapping() {
	
		
		return "user/product/productmain/vegan";
	}
	 		
	
	
	 			
}
