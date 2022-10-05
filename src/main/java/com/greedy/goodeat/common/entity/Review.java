package com.greedy.goodeat.common.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import com.greedy.goodeat.common.entity.Member;
import com.greedy.goodeat.common.entity.Order;
import com.greedy.goodeat.common.entity.Product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="TBL_REVIEW")
@SequenceGenerator(name="REVIEW_SEQ_GENERATOR", sequenceName="SEQ_REVIEW_CODE"
, initialValue = 1, allocationSize = 1)
@DynamicInsert
public class Review {

	@Id
	@JoinColumn(name="REVIEW_CODE")
	private Integer reviewCode;
	
	@Column(name="REIVEW_TITLE")
	private String reviewTitle;
	
	@Column(name="REIVEW_CONTENT")
	private String reviewContent;
	
	@Column(name="REIVEW_STATUS")
	private String reviewStatus;
	
	@ManyToOne
	@JoinColumn(name="MEMBER_NO")
	private Member member;
	
	@ManyToOne
	@JoinColumn(name="ORDER_NO")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name="PRODUCT_CODE")
	private Product product;
	
	@Column(name="REIVEW_REGISDATE")
	private java.sql.Date review_RegisDate;
	
	@Column(name="REIVEW_DELETEDATE")
	private java.sql.Date review_DeleteDate;
	
	@Column(name="REIVEW_MODIFYDATE")
	private java.sql.Date review_ModifyDate;
	
}
