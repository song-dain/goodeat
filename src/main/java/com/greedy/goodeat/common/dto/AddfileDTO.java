package com.greedy.goodeat.common.dto;

import lombok.Data;

@Data
public class AddfileDTO {

	private Integer addfileNo;
	private String originalFileName;
	private String savedFileName;
	private String savedRoute;
	private String fileType;
	private String fileDivision;
	private ReviewDTO review;
	private PostDTO post;
	private ProductDTO product;
	private String thumbnailRouter;
	
}
