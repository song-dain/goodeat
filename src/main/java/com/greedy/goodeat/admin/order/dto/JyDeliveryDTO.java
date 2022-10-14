package com.greedy.goodeat.admin.order.dto;


import lombok.Data;

@Data
public class JyDeliveryDTO {
	
	private Integer deliveryCode;
	private Integer invoiceNo;
	private String invoiceInputType;
	private String deliveryAddress;
	private String deliveryDetailAddress;
	private Integer zipCode;
	private String recipient;
	private String deliveryPhone;
	private java.sql.Date invoiceDate;
	private String deliveryCompany;

}
