package com.greedy.goodeat.user.productdetail.hgdto;



import com.greedy.goodeat.common.dto.MemberDTO;
import lombok.Data;

@Data
public class hgReviewDTO {

	private Integer reviewCode;
	private String reviewTitle;
	private String reviewContent;
	private String reviewStatus;
	private MemberDTO member;
	private hgOrderDTO order;
	private hgProductDTO product;
	private java.sql.Date reviewRegistDate;
	private java.sql.Date reviewDeleteDate;
	private java.sql.Date reviewModifyDate;
	
}
