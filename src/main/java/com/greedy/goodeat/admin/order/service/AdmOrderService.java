package com.greedy.goodeat.admin.order.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.greedy.goodeat.admin.order.repository.AdmDeliveryRepository;
import com.greedy.goodeat.admin.order.repository.AdmOrderRepository;
import com.greedy.goodeat.common.dto.DeliveryDTO;
import com.greedy.goodeat.common.dto.OrderDTO;
import com.greedy.goodeat.common.dto.OrderProductDTO;
import com.greedy.goodeat.common.entity.Delivery;
import com.greedy.goodeat.common.entity.Order;
import com.greedy.goodeat.common.entity.OrderProduct;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AdmOrderService {
	
	public static final int TEXT_PAGE_SIZE = 10;
	public static final String SORT_BY = "orderNo";
	
	private final AdmOrderRepository admOrderRepository;
	private final AdmDeliveryRepository admDeliveryRepository;
	private final ModelMapper modelMapper;
	
	public AdmOrderService (AdmOrderRepository admOrderRepository, AdmDeliveryRepository admDeliveryRepository, ModelMapper modelMapper) {
		
		this.admOrderRepository = admOrderRepository;
		this.admDeliveryRepository = admDeliveryRepository;
		this.modelMapper = modelMapper;
	}

	public Page<OrderDTO> findOrderList(int page, String searchValue) {
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		Pageable pageable = PageRequest.of(page - 1, TEXT_PAGE_SIZE, Sort.by(SORT_BY).descending());
		Page<Order> orderList = null;
		
		if(searchValue !=null && !searchValue.isEmpty()) {
			orderList = admOrderRepository.finBySearchValue(searchValue, pageable);
		} else {
			orderList = admOrderRepository.findAll(pageable);
		}
		
		log.info("orderList : {}", orderList.getContent());
		
		return orderList.map(order -> modelMapper.map(order, OrderDTO.class));
		
	}

	@Transactional
	public void modifyDelivery(DeliveryDTO delivery) {
	
		Delivery modifydelivery = admDeliveryRepository.findById(delivery.getDeliveryCode()).get();
		
		modifydelivery.setDeliveryCompany(delivery.getDeliveryCompany());
		modifydelivery.setInvoiceNo(delivery.getInvoiceNo());

	
	}




}
