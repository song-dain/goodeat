package com.greedy.goodeat.admin.member.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greedy.goodeat.admin.member.dto.AdmJyMemberDTO;
import com.greedy.goodeat.admin.member.service.AmdMemberService;
import com.greedy.goodeat.admin.product.dto.KjyProductDTO;
import com.greedy.goodeat.common.paging.Pagenation;
import com.greedy.goodeat.common.paging.PagingButtonInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdmMemberController {
	
	private final AmdMemberService admMemberService;
	
	public AdmMemberController(AmdMemberService admMemberService) {
		
		this.admMemberService = admMemberService;
		
	}
	
	

	@GetMapping("/member")
	public String productList(@RequestParam(defaultValue="1") int page, 
			@RequestParam(required=false) String searchValue, Model model) {
		
		log.info("[AdmMemberController] =======================");
		
		Page<AdmJyMemberDTO> memberList = admMemberService.findProductList(page, searchValue);
		PagingButtonInfo paging = Pagenation.getPagingButtonInfo(memberList);
		
		model.addAttribute("memberList", memberList);
		model.addAttribute("paging", paging);
		
		log.info("[AdmMemberController] memberList : {}",memberList );
		
		model.addAttribute("productList", memberList);
		model.addAttribute("paging", paging);
		if(searchValue !=null && !searchValue.isEmpty()) {
			model.addAttribute("searchValue", searchValue);
		}
		
		log.info("[AdmMemberController] =======================");
		
		return "admin/member/adm-member";
	}

}
