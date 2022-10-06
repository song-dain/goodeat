package com.greedy.goodeat.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TBL_CART")
@SequenceGenerator(name = "CART_SEQ_GENERATOR", sequenceName = "SEQ_CART_CODE", initialValue = 1, allocationSize = 1)
@DynamicInsert
public class Cart {
	
	@Id
	@Column(name="CART_CODE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CART_SEQ_GENERATOR")
	private Integer cartCode;
	
	@Column(name="PRODUCT_AMOUNT")
	private Integer productAmount;
	
	@ManyToOne
	@JoinColumn(name = "PRODUCT_CODE")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "MEMBER_NO")
	private Member member;

}
