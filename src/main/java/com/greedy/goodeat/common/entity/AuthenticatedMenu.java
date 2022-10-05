package com.greedy.goodeat.common.entity;

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
@Table(name = "TBL_AUTHENTICATED_MENU")
@DynamicInsert
public class AuthenticatedMenu {
	
	
	@Id
	@Column(name = "AUTHENTICATED_MENU_CODE")
	private Integer authenticatedMenuCode;
	
	@ManyToOne
	@JoinColumn(name = "AUTHORITY_CODE")
	private MemberAuthority memberAuthority;
	
	
	@ManyToOne
	@JoinColumn(name = "MENU_CODE")
	private GlobalMenu globalMenu;

}
