package com.greedy.goodeat.user.productdetail.controller;

import org.springframework.context.support.MessageSourceAccessor; 
import org.springframework.data.domain.Page; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestParam;

import com.greedy.goodeat.admin.inquiry.dto.SYInquiryDTO;
import com.greedy.goodeat.common.dto.InquiryDTO; 
import com.greedy.goodeat.common.paging.Pagenation; 
import com.greedy.goodeat.common.paging.PagingButtonInfo; 
import com.greedy.goodeat.user.productdetail.hgdto.hgProductDTO;  
import com.greedy.goodeat.user.productdetail.service.InquiryService; 
import com.greedy.goodeat.user.productdetail.service.ProductService; 
import lombok.extern.slf4j.Slf4j;

@Slf4j

@Controller

@RequestMapping("/user/inquiry") 
public class InquiryController {

	private final InquiryService inquiryService; 
	private final MessageSourceAccessor messageSourceAccessor;
	
	public InquiryController (InquiryService inquiryService, MessageSourceAccessor messageSourceAccessor) {
	 
			this.inquiryService = inquiryService; 
			this.messageSourceAccessor = messageSourceAccessor;
		}
	
	@GetMapping("/list")
	public String inquiryList(@RequestParam(defaultValue="1") int page, 
			@RequestParam(required=false) String searchValue, Model model) {
		
		Page<SYInquiryDTO> inquiryList = inquiryService.findInquiryList(page, searchValue);
		PagingButtonInfo paging = Pagenation.getPagingButtonInfo(inquiryList);
		
		log.info("[InquiryController] =============================== ");
		log.info("[InquiryController] inquiryList : {}", inquiryList);
		
		model.addAttribute("paging", paging);
		model.addAttribute("inquiryList", inquiryList);
		
		if(searchValue !=null && !searchValue.isEmpty()) {
			model.addAttribute("searchValue", searchValue);
		}
		
		
		return "/user/inquiry/listInquiry";
	}
	
	}
