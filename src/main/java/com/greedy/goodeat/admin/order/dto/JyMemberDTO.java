package com.greedy.goodeat.admin.order.dto;

import lombok.Data;

@Data
public class JyMemberDTO {
	
	private Integer memberNo;
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String phone;
	private String email;
	private String gender;
	private java.sql.Date birthDate;
	private Integer zipCode;
	private String address;
	private String detailAddress;
	private java.sql.Date joinDate;
	private String memberStatus;

}
