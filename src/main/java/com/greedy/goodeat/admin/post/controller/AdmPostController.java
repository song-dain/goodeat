package com.greedy.goodeat.admin.post.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greedy.goodeat.admin.post.service.AdmPostService;

import com.greedy.goodeat.common.dto.PostDTO;
import com.greedy.goodeat.common.dto.ProductDTO;
import com.greedy.goodeat.common.paging.Pagenation;
import com.greedy.goodeat.common.paging.PagingButtonInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdmPostController {
	
	private final AdmPostService admPostService;
	private final MessageSourceAccessor messageSourceAccessor;
	private static final Logger LOGGER = LoggerFactory.getLogger(AdmPostController.class);
	
	@Autowired
	public AdmPostController(AdmPostService admPostService,
							 MessageSourceAccessor messageSourceAccessor) {
		this.admPostService = admPostService;
		this.messageSourceAccessor = messageSourceAccessor;
	}
	
	@GetMapping("/post")
	public String fintPostList(Model model, @PageableDefault Pageable pageable) {
		
		log.info("[PostController] =======================");
		
		Page<PostDTO> postList = admPostService.findPostList(pageable);
		PagingButtonInfo paging = Pagenation.getPagingButtonInfo(postList);
		
		model.addAttribute("postList",postList);
		model.addAttribute("paging", paging);

		log.info("[PostController] postList : {}", postList);
		log.info("[PostController] =======================");
		
		return "/admin/post/adm-post";
	}
	
}
