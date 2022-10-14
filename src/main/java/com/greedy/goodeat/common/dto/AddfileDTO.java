package com.greedy.goodeat.common.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddfileDTO {

	private Integer addfileNo;
	private String originalFileName;
	private String savedFileName;
	private String savedRoute;
	private String fileType;
	private String fileDivision;
	/* 필요하시면 엔티티 가져가서 (name="원하는 이름")으로 활성화 하세요♥
	private ReviewDTO review;
	private PostDTO post;
	private ProductDTO product;
	*/
	private String thumbnailRoute;
	
}
