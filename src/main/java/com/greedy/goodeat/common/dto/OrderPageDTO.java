package com.greedy.goodeat.common.dto;

import java.util.List;

import lombok.Data;

@Data
public class OrderPageDTO {

	private List<OrderPageItemDTO> orders;
	private int totalPrice;
	
}
