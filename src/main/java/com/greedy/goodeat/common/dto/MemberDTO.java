package com.greedy.goodeat.common.dto;

import java.util.Date;

import com.greedy.goodeat.common.entity.Authority;

import lombok.Data;

@Data
public class MemberDTO {
	
	private int memberNo;
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String phone;
	private String email;
	private String gender;
	private Date birthDate;
	private int zipCode;
	private String address;
	private String detailAddress;
	private Date joinDate;
	private String memberStatus;
	private Authority authority;

}
