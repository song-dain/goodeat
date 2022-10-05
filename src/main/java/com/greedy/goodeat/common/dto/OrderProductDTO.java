package com.greedy.goodeat.common.dto;

import lombok.Data;

@Data
public class OrderProductDTO {
	
	private String orderAmount;
	private ProductDTO product;
	private OrderDTO order;

}
