package com.greedy.goodeat.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.greedy.goodeat.common.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	
	@Query(value = "SELECT A.MENU_NAME FROM TBL_GLOBAL_MENU A JOIN TBL_AUTHENTICATED_MENU B ON (A.MENU_CODE = B.MENU_CODE) JOIN TBL_MEMBER_AUTHORITY C ON (B.AUTHORITY_CODE = C.AUTHORITY_CODE) WHERE C.AUTHORITY_NAME = :authorityName", nativeQuery = true)
	public List<String> findPermitList(@Param("authorityName") String authorityName);

}
