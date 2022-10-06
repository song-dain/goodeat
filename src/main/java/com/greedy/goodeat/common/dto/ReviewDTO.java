package com.greedy.goodeat.common.dto;



import lombok.Data;

@Data
public class ReviewDTO {

	private Integer reviewCode;
	private String reviewTitle;
	private String reviewContent;
	private String reviewStatus;
	private MemberDTO member;
	private OrderDTO order;
	private ProductDTO product;
	private java.sql.Date review_RegistDate;
	private java.sql.Date review_DeleteDate;
	private java.sql.Date review_ModifyDate;
	
}
