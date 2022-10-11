package com.greedy.goodeat.admin.order.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.greedy.goodeat.admin.order.service.AdmOrderService;
import com.greedy.goodeat.common.dto.OrderDTO;
import com.greedy.goodeat.common.paging.Pagenation;
import com.greedy.goodeat.common.paging.PagingButtonInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdmOrderController {
	
	private final AdmOrderService admOrderService;
	
	public AdmOrderController(AdmOrderService admOrderService) {
		
		this.admOrderService = admOrderService;
		
	}
	

	@GetMapping("/orderList")
	public String orderList(@RequestParam(defaultValue="1") int page, 
			@RequestParam(required=false) String searchValue, Model model) {
		
		log.info("[OrderController] =======================");
		
		Page<OrderDTO> orderList = admOrderService.findOrderList(page, searchValue);
		PagingButtonInfo paging = Pagenation.getPagingButtonInfo(orderList);
		
		model.addAttribute("orderList", orderList);
		model.addAttribute("paging", paging);
		
		log.info("[OrderController] orderList : {}",orderList.getContent() );
		
		if(searchValue !=null && !searchValue.isEmpty()) {
			model.addAttribute("searchValue", searchValue);
		}
		
		log.info("[OrderController] =======================");
		
		return "admin/order/adm-order";
	}

	
	

}
