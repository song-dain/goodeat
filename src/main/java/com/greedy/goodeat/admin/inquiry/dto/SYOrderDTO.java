package com.greedy.goodeat.admin.inquiry.dto;

import java.util.List;

import com.greedy.goodeat.common.dto.DeliveryDTO;
import com.greedy.goodeat.common.dto.MemberDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SYOrderDTO {
	
	private Integer orderNo;
	private java.sql.Date orderDate;
	private String orderStatus;
	private Integer deliveryFee;
	private Integer amountPay;
	private MemberDTO member;
	private SYProductDTO product;
	private DeliveryDTO delivery;

}
