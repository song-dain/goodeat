package com.greedy.goodeat.common.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TBL_PRODUCT")
@SequenceGenerator(name = "PRODUCT_SEQ_GENERATOR", sequenceName = "SEQ_PRODUCT_CODE", initialValue = 1, allocationSize = 1)
@DynamicInsert
public class Product {
	
	@Id
	@Column(name="PRODUCT_CODE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_SEQ_GENERATOR")
	private Integer productCode;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="PRODUCT_PRICE")
	private int productPrice;
	
	@Column(name="PRODUCT_STATUS")
	private String productStatus;
	
	@Column(name="PRODUCT_DESCRIPTION")
	private String productDescription;
	
	@Column(name="PRODUCT_INVENTORY")
	private int productInventory;
	
	@Column(name="PRODUCT_REGISTDATE")
	private java.sql.Date productRegistDate;
	
	@Column(name="PRODUCT_MODIFYDATE")
	private java.sql.Date productModifyDate;
	
	@Column(name="PRODUCT_DELETEDATE")
	private java.sql.Date productDeleteDate;
	
	@ManyToOne
	@JoinColumn(name = "CATEGORY_CODE")
	private ProductCategory productCategory;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "PRODUCT_CODE")
	private List<Addfile> AddfileList;

}
