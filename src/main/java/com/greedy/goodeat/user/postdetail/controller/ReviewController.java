//package com.greedy.goodeat.user.postdetail.controller;
//
//import org.springframework.context.support.MessageSourceAccessor;
//import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.greedy.goodeat.common.dto.ReviewDTO;
//import com.greedy.goodeat.common.paging.Pagenation;
//import com.greedy.goodeat.common.paging.PagingButtonInfo;
//import com.greedy.goodeat.user.postdetail.repository.ReviewService;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Controller
//@RequestMapping("/postdetail")
//public class ReviewController {
//
//	private final ReviewService reviewService;
//	private final MessageSourceAccessor messageSourceAccesor;
//	
//	public ReviewController(ReviewService reviewService, MessageSourceAccessor messageSourceAccesor) {
//		this.reviewService = reviewService;
//		this.messageSourceAccesor = messageSourceAccesor;
//	}
//	
//	@GetMapping("/product-list")
//	public String reviewList(@RequestParam(defaultValue="1") int page, 
//			@RequestParam(required=false) String searchValue, Model model) {
//		
//		log.info("[ReviewController] ========================================= ");
//		log.info("[ReviewController] param page : {}", page);
//		log.info("[ReviewController] param searchValue : {}", searchValue);
//		
//		Page<ReviewDTO> reviewList = (reviewService).selectReviewList(page, searchValue);
//		PagingButtonInfo paging = Pagenation.getPagingButtonInfo(reviewList);
//		
//		log.info("[ReviewController] reviewList : {}", reviewList);
//		log.info("[ReviewController] paging : {}", paging);
//		
//		model.addAttribute("reviewList", reviewList);
//		model.addAttribute("paging", paging);
//		if(searchValue != null && !searchValue.isEmpty()) {
//			model.addAttribute("searchValue", searchValue);
//		}
//		
//		log.info("[ReviewController] ========================================= ");
//		
//		return "/productdetail/product-list";
//	}
//	
//}
