package com.greedy.goodeat.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TBL_ORDER")
@SequenceGenerator(name = "ORDER_SEQ_GENERATOR", sequenceName = "SEQ_ORDER_NO", initialValue = 1, allocationSize = 1)
@DynamicInsert
public class Order {
	

	@Id
	@Column(name="ORDER_NO")
	private int orderNo;
	
	@Column(name="ORDER_DATE")
	private java.sql.Date orderDate;
	
	@Column(name="ORDER_STATUS")
	private String orderStatus;
	
	@Column(name="DELIVERY_FEE")
	private int deliveryFee;
	
	@Column(name="AMOPUNT_PAY")
	private int amountPay;

}
