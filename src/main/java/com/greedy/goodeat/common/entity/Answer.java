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
@Table(name = "TBL_ANSWER")
@DynamicInsert
public class Answer {
	
	@Id
	@Column(name = "ANSWER_CODE")
	private Integer answerCode;
	
	@Column(name = "ANSWER_REGISTDATE")
	private java.sql.Date answerRegistDate;
	
	@Column(name = "ANSWER_STATUS")
	private String answerStatus;
	
	@ManyToOne
	@JoinColumn(name = "MEMBER_NO")
	private Member member;
	
	@ManyToOne
	@JoinColumn(name = "INQUIRY_CODE")
	private Inquiry inquiry;
	
	@Column(name = "ANSWER_TYPE")
	private String answerType;
	
	@ManyToOne
	@JoinColumn(name = "REVIEW_CODE")
	private Review review;
	
	@Column(name = "ANSWER_MODIFYDATE")
	private java.sql.Date answerModifyDate;
	
	@Column(name = "ANSWER_DELDATE")
	private java.sql.Date answerDelDate;

}
