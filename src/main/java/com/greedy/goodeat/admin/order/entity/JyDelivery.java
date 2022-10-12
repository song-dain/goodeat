package com.greedy.goodeat.admin.order.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "TBL_DELIVERY")
@SequenceGenerator(name = "DELIVERY_SEQ_GENERATOR", sequenceName = "SEQ_DELIVERY_CODE", initialValue = 1, allocationSize = 1)
@DynamicInsert
public class JyDelivery {
	
	@Id
	@Column(name = "DELIVERY_CODE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DELIVERY_SEQ_GENERATOR")
	private Integer deliveryCode;
	
	@Column(name="INVOICE_NO")
	private Integer invoiceNo;
	
	@Column(name="INVOICE_INPUT_TYPE")
	private String invoiceInputType;
	
	@Column(name="DELIVERY_ADDRESS")
	private String deliveryAddress;
	
	@Column(name="DELIVERY_DETAIL_ADDRESS")
	private String deliveryDetailAddress;
	
	@Column(name="ZIP_CODE")
	private Integer zipCode;
	
	@Column(name="RECIPIENT")
	private String recipient;
	
	@Column(name="DELIVERY_PHONE")
	private String deliveryPhone;
	
	@Column(name="INVOICE_DATE")
	private java.sql.Date invoiceDate;
	
	@Column(name="DELIVERY_COMPANY")
	private String deliveryCompany;
	
	

}
