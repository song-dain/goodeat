package com.greedy.goodeat.common.dto;




import lombok.Data;

@Data
public class AnswerDTO {
	
	private Integer answerCode;
	private java.sql.Date answerRegistDate;
	private String answerStatus;
	private MemberDTO member;
	private InquiryDTO inquiry;
	private String answerType;
	private ReviewDTO review;
	private java.sql.Date answerModifyDate;
	private java.sql.Date answerDelDate;
	
}
