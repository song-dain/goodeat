package com.greedy.goodeat.common.dto;

import lombok.Data;

@Data
public class CartDTO {
	
	private Integer cartCode;
	private Integer productAmount;
	private ProductDTO product;
	private MemberDTO member;
	

}
