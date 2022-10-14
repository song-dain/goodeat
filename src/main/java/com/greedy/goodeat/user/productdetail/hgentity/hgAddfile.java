package com.greedy.goodeat.user.productdetail.hgentity;



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

import com.greedy.goodeat.common.entity.Post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TBL_ADDFILE")
@DynamicInsert
public class hgAddfile {
	
	@Id
	@Column(name = "ADDFILE_NO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDFILE_SEQ_GENERATOR")
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

	@Column(name ="REVIEW_CODE")
	private Integer reviewCode;
	
	@Column(name ="POST_CODE")
	private Integer postCode;
	
	@Column(name ="PRODUCT_CODE") 
	private Integer productCode;
	 
	
	@Column(name = "THUMBNAIL_ROUTE")
	private String thumbnailRoute;


}
