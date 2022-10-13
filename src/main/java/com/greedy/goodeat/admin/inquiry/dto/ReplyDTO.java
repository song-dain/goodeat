package com.greedy.goodeat.admin.inquiry.dto;

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
    private String replyBody;
    private MemberDTO member;		            
    private String replyStatus;

}
