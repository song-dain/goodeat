package com.greedy.goodeat.common.dto;

import lombok.Data;

@Data
public class ProductDTO {
	
	private Integer productCode;
	private String productName;
	private Integer productPrice;
	private String productStatus;
	private String productDescription;
	private Integer productInventory;
	private java.sql.Date productRegistDate;
	private java.sql.Date productModifyDate;
	private java.sql.Date productDeleteDate;
	private ProductCategoryDTO productCategory;
	
}
