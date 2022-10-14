package com.greedy.goodeat.user.product.orderby.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greedy.goodeat.common.dto.ProductDTO;
import com.greedy.goodeat.common.entity.ProductCategory;
import com.greedy.goodeat.common.paging.Pagenation;
import com.greedy.goodeat.common.paging.PagingButtonInfo;
import com.greedy.goodeat.user.product.orderby.service.ProductListService;

@Controller
@RequestMapping("/user")
public class ProductListController {
	
	private final ProductListService productListService;
	
	public ProductListController(ProductListService productListService) {
		this.productListService = productListService;
	}
	
	@PostMapping("/chicken")
	public String chickenbreastProductList(@RequestParam(defaultValue="1") int page, Model model) {
		
		ProductCategory category = new ProductCategory();
		category.setCategoryCode(1);
		
		Page<ProductDTO> productList = productListService.productList(page, category);
		PagingButtonInfo paging = Pagenation.getPagingButtonInfo(productList);
		
		model.addAttribute("productList", productList);
		model.addAttribute("paging", paging);
		
		return "/user/productmain/chickenbreast";
		
	}

	
	

}
