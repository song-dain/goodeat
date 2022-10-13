package com.greedy.goodeat.admin.inquiry.dto;

import java.util.List;

import com.greedy.goodeat.common.dto.ProductCategoryDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SYProductDTO {
	
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
