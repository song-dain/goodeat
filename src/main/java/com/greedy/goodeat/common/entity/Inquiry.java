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
@Table(name = "TBL_INQUIRY")
@SequenceGenerator(name = "INQUIRY_SEQ_GENERATOR", 
				   sequenceName = "SEQ_INQUIRY_CODE", 
				   initialValue = 1, allocationSize = 1)
@DynamicInsert
public class Inquiry {
	
	@Id
	@Column(name = "INQUIRY_CODE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INQUIRY_SEQ_GENERATOR")
	private Integer inquiryCode;
	
	@Column(name = "INQUIRY_TITLE")
	private String inquiryTitle;
	
	@Column(name = "INQUIRY_CONTENT")
	private String inquiryContent;
	
	@ManyToOne
	@JoinColumn(name = "MEMBER_NO")
	private Member member;
	
	@ManyToOne
	@JoinColumn(name = "PRODUCT_CODE")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "INQUIRYTYPE_NO")
	private InquiryType inquiryType;
	
	@Column(name = "INQUIRY_REGISTDATE")
	private java.sql.Date inquiryRegistDate;
	
	@Column(name = "INQUIRY_DELDATE")
	private java.sql.Date inquiryDelDate;
	
	@Column(name = "INQUIRY_MODIFYDATE")
	private java.sql.Date inquiryModifyDate;
	
	@Column(name = "INQUIRY_STATUS")
	private String inquiryStatus;

}
