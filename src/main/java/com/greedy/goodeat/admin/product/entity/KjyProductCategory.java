package com.greedy.goodeat.admin.product.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "TBL_PRODUCT_CATEGORY")
@SequenceGenerator(name = "PRODUCT_CATEGORY_SEQ_GENERATOR", sequenceName = "SEQ_CATEGORY_CODE", initialValue = 1, allocationSize = 1)
@DynamicInsert
public class KjyProductCategory {
	
	@Id
	@Column(name="CATEGORY_CODE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_CATEGORY_SEQ_GENERATOR")
	private Integer categoryCode;
	
	@Column(name="CATEGORY_NAME")
	private String categotyName;
	
	
}
