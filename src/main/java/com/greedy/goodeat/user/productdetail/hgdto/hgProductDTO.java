package com.greedy.goodeat.user.productdetail.hgdto;



import java.util.List;

import com.greedy.goodeat.common.dto.ProductCategoryDTO;

import lombok.Data;

@Data
public class hgProductDTO {
	
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
	private hgAddfileDTO addfile;
}
