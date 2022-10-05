package com.greedy.goodeat.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TBL_ORDER_PRODUCT")
@DynamicInsert
public class OrderProduct {
	
	@Column(name="PRODUCT_AMOUNT")
	private String orderAmount;

}
