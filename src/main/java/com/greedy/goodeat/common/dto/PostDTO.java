package com.greedy.goodeat.common.dto;



import java.util.List;

import com.greedy.goodeat.common.entity.Addfile;

import lombok.Data;

@Data
public class PostDTO {

	private int postCode;
	private String postTitle;
	private String postContent;
	private List<Addfile> addfileList;
	private MemberDTO member;
	private PostTypeDTO postType;
	private java.sql.Date postResistDate;
	private java.sql.Date postModifyDate;
	private java.sql.Date postDelDate;
	private String postStatus;
}
