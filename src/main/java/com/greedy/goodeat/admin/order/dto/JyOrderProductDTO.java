package com.greedy.goodeat.admin.order.dto;

import lombok.Data;

@Data
public class JyOrderProductDTO {
	
	private Integer orderProductCode;
	private String orderAmount;
	private Integer orderNo;
	private JyProductDTO product;

}
