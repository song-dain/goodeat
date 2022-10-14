package com.greedy.goodeat.admin.review.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greedy.goodeat.admin.inquiry.dto.ReplyDTO;
import com.greedy.goodeat.admin.review.service.AdmReviewService;
import com.greedy.goodeat.common.dto.ReviewDTO;
import com.greedy.goodeat.common.paging.Pagenation;
import com.greedy.goodeat.common.paging.PagingButtonInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin/review")
public class AdmReviewController {
	
	@Value("${image.image-dir}")
	private String IMAGE_DIR;
	
	private final AdmReviewService admReviewService;
	private final MessageSourceAccessor messageSourceAccessor;
	
	public AdmReviewController(AdmReviewService admReviewService,
			MessageSourceAccessor messageSourceAccessor) {
		
		this.admReviewService = admReviewService;
		this.messageSourceAccessor = messageSourceAccessor;
		
	}
	
	@GetMapping("/list")
	public String reviewList(@RequestParam(defaultValue="1") int page, 
			@RequestParam(required=false) String searchValue, Model model) {
		
		Page<ReviewDTO> reviewList = admReviewService.findReviewList(page, searchValue);
		PagingButtonInfo paging = Pagenation.getPagingButtonInfo(reviewList);
		
		model.addAttribute("paging", paging);
		model.addAttribute("reviewList", reviewList);
		
		if(searchValue !=null && !searchValue.isEmpty()) {
			model.addAttribute("searchValue", searchValue);
		}
		
		return "/admin/review/adm-review";
	}
	
	@GetMapping("/detail")
	public String reviewList(Model model, Integer reviewCode) {
		
		ReviewDTO review = admReviewService.selectReviewDetail(reviewCode);
		log.info("[BoardController] review : {}", review);
		model.addAttribute("review", review);
		
		return "admin/review/adm-detailreview";
		
	}

}
