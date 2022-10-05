package com.greedy.goodeat.common.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TBL_DELIVERY")
@DynamicInsert
public class Delivery implements Serializable {
	
	
	@ManyToOne
	@JoinColumn(name = "ORDER_NO")
	private Order order;
	
	@Id
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
