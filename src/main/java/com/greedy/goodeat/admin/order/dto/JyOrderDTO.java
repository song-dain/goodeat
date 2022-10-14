package com.greedy.goodeat.admin.order.dto;

import java.util.List;

import lombok.Data;

@Data
public class JyOrderDTO {
	
	private Integer orderNo;
	private java.sql.Date orderDate;
	private String orderStatus;
	private Integer deliveryFee;
	private Integer amountPay;
	private JyMemberDTO member;
	private JyProductDTO product;
	private JyDeliveryDTO delivery;
	private List<JyOrderProductDTO> orderProduct;
	private List<JyPaymentDTO> payment;

}
