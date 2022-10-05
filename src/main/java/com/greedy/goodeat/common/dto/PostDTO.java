package com.greedy.goodeat.common.dto;



import lombok.Data;

@Data
public class PostDTO {

	private Integer postCode;
	private String postTitle;
	private String postContent;
	private java.sql.Date postRegistDate;
	private AddfileDTO addfile;
	private MemberDTO member;
	private Integer postTypeCode;
	private java.sql.Date postResistDate;
	private java.sql.Date postModifyDate;
	private java.sql.Date postDelDate;
	private String postStatus;
}
