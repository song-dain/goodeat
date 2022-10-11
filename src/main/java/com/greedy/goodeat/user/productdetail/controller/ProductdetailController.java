package com.greedy.goodeat.user.productdetail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.greedy.goodeat.common.dto.MemberDTO;
import com.greedy.goodeat.common.dto.ProductDTO;
import com.greedy.goodeat.common.dto.ReviewDTO;
import com.greedy.goodeat.common.paging.Pagenation;
import com.greedy.goodeat.common.paging.PagingButtonInfo;
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
	
	@GetMapping("/productdetail")
	public String productdetailList(Integer productCode, @RequestParam(defaultValue="1") int page,
								@RequestParam(required=false) String searchValue, Model model) {
		
		ProductDTO product = productService.selectProduct(productCode);
		
		log.info("product : {}", product);
		model.addAttribute("product", product);
		
		Page<ReviewDTO> reviewList = reviewService.selectReviewList(page, searchValue);
		PagingButtonInfo paging = Pagenation.getPagingButtonInfo(reviewList);
		
		log.info("reviewList : {}", reviewList);
		log.info("paing : {}", paging);
		
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("paging", paging);
		
		return "user/productdetail";
	}

	@GetMapping("/registReview")
	public String registReview(ReviewDTO review, @AuthenticationPrincipal MemberDTO member, RedirectAttributes rttr ) {
		
		log.info("registRview request : {}", review );
		
		review.setMember(member);
		reviewService.registReview(review);
		
		rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("review.regist"));
		
		return "redirect:/";
		
	}
		
	
}