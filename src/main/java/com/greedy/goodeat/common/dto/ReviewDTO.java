package com.greedy.goodeat.common.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ReviewDTO {

	private Long reviewCode;
	private String reviewTitle;
	private String reviewContent;
	private String reviewStatus;
	private MemberDTO member;
	private OrderDTO order;
	private ProductDTO product;
	private Date review_RegisDate;
	private java.sql.Date review_DeleteDate;
	private Date review_ModifyDate;
	
}
