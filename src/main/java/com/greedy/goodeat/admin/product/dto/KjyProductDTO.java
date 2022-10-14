package com.greedy.goodeat.admin.product.dto;

import java.util.List;

import lombok.Data;

@Data
public class KjyProductDTO {
	
	private Integer productCode;
	private String productName;
	private Integer productPrice;
	private String productStatus;
	private String productDescription;
	private Integer productInventory;
	private java.sql.Date productRegistDate;
	private java.sql.Date productModifyDate;
	private java.sql.Date productDeleteDate;
	private KjyProductCategoryDTO productCategory;
	private List<KjyAddfileDTO> addfileList;
}
