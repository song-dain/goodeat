package com.greedy.goodeat.user.productdetail.hgdto;

import java.util.List;

import com.greedy.goodeat.common.dto.DeliveryDTO;
import com.greedy.goodeat.common.dto.MemberDTO;
import com.greedy.goodeat.common.dto.OrderProductDTO;

import lombok.Data;

@Data
public class hgOrderDTO {
	
	private Integer orderNo;
	private java.sql.Date orderDate;
	private String orderStatus;
	private Integer deliveryFee;
	private Integer amountPay;
	private MemberDTO member;
	private hgProductDTO product;
	private DeliveryDTO delivery;
	private List<OrderProductDTO> orderProduct;

}
