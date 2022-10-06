package com.greedy.goodeat.admin.product.controller;



import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.greedy.goodeat.admin.product.service.AdmProductService;
import com.greedy.goodeat.common.dto.ProductDTO;
import com.greedy.goodeat.common.paging.Pagenation;
import com.greedy.goodeat.common.paging.PagingButtonInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdmProductController {
	
	private final AdmProductService admProductService;
	private final MessageSourceAccessor messageSourceAccessor;
	
	public AdmProductController(AdmProductService admProductService, MessageSourceAccessor messageSourceAccessor) {
		
		this.admProductService = admProductService;
		this.messageSourceAccessor = messageSourceAccessor;
	}
	
	@GetMapping("/productList")
	public String productList(@PageableDefault Pageable pageable, Model model) {
		
		log.info("[ProductController] =======================");
		
		Page<ProductDTO> productList = admProductService.findProductList(pageable);
		PagingButtonInfo paging = Pagenation.getPagingButtonInfo(productList);
		
		model.addAttribute("productList", productList);
		model.addAttribute("paging", paging);
		
		log.info("[ProductController] productList : {}",productList );
		
		log.info("[ProductController] =======================");
		
		return "admin/product/adm-product";
	}
	
//	@GetMapping(value="/category", produces="application/json; charset=UTF-8")
//	@ResponseBody
//	public List<ProductCategoryDTO> findCategoryList(){
//		
//		return productService.findAllCategory();
//	}
	
	@GetMapping("/productRegist")
	public String productRegistPage() {
		return "admin/product/adm-productregist";
	}
	
	@PostMapping("/productRegist")
	public String productRegist(Model model, ProductDTO newProduct, RedirectAttributes rttr) {
		
		log.info("[ProductController] =======================");
	
		log.info("[ProductController] newProduct : {}",newProduct );
		admProductService.registProduct(newProduct);
		
		model.addAttribute("newProduct", newProduct);
		rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("product.regist"));
		
		log.info("[ProductController] =======================");
		
		return "redirect:/admin/productList";
		
	}
	

}
