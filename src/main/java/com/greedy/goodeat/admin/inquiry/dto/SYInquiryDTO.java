package com.greedy.goodeat.admin.inquiry.dto;



import com.greedy.goodeat.common.dto.MemberDTO;
import com.greedy.goodeat.common.dto.ProductDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SYInquiryDTO {

	private Integer inquiryCode;
	private String inquiryTitle;
	private String inquiryContent;
	private MemberDTO member;
	private ProductDTO product;
	private SYInquiryTypeDTO inquiryType;
	private java.sql.Date inquiryRegistDate;
	private java.sql.Date inquiryDelDate;
	private java.sql.Date inquiryModifyDate;
	private String inquiryStatus;
}
