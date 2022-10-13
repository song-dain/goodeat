package com.greedy.goodeat.admin.order.controller;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.greedy.goodeat.admin.order.dto.JyDeliveryDTO;
import com.greedy.goodeat.admin.order.dto.JyOrderDTO;
import com.greedy.goodeat.admin.order.service.AdmOrderService;
import com.greedy.goodeat.common.paging.Pagenation;
import com.greedy.goodeat.common.paging.PagingButtonInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdmOrderController {
	
	private final AdmOrderService admOrderService;
	private final MessageSourceAccessor messageSourceAccessor;
	
	public AdmOrderController(AdmOrderService admOrderService, MessageSourceAccessor messageSourceAccessor) {
		
		this.admOrderService = admOrderService;
		this.messageSourceAccessor = messageSourceAccessor;
		
	}
	

	@GetMapping("/orderList")
	public String orderList(@RequestParam(defaultValue="1") int page, 
			@RequestParam(required=false) String searchValue, Model model) {
		
		log.info("[OrderController] =======================");
		
		Page<JyOrderDTO> orderList = admOrderService.findOrderList(page, searchValue);
		PagingButtonInfo paging = Pagenation.getPagingButtonInfo(orderList);
		
		model.addAttribute("orderList", orderList);
		model.addAttribute("paging", paging);
		
		log.info("[OrderController] orderList : {}",orderList.getContent() );
		orderList.getContent().forEach(order -> log.info("order : {}", order));
		
		if(searchValue !=null && !searchValue.isEmpty()) {
			model.addAttribute("searchValue", searchValue);
		}
		
		log.info("[OrderController] =======================");
		
		return "admin/order/adm-order";
	}
	
	
	@GetMapping("/orderDetail")
	public String detailProduct(Model model,Integer orderNo) {
		
		JyOrderDTO order = admOrderService.selectOrderList(orderNo);
		
		model.addAttribute("order", order);
		
		log.info("[AdmOrderController] orderNo : {}" , orderNo);
		
		return "admin/order/adm-orderdetail";
	}
	
	@PostMapping("/statusModify")
	public String statusModify(Model model, JyOrderDTO order, RedirectAttributes rttr) {
		
		admOrderService.statusModify(order);
		
		model.addAttribute(order);
		rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("statusModify.success"));
		
		return "redirect:/admin/orderList";
		
		
	}
	


	
	

}
