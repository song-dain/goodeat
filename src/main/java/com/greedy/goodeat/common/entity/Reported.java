package com.greedy.goodeat.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import com.greedy.goodeat.common.entity.Review;
import com.greedy.goodeat.common.entity.member;

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

	@Column(name="REIVEW_TITLE")
	private String ReasonReport;
	
	@ManyToOne
	@JoinColumn(name="MEMBER_NO")
	private Member member;
	
	@ManyToOne
	@JoinColumn(name="REVIEW_CODE")
	private Review review;
	
}
