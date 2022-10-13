package com.greedy.goodeat.user.productdetail.hgdto;

import lombok.Data;

@Data
public class hgOrderProductDTO {
	
	private Integer orderProductCode;
	private String orderAmount;
	private hgProductDTO product;

}
