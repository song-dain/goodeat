package com.greedy.goodeat.common.dto;

import java.util.List;

import lombok.Data;

@Data
public class OrderDTO {
	
	private Integer orderNo;
	private java.sql.Date orderDate;
	private String orderStatus;
	private Integer deliveryFee;
	private Integer amountPay;
	private MemberDTO member;
	private ProductDTO product;
	private DeliveryDTO delivery;
	private List<OrderProductDTO> orderProduct;

}
