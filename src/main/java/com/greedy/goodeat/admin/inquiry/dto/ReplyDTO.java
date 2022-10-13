package com.greedy.goodeat.admin.inquiry.dto;

import java.sql.Date;

import com.greedy.goodeat.common.dto.MemberDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReplyDTO {
	
    private Integer replyNo;
    private Integer refInquiryNo;
    private Integer refReviewNo;
    private String replyInquiryContent;
    private String replyReviewContent;
    private MemberDTO member;		            
    private String replyStatus;
    private Date replyRegistDate;

}
