package com.greedy.goodeat.common.dto;

import java.util.Date;

import lombok.Data;

@Data
public class AnswerDTO {
	
	private Long answerCode;
	private Date answerRegistDate;
	private String answerStatus;
	private MemberDTO member;
	private InquiryDTO inquiry;
	private String answerType;
	private ReviewDTO review;
	private Date answerModifyDate;
	private java.sql.Date answerDelDate;
	
}
