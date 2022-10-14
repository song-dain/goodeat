package com.greedy.goodeat.user.productdetail.hgentity;


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
public class hgReview {

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
	private hgOrder order;
	
	@ManyToOne
	@JoinColumn(name="PRODUCT_CODE")
	private hgProduct product;
	
	@Column(name="REVIEW_REGISTDATE")
	private java.sql.Date reviewRegistDate;
	
	@Column(name="REVIEW_DELETEDATE")
	private java.sql.Date reviewDeleteDate;
	
	@Column(name="REVIEW_MODIFYDATE")
	private java.sql.Date reviewModifyDate;

	
	// 리뷰 첨부파일 구현 시 파일 리스트 필요

	
}
