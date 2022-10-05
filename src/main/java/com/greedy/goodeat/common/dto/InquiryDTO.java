package com.greedy.goodeat.common.dto;



import lombok.Data;

@Data
public class InquiryDTO {

	private Integer inquiryCode;
	private String inquiryTitle;
	private String inquiryContent;
	private MemberDTO member;
	private ProductDTO product;
	private InquiryTypeDTO inquiryType;
	private java.sql.Date inquiryRegistDate;
	private java.sql.Date inquiryDelDate;
	private java.sql.Date inquiryModifyDate;
	private String inquiryStatus;
}
