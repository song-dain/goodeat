package com.greedy.goodeat.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TBL_ADDFILE")
@DynamicInsert
public class Addfile {
	
	@Id
	@Column(name = "ADDFILE_NO")
	private Integer addfileNo;
	
	@Column(name = "ORIGINALFILE_NAME")
	private String originalFileName;
	
	@Column(name = "SAVEDFILE_NAME")
	private String savedFileName;
	
	@Column(name = "SAVED_ROUTE")
	private String savedRoute;
	
	@Column(name = "FILE_TYPE")
	private String fileType;
	
	@Column(name = "FILE_DIVISION")
	private String fileDivision;
	
	@ManyToOne
	@JoinColumn(name = "REVIEW_CODE")
	private Review review;
	
	@ManyToOne
	@JoinColumn(name = "POST_CODE")
	private Post post;
	
	@ManyToOne
	@JoinColumn(name = "PRODUCT_CODE")
	private Product product;
	
	@Column(name = "THUMBNAIL_ROUTE")
	private String thumbnailRoute;

}
