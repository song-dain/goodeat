package com.greedy.goodeat.user.member.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.greedy.goodeat.common.dto.MemberDTO;
import com.greedy.goodeat.common.entity.Member;
import com.greedy.goodeat.user.member.repository.MemberRepository;

@Service
@Transactional
public class MemberService {
	
	private final MemberRepository memberRepository;
	private final ModelMapper modelMapper;
	
	public MemberService(MemberRepository memberRepsoitory, ModelMapper modelMapper) {
		this.memberRepository = memberRepsoitory;
		this.modelMapper = modelMapper;
	}

	
	/* 회원가입 - 아이디 중복 체크 */
	public boolean selectMemberById(String memberId) {
		
		return memberRepository.findByMemberIdAndMemberStatus(memberId, "Y").isPresent();
	}
	
	
	/* 회원가입 - 이메일 중복 체크 */
	public boolean selectMemberByEmail(String email) {
		
		return memberRepository.findByEmailAndMemberStatus(email, "Y").isPresent();
	}
	
	
	/* 회원가입 */
	public void joinMembership(MemberDTO member) {
		
		memberRepository.save(modelMapper.map(member, Member.class));
	}
	
	
	/* 아이디 찾기 - 존재하는 회원인지 확인 */
	public boolean selectMemberByNameAndEmail(String memberName, String email) {
		
		boolean isExist = false;
		
		if(memberRepository.findByMemberNameAndEmailAndMemberStatus(memberName, email, "Y").isPresent()) {
			isExist = true;
		}
		
		return isExist;
	}
	
	
	/* 아이디 찾기 - 존재하는 회원 정보 */
	public MemberDTO findByMemberNameAndEmail(MemberDTO member) {
		
		Member findmember = memberRepository.findByMemberNameAndEmail(member.getMemberName(), member.getEmail());

		return modelMapper.map(findmember, MemberDTO.class);
	}
	
	
	/* 비밀번호 찾기 - 존재하는 회원인지 확인 */
	public boolean selectMemberByIdAndEmail(String memberId, String email) {
		
		boolean isExist = false;
		
		if(memberRepository.findByMemberIdAndEmailAndMemberStatus(memberId, email, "Y").isPresent()) {
			isExist = true;
		}
		
		return isExist;
	}
	
	
	/* 비밀번호 찾기 - 존재하는 회원 정보 */
	public MemberDTO findByMemberIdAndEmail(MemberDTO member) {
		
		Member findmember = memberRepository.findByMemberIdAndEmail(member.getMemberId(), member.getEmail());
		
		return modelMapper.map(findmember, MemberDTO.class);
	}
	
	
	/* 비밀번호 찾기 - 임시 비밀번호로 변경 */
	public void changeMemberPwd(MemberDTO findMember) {
		
		Member member = memberRepository.findByMemberIdAndEmail(findMember.getMemberId(), findMember.getEmail());
		member.setMemberPwd(findMember.getMemberPwd());
		
		memberRepository.save(member);
	}
	
	
	/* 내 정보 조회/수정 - 수정 정보 저장 */
	public void modifyInfo(MemberDTO updateMember) {
		
		Member saveMember = memberRepository.findByMemberNo(updateMember.getMemberNo());
		saveMember.setMemberPwd(updateMember.getPassword());
		saveMember.setMemberName(updateMember.getMemberName());
		saveMember.setPhone(updateMember.getPhone());
		saveMember.setZipCode(updateMember.getZipCode());
		saveMember.setAddress(updateMember.getAddress());
		saveMember.setDetailAddress(updateMember.getDetailAddress());
		saveMember.setGender(updateMember.getGender());
	}

	
	/* 회원탈퇴 - 회원 상태 변경 */
	public void unjoinMembership(MemberDTO loginMember) {
		
		Member unjoinMember = memberRepository.findByMemberNo(loginMember.getMemberNo());
		unjoinMember.setMemberStatus("N");
	}

	
}
