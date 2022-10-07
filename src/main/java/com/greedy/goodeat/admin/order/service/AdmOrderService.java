package com.greedy.goodeat.admin.order.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.greedy.goodeat.admin.order.repository.AdmOrderRepository;
import com.greedy.goodeat.common.dto.OrderDTO;
import com.greedy.goodeat.common.entity.Order;
import com.greedy.goodeat.common.entity.Product;

@Service
public class AdmOrderService {
	
	public static final int TEXT_PAGE_SIZE = 10;
	public static final String SORT_BY = "orderNo";
	
	private final AdmOrderRepository admOrderRepository;
	private final ModelMapper modelMapper;
	
	public AdmOrderService (AdmOrderRepository admOrderRepository, ModelMapper modelMapper) {
		
		this.admOrderRepository = admOrderRepository;
		this.modelMapper = modelMapper;
	}

	public Page<OrderDTO> findOrderList(int page, String searchValue) {
		
		Pageable pageable = PageRequest.of(page - 1, TEXT_PAGE_SIZE, Sort.by(SORT_BY).descending());
		Page<Order> orderList = null;
		
		if(searchValue !=null && !searchValue.isEmpty()) {
			orderList = admOrderRepository.finBySearchValue(searchValue, pageable);
		} else {
			orderList = admOrderRepository.findAll(pageable);
		}
		
		return orderList.map(order -> modelMapper.map(order, OrderDTO.class));
		
	}




}
