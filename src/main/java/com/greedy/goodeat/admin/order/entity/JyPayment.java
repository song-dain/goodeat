package com.greedy.goodeat.admin.order.entity;

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

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TBL_PAYMENT")
@DynamicInsert
public class JyPayment {
	
	@Id
	@Column(name="PAY_HISTORY_CODE")
	private Integer payHistoryCode;
	
	@Column(name="PAY_METHOD")
	private String payMethod;
	
	@Column(name="PAY_STATUS")
	private String payStatus;
	
	@Column(name="PAY_DATE")
	private java.sql.Date payDate;
	
	@Column(name="ORDER_NO")
	private Integer orderNo;
	
	

}
