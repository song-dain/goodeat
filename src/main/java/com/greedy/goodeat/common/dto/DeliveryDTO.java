package com.greedy.goodeat.common.dto;

import lombok.Data;

@Data
public class DeliveryDTO {
	
	private int invoiceNo;
	private String invoiceInputType;
	private String deliveryAddress;
	private String deliveryDetailAddress;
	private int zipCode;
	private String recipient;
	private String deliveryPhone;
	private java.sql.Date invoiceDate;
	private String deliveryCompany;

}
