package com.greedy.goodeat.common.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PostDTO {

	private Long postCode;
	private String postTitle;
	private String postContent;
	private Date postRegistDate;
	private AddfileDTO addfile;
	private MemberDTO member;
	private Long postTypeCode;
	private Date postResistDate;
	private Date postModifyDate;
	private java.sql.Date postDelDate;
	private String postStatus;
}
