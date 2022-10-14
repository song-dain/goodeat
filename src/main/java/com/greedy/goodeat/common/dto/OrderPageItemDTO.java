package com.greedy.goodeat.common.dto;

import lombok.Data;

@Data
public class OrderPageItemDTO {

	private int productCode;
	private int productAmount;
	
	private String productName;
	private int productPrice;
	
	
}
