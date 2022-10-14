package com.greedy.goodeat.user.product.orderby.entity;

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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name ="ItemMember")
@Table(name = "TBL_MEMBER")
@SequenceGenerator(name = "MEMBER_SEQ_GENERATOR", sequenceName = "SEQ_MEMBER_NO", initialValue = 1, allocationSize = 1)
@DynamicInsert
public class Member {
	
	
	@Id
	@Column(name="MEMBER_NO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SEQ_GENERATOR")
	private Integer memberNo;
	
	@Column(name="ID")
	private String memberId;
	
	@Column(name="PASSWORD")
	private String memberPwd;
	
	@Column(name="MEMBER_NAME")
	private String memberName;
	
	@Column(name="PHONE")
	private String phone;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="BIRTH")
	private java.sql.Date birthDate;
	
	@Column(name="ZIP_CODE")
	private Integer zipCode;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="DETAIL_ADDRESS")
	private String detailAddress;
	
	@Column(name="JOIN_DATE")
	private java.sql.Date joinDate;
	
	@Column(name="MEMBER_STATUS")
	private String memberStatus;
	
	@ManyToOne
	@JoinColumn(name = "AUTHORITY_CODE")
	private MemberAuthority memberAuthority;
}
