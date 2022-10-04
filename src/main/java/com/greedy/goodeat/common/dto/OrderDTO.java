package com.greedy.goodeat.common.dto;

import lombok.Data;

@Data
public class OrderDTO {
	
	private int orderNo;
	private java.sql.Date orderDate;
	private String orderStatus;
	private int deliveryFee;
	private int amountPay;

}
