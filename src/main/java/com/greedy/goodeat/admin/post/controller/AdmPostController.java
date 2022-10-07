package com.greedy.goodeat.admin.post.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.greedy.goodeat.admin.post.service.AdmPostService;
import com.greedy.goodeat.common.dto.MemberDTO;
import com.greedy.goodeat.common.dto.PostDTO;
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
	
	@GetMapping("/post/regist")
	public String goRegist() {
		
		return "/admin/post/adm-detailpost";
	}
	
	@PostMapping("/post/regist")
	public String registPost(Model model, PostDTO newPost, RedirectAttributes rttr) {
		
		log.info("[PostController] =======================");
		
		
		admPostService.registPost(newPost);
		
		model.addAttribute("newPost", newPost);
		
		log.info("[PostController] newPost : {} ", newPost);
//		rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("post.regist"));
		
		
		return "redirect:/admin/post";
	}
	
	@GetMapping("/post/detail")
	public String selectBoardDetail(Model model, Integer postCode) {
		
		log.info("[admPostController] ========================================= ");
		log.info("[admpostController] postCode : {}", postCode);
		
		PostDTO post = admPostService.selectPostDetail(postCode);
		
		log.info("[admpostController] post : {}", post);
		
		model.addAttribute("post", post);
		
		log.info("[admpostController] ========================================= ");
		
		return "admin/post/adm-postNo";
		
	}
	
	
	
	
	
	
	

}