package com.greedy.goodeat.admin.inquiry.entity;

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
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "TBL_ORDER_PRODUCT")
@DynamicInsert
public class SYOrderProduct {
	
	@Id
	@Column(name = "ORDER_PRODUCT_CODE")
	private Integer orderProductCode;
	
	@ManyToOne
	@JoinColumn(name = "ORDER_NO")
	private SYOrder order;
	
	@Column(name="ORDER_AMOUNT")
	private String orderAmount;
	
	@ManyToOne
	@JoinColumn(name = "PRODUCT_CODE")
	private SYProduct product;

}
