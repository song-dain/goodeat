package com.greedy.goodeat.admin.inquiry.dto;


import com.greedy.goodeat.common.dto.PostDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SYAddfileDTO {

	private Integer addfileNo;
	private String originalFileName;
	private String savedFileName;
	private String savedRoute;
	private String fileType;
	private String fileDivision;
	private SYReviewDTO review;
	private PostDTO post;
	private SYProductDTO product;
	private String thumbnailRoute;
	
}
