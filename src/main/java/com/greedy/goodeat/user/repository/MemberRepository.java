package com.greedy.goodeat.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.greedy.goodeat.common.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	
	@Query(value = "SELECT\r\n"
			+ "      A.MENU_URL\r\n"
			+ " FROM TBL_GLOBAL_MENU A\r\n"
			+ " JOIN TBL_AUTHENTICATED_MENU B ON (A.MENU_CODE = B.MENU_CODE)\r\n"
			+ " JOIN TBL_AUTHORITY C ON (B.AUTHORITY_CODE = C.AUTHORITY_CODE)\r\n"
			+ "WHERE C.AUTHORITY_NAME = :authorityName", nativeQuery = true)
	public List<String> findPermitList(@Param("authorityName") String authorityName);

}
