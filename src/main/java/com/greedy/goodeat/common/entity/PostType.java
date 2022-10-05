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

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="TBL_POST_TYPE")
@SequenceGenerator(name="POST_TYPE_SEQ_GENERATOR", sequenceName="SEQ_POST_TYPE_CODE"
, initialValue = 1, allocationSize = 1)
@DynamicInsert
public class PostType {

	@Id
	@Column(name="POST_TYPE_CODE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
					generator="POST_SEQ_GENERATOR")
	private Integer PostTypeCode;
	
	@Column(name="POST_TYPE")
	private String postType;
}
