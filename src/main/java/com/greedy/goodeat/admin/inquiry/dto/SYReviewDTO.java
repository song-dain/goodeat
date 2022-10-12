package com.greedy.goodeat.admin.inquiry.dto;



import com.greedy.goodeat.common.dto.MemberDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SYReviewDTO {

	private Integer reviewCode;
	private String reviewTitle;
	private String reviewContent;
	private String reviewStatus;
	private MemberDTO member;
	private SYOrderDTO order;
	private SYProductDTO product;
	private java.sql.Date review_RegistDate;
	private java.sql.Date review_DeleteDate;
	private java.sql.Date review_ModifyDate;
	
}
