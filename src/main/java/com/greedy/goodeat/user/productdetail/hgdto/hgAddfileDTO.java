package com.greedy.goodeat.user.productdetail.hgdto;

import com.greedy.goodeat.common.dto.PostDTO;

import lombok.Data;

@Data
public class hgAddfileDTO {

	private Integer addfileNo;
	private String originalFileName;
	private String savedFileName;
	private String savedRoute;
	private String fileType;
	private String fileDivision;
	private hgReviewDTO hgreview;
	private PostDTO post;
	private hgProductDTO product;
	private String thumbnailRoute;
	
}
