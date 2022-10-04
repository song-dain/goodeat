package com.greedy.goodeat.common.dto;

import lombok.Data;

@Data
public class ProductDTO {
	
	private int productCode;
	private String productName;
	private int productPrice;
	private String productStatus;
	private String productDescription;
	private int productInventory;
	private java.sql.Date productRegistDate;
	private java.sql.Date productModifyDate;
	private java.sql.Date productDeleteDate;
	
}
