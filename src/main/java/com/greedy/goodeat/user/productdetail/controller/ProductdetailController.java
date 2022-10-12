package com.greedy.goodeat.user.productdetail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.greedy.goodeat.common.dto.MemberDTO;
import com.greedy.goodeat.common.dto.PostDTO;
import com.greedy.goodeat.common.paging.Pagenation;
import com.greedy.goodeat.common.paging.PagingButtonInfo;
import com.greedy.goodeat.user.productdetail.hgdto.hgProductDTO;
import com.greedy.goodeat.user.productdetail.hgdto.hgReviewDTO;

import com.greedy.goodeat.user.productdetail.service.ProductService;
import com.greedy.goodeat.user.productdetail.service.ReviewService;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user")
public class ProductdetailController {
	
	@Autowired
	private final ReviewService reviewService;
	private final ProductService productService;
	private final MessageSourceAccessor messageSourceAccessor;

	
	
	public ProductdetailController(ReviewService reviewService, ProductService productService,
							 MessageSourceAccessor messageSourceAccessor) {
		this.reviewService = reviewService;
		this.productService = productService;
		this.messageSourceAccessor = messageSourceAccessor;
	}
	
	@GetMapping("/productdetail/list")
	public String productdetailList(Integer productCode, @RequestParam(defaultValue="1") int page,
								@RequestParam(required=false) String searchValue, Model model) {
		//리뷰리스트
		hgProductDTO hgproduct = productService.selecthgProduct(productCode);
		
		log.info("hgproduct : {}", hgproduct);
		model.addAttribute("hgproduct", hgproduct);
		
		Page<hgReviewDTO> hgreviewList = reviewService.selectReviewList(page, searchValue);
		PagingButtonInfo paging = Pagenation.getPagingButtonInfo(hgreviewList);
		
		log.info("hgreviewList : {}", hgreviewList);
		log.info("paing : {}", paging);
		
		model.addAttribute("hgreviewList", hgreviewList);
		model.addAttribute("paging", paging);
		
		return "user/productdetail/product-list";
	}

	@GetMapping("/productdetail/list/regist")
	public String goRegist() {
		
		return "user/productdetail/registReview";
	}
	
	@PostMapping("/list/regist")
	public String registReview(Model model, hgReviewDTO newReview, RedirectAttributes rttr) {
		
		log.info("[PostController] =======================");
		
		
		reviewService.registReview(newReview);
		
		model.addAttribute("newReview", newReview);
		
		log.info("[ReviewController] newReview : {} ", newReview);
        rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("review.regist"));
		
		
		return "redirect:/user/productdetail/product-list";
	}
		
	
}