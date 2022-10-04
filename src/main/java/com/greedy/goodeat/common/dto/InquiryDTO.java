package com.greedy.goodeat.common.dto;

import java.util.Date;

import lombok.Data;

@Data
public class InquiryDTO {

	private int inquiryCode;
	private String inquiryTitle;
	private String inquiryContent;
	private MemberDTO member;
	private ProductDTO product;
	private int inquiryTypeCode;
	private Date inquiryRegistDate;
	private Date inquiryDelDate;
	private Date inquiryModifyDate;
	private String inquiryStatus;
}
