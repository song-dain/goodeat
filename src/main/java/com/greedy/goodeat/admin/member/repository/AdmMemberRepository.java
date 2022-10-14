package com.greedy.goodeat.admin.member.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greedy.goodeat.admin.member.entity.AdmJyMember;

public interface AdmMemberRepository extends JpaRepository<AdmJyMember, Integer>{

	@Query("SELECT m " +
			 "FROM AdmJyMember m " + 
			"WHERE m.memberName LIKE '%' || :searchValue || '%'")
	Page<AdmJyMember> finBySearchValue(String searchValue, Pageable pageable);
	
	

}
