package com.greedy.goodeat.user.member.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.greedy.goodeat.common.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	
	/* 로그인 - 아이디 존재 여부, 회원 상태 체크 */
	@Query(value = "SELECT"
			+ " A.MENU_URL "
			+ "FROM TBL_GLOBAL_MENU A "
			+ "JOIN TBL_AUTHENTICATED_MENU B ON (A.MENU_CODE = B.MENU_CODE) "
			+ "JOIN TBL_MEMBER_AUTHORITY C ON (B.AUTHORITY_CODE = C.AUTHORITY_CODE) "
			+ "WHERE C.AUTHORITY_NAME = :authorityName", nativeQuery = true)
	public List<String> findPermitList(@Param("authorityName") String authorityName);

	/* 로그인, 회원가입 - 아이디 중복 체크 */
	Optional<Member> findByMemberIdAndMemberStatus(String memberId, String memberStatus);
	
	/* 회원가입 - 이메일 중복 체크 */
	Optional<Member> findByEmailAndMemberStatus(String email, String memberStatus);
	
	/* 아이디 찾기 - 존재하는 회원인지 확인*/
	Optional<Member> findByMemberNameAndEmailAndMemberStatus(String memberName, String email, String memberStatus);
	
	/* 아이디 찾기 - 요청 회원 정보 */
	public Member findByMemberNameAndEmail(String memberName, String email);
	
	/* 비밀번호 찾기 - 존재하는 회원인지 확인 */
	Optional<Member> findByMemberIdAndEmailAndMemberStatus(String memberId, String email, String memberStatus);

	/* 비밀번호 찾기 - 요청 회원 정보 */
	public Member findByMemberIdAndEmail(String memberName, String email);
	
	/* 내 정보 조회/수정 - 요청 회원 정보 */
	public Member findByMemberNo(Integer memberNo);
	
}
