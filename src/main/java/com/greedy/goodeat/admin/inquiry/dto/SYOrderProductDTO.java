package com.greedy.goodeat.admin.inquiry.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SYOrderProductDTO {
	
	private Integer orderProductCode;
	private String orderAmount;
	private SYOrderDTO order;
	private SYProductDTO product;

}
