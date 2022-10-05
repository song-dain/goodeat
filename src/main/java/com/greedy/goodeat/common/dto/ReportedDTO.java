package com.greedy.goodeat.common.dto;

import lombok.Data;

@Data
public class ReportedDTO {

	private Integer reportedCode;
	private String reasonReport;
	private MemberDTO member;
	private ReviewDTO review;
	
}
