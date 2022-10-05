package com.greedy.goodeat.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Entity
@Table(name = "TBL_GLOBAL_MENU")
@SequenceGenerator(name = "GLOBAL_MENU_SEQ_GENERATOR", sequenceName = "SEQ_MENU_CODE", initialValue = 1, allocationSize = 1)
@DynamicInsert
public class GlobalMenu {
	
	@Id
	@Column(name="MENU_CODE")
	private Integer menuCode;
	
	@Column(name="MENU_URL")
	private String menuUrl;
	
	@Column(name="MENU_DESC")
	private String menuDesc;
	
	@Column(name="MENU_NAME")
	private String menuName;

}
