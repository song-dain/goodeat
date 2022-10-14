package com.greedy.goodeat.common.entity;

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
@Table(name = "TBL_INQUIRY_TYPE")
@SequenceGenerator(name = "INQUIRY_TYPE_SEQ_GENERATOR", 
				   sequenceName = "SEQ_INQUIRY_TYPE_NO", 
				   initialValue = 1, allocationSize = 1)
@DynamicInsert
public class InquiryType {
	
	@Id
	@Column(name = "INQUIRY_TYPE_NO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INQUIRY_TYPE_SEQ_GENERATOR")
	private Integer inquiryTypeNo;
	
	@Column(name = "INQUIRY_TYPE_NAME")
	private String inquiryTypeName;

}
	