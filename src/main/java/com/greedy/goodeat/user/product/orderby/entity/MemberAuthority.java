package com.greedy.goodeat.user.product.orderby.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name ="ItemMemberAuthority")
@Table(name = "TBL_MEMBER_AUTHORITY")
@SequenceGenerator(name = "MEMBER_AUTHORITY_SEQ_GENERATOR", sequenceName = "SEQ_AUTHORITY_CODE", initialValue = 1, allocationSize = 1)
@DynamicInsert
public class MemberAuthority {
	
	@Id
	@Column(name="AUTHORITY_CODE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTHORITY_CODE_GENERATOR")
	private Integer authorityCode;
	
	@Column(name="AUTHORITY_NAME")
	private String authorityName;
	
	@Column(name="AUTHORITY_DESC")
	private String authorityDesc;

}
