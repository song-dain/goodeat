package com.greedy.goodeat.admin.inquiry.entity;


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

import com.greedy.goodeat.common.entity.Member;

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
public class SYReview {

	@Id
	@Column(name="REVIEW_CODE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
					generator="REVIEW_SEQ_GENERATOR")
	private Integer reviewCode;
	
	@Column(name="REVIEW_TITLE")
	private String reviewTitle;
	
	@Column(name="REVIEW_CONTENT")
	private String reviewContent;
	
	@Column(name="REVIEW_STATUS")
	private String reviewStatus;
	
	@ManyToOne
	@JoinColumn(name="MEMBER_NO")
	private Member member;
	
	@ManyToOne
	@JoinColumn(name="ORDER_NO")
	private SYOrder order;
	
	@ManyToOne
	@JoinColumn(name="PRODUCT_CODE")
	private SYProduct product;
	
	@Column(name="REVIEW_REGISTDATE")
	private java.sql.Date reviewRegistDate;
	
	@Column(name="REVIEW_DELETEDATE")
	private java.sql.Date reviewDeleteDate;
	
	@Column(name="REVIEW_MODIFYDATE")
	private java.sql.Date reviewModifyDate;
	
}
