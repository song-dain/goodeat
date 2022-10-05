package com.greedy.goodeat.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="TBL_REPORTED")
@DynamicInsert
public class Reported {
	
	@Id
	@Column(name="REPORTED_CODE")
	private Integer reportedCode;

	@Column(name="REIVEW_TITLE")
	private String reasonReport;
	
	@ManyToOne
	@JoinColumn(name="MEMBER_NO")
	private Member member;
	
	@ManyToOne
	@JoinColumn(name="REVIEW_CODE")
	private Review review;
	
}
