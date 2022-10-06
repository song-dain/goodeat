package com.greedy.goodeat.admin.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ProductController {
	
	@GetMapping("/productList")
	public String productList() {
		
		return "admin/product/adm-product";
	}
	
	@GetMapping("/order")
	public String orderList() {
		
		return "admin/order/adm-order";
	}
	
	

}
