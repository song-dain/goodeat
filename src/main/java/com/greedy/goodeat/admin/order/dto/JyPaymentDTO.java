package com.greedy.goodeat.admin.order.dto;

import lombok.Data;

@Data
public class JyPaymentDTO {
	
	private Integer payHistoryCode;
	private String payMethod;
	private String payStatus;
	private java.sql.Date payDate;
	private Integer orderNo;
	
	

}
