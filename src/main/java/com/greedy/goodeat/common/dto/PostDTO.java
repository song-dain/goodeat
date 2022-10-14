package com.greedy.goodeat.common.dto;

import java.util.List;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDTO {

	private Integer postCode;
	private String postTitle;
	private String postContent;
	private List<AddfileDTO> AddfileList;
	private MemberDTO member;
	private PostTypeDTO postType;
	private java.sql.Date postRegisDate;
	private java.sql.Date postModifyDate;
	private java.sql.Date postDelDate;
	private String postStatus;
}
