package com.greedy.goodeat.common.dto;

import lombok.Data;

@Data
public class ReportedDTO {

	private String ReasonReport;
	private MemberDTO member;
	private ReviewDTO review;
	
}
