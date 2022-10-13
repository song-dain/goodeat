package com.greedy.goodeat.admin.inquiry.entity;

import java.sql.Date;

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

import com.greedy.goodeat.common.entity.Member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TBL_REPLY")
@SequenceGenerator(
		name = "REPLY_SEQ_GENERATOR",
		sequenceName = "SEQ_REPLY_NO",
		initialValue = 1,
		allocationSize = 1
)
@DynamicInsert 
public class Reply {
	
	@Id
	@Column(name = "REPLY_NO")
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "REPLY_SEQ_GENERATOR"
	)
    private Integer replyNo;
	
	@Column(name = "REF_INQUIRY_NO")
    private Integer refInquiryNo;
	
	@Column(name = "REF_REVIEW_NO")
	private Integer refReviewNo;
	
	@Column(name = "REPLY_INQUIRY_CONTENT")
    private String replyInquiryContent;
	
	@Column(name = "REPLY_REVIEW_CONTENT")
    private String replyReviewContent;
	
	@ManyToOne
	@JoinColumn(name = "MEMBER_NO")
    private Member member;	
	
	@Column(name = "REPLY_STATUS")
    private String replyStatus;
	
	@Column(name = "REPLY_REGISTDATE")
	private Date replyRegistDate;

}
