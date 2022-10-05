package com.greedy.goodeat.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TBL_AUTHORITY")
@Getter
@Setter
@NoArgsConstructor
public class Authority {
	
	@Id
	@Column(name = "AUTHORITY_CODE")
	private int authorityCode;
	
	@Column(name = "AUTHORITY_NAME")
	private String authorityName;
	
	@Column(name = "AUTHORITY_DESC")
	private String authorityDesc;
	
}
