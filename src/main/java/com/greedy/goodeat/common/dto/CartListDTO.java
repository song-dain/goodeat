package com.greedy.goodeat.common.dto;

import lombok.Data;

@Data
public class CartListDTO {
	private Integer cartCode;
	private Integer memberNo;
	private String productName;
	private Integer productAmount;
	private Integer productPrice;
}
