package com.greedy.goodeat.common.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReviewDTO {

	private Integer reviewCode;
	private String reviewTitle;
	private String reviewContent;
	private String reviewStatus;
	private MemberDTO member;
	private OrderDTO order;
	private ProductDTO product;
	private List<AddfileDTO> addfileList;
	private java.sql.Date review_RegistDate;
	private java.sql.Date review_DeleteDate;
	private java.sql.Date review_ModifyDate;
	private String reasonReported;
}
