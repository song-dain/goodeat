package com.greedy.goodeat.admin.post.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.greedy.goodeat.admin.post.service.AdmEventService;
import com.greedy.goodeat.common.dto.PostDTO;
import com.greedy.goodeat.common.paging.Pagenation;
import com.greedy.goodeat.common.paging.PagingButtonInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdmEventController {
	
	@Value("${image.image-dir}")
	private String IMAGE_DIR;
	
	private final AdmEventService admEventService;
	private final MessageSourceAccessor messageSourceAccessor;
	private static final Logger LOGGER = LoggerFactory.getLogger(AdmPostController.class);
	
	public AdmEventController(AdmEventService admEventService, 
							  MessageSourceAccessor messageSourceAccessor) {
		this.admEventService = admEventService;
		this.messageSourceAccessor = messageSourceAccessor;
	}
	
	
	@GetMapping("/event")
	public String eventList(@RequestParam(defaultValue="1") int page,
							@RequestParam(required=false) String searchValue,
							Model model) {
		
		log.info("[EventController] /event =================");
		Page<PostDTO> eventList = admEventService.findEventList(page, searchValue);
		PagingButtonInfo paging = Pagenation.getPagingButtonInfo(eventList);
		
		model.addAttribute("eventList", eventList);
		model.addAttribute("paging", paging);
		
		if(searchValue !=null && !searchValue.isEmpty()) {
			model.addAttribute("searchValue", searchValue);
		}
		
		return "/admin/event/adm-event";
	}
	
	@GetMapping("/event/regist")
	public String goRegistEventPage() {
		return "admin/event/adm-registevent";
	}
	
	@PostMapping("/event/regist")
	public String registEvent (Model model, PostDTO newEvent, RedirectAttributes rttr,
							   List<MultipartFile> attachImage) {
		
		admEventService.registEvent(newEvent);
		log.info("[EventController] regist ================");
		log.info("[EventController] newEvent : {}", newEvent);
		
		model.addAttribute("newEvent", newEvent);
		rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("event.regist"));
		
		return "redirect:/admin/event";
		
	}
	
	@GetMapping("/event/detail")
	public String detailEvent(Model model, Integer eventCode) {
		
		log.info("[EventController] select ================");
		
		PostDTO event = admEventService.selectEventList(eventCode);
		model.addAttribute("event", event);
		
		log.info("[EventController] event : {}", event);
		return "admin/event/adm-detailevent";	
	
	}
	
	@GetMapping("/event/modify")
	public String getModify(Model model, Integer eventCode) {
		
		log.info("[EventController] modify ================");
		
		PostDTO event = admEventService.selectEventList(eventCode);
		model.addAttribute("event", event);
		
		log.info("[EventController] Get event : {}", event);
		
		return "admin/event/adm-modifyevent";
		
	}
	
	@PostMapping("/event/modify")
	public String postModify(Model model, PostDTO event) {
		
		admEventService.modifyEvent(event);
		log.info("[EventController] Post event : {}", event);
		model.addAttribute(event);
		
		return "redirect:/admin/event/detail?eventCode=" + event.getPostCode();
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
