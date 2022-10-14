package com.greedy.goodeat.admin.product.dto;

import lombok.Data;

@Data
public class KjyAddfileDTO {

	private Integer addfileNo;
	private String originalFileName;
	private String savedFileName;
	private String savedRoute;
	private String fileType;
	private String thumbnailRoute;
	private Integer productCode;
	
	
}
