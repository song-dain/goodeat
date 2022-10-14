package com.greedy.goodeat.common.dto;

import lombok.Data;

@Data
public class PaymentDTO {
	
	private String payHistoryCode;
	private String payMethod;
	private String payStatus;
	private java.sql.Date payDate;
	private OrderDTO order;
	
	

}
