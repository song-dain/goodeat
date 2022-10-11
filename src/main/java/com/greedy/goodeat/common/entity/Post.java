package com.greedy.goodeat.common.entity;

import java.util.List;

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

import com.greedy.goodeat.common.dto.MemberDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="TBL_POST")
@SequenceGenerator(name="POST_SEQ_GENERATOR", sequenceName="SEQ_POST_CODE"
				, initialValue = 1, allocationSize = 1)
@DynamicInsert
public class Post {

	@Id
	@Column(name="POST_CODE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
					generator="POST_SEQ_GENERATOR")
	private Integer postCode;

	
	@Column(name="POST_TITLE")
	private String postTitle;
	
	@Column(name="POST_CONTENT")
	private String postContent;

	@OneToMany
	@JoinColumn(name="POST_CODE")
	private List<Addfile> addfileList;

	@ManyToOne
	@JoinColumn(name="MEMBER_NO")
	private Member member;
	
	@ManyToOne
	@JoinColumn(name="POST_TYPE_CODE")
	private PostType postType;

	@Column(name="POST_REGISTDATE")
	private java.sql.Date postResistDate;
	
	@Column(name="POST_MODIFYDATE")
	private java.sql.Date postModifyDate;
	
	@Column(name="POST_DELDATE")
	private java.sql.Date postDelDate;
	
	@Column(name="POST_STATUS")
	private String postStatus;
	
}