package com.greedy.goodeat.user.product.orderby.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name ="ItemPostType")
@Getter
@Setter
@NoArgsConstructor
@Table(name="TBL_POST_TYPE")
@DynamicInsert
public class PostType {

	@Id
	@Column(name="POST_TYPE_CODE")
	private Integer PostTypeCode;
	
	@Column(name="POST_TYPE")
	private String postType;
}
