package com.greedy.goodeat.admin.inquiry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greedy.goodeat.admin.inquiry.dto.ReplyDTO;
import com.greedy.goodeat.admin.inquiry.dto.SYInquiryDTO;
import com.greedy.goodeat.admin.inquiry.service.AdmInquiryService;
import com.greedy.goodeat.common.dto.MemberDTO;
import com.greedy.goodeat.common.paging.Pagenation;
import com.greedy.goodeat.common.paging.PagingButtonInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin/inquiry")
public class AdmInquiryController {

	@Value("${image.image-dir}")
	private String IMAGE_DIR;
	
	private final AdmInquiryService admInquiryService;
	private final MessageSourceAccessor messageSourceAccessor;
	
	public AdmInquiryController (AdmInquiryService admInquiryService,
								 MessageSourceAccessor messageSourceAccessor) {
		
		this.admInquiryService = admInquiryService;
		this.messageSourceAccessor = messageSourceAccessor;
	}
	
	@GetMapping("list")
	public String inquiryList(@RequestParam(defaultValue="1") int page, 
			@RequestParam(required=false) String searchValue, Model model) {
		
		Page<SYInquiryDTO> inquiryList = admInquiryService.findInqList(page, searchValue);
		PagingButtonInfo paging = Pagenation.getPagingButtonInfo(inquiryList);
		
		
		model.addAttribute("paging", paging);
		model.addAttribute("inquiryList", inquiryList);
		
		if(searchValue !=null && !searchValue.isEmpty()) {
			model.addAttribute("searchValue", searchValue);
		}
		
		return "/admin/inquiry/adm-inquiry";
	}
	
	@GetMapping("/detail")
	public String inquiryList(Model model, Integer inquiryCode) {
		
		SYInquiryDTO inquiry = admInquiryService.selectInqDetail(inquiryCode);
		model.addAttribute("inquiry", inquiry);
		
		return "admin/inquiry/adm-detailinquiry";
		
	}
	
	@GetMapping("/delete")
	public String inquiryDelete(Integer inquiryCode) {
		admInquiryService.deleteInquiry(inquiryCode);
		return "redirect:/admin/inquiry/list";
	}
	
	@PostMapping("/registReply") 
	public ResponseEntity<String> registReply(@RequestBody ReplyDTO registReply,
			@AuthenticationPrincipal MemberDTO member) {
		
		log.info("[ReplyController] registReply : {}", registReply);
		registReply.setMember(member);
		admInquiryService.registReply(registReply);
		
		return ResponseEntity.ok("댓글 등록 완료");
	}
	
	@GetMapping("/loadReply")
	public ResponseEntity<List<ReplyDTO>> loadReply(ReplyDTO loadReply) {
	
		List<ReplyDTO> replyList = admInquiryService.loadReply(loadReply);
		log.info("[ReplyController] replyList : {}", replyList);
		return ResponseEntity.ok(replyList);
		
	}
	
	@PostMapping("/removeReply")
	public ResponseEntity<String> removeReply(@RequestBody ReplyDTO removeReply) {
		
		admInquiryService.removeReply(removeReply);
		
		return ResponseEntity.ok("댓글 삭제 완료");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
