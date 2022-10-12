package com.greedy.goodeat.user.member.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.greedy.goodeat.common.dto.MemberDTO;
import com.greedy.goodeat.common.entity.Member;
import com.greedy.goodeat.user.member.repository.MemberRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class MemberService {
	
	private final MemberRepository memberRepository;
	private final ModelMapper modelMapper;
	
	public MemberService(MemberRepository memberRepsoitory, ModelMapper modelMapper) {
		this.memberRepository = memberRepsoitory;
		this.modelMapper = modelMapper;
	}

	public boolean selectMemberById(String memberId) {
		
		return memberRepository.findByMemberIdAndMemberStatus(memberId, "Y").isPresent();
	}
	
	public boolean selectMemberByNameAndEmail(String memberName, String email) {
		
		boolean isExist = false;
		
		if(memberRepository.findByMemberNameAndMemberStatus(memberName, "Y").isPresent()
				&& memberRepository.findByEmailAndMemberStatus(email, "Y").isPresent()) {
			isExist = true;
		}
		
		return isExist;
	}

	public void joinMembership(MemberDTO member) {
		
		memberRepository.save(modelMapper.map(member, Member.class));
		
	}


	public boolean selectMemberByIdAndEmail(String memberId, String email) {
		
		boolean isExist = false;
		
		if(memberRepository.findByMemberIdAndMemberStatus(memberId, "Y").isPresent()
				&& memberRepository.findByEmailAndMemberStatus(email, "Y").isPresent()) {
			isExist = true;
		}
		
		return isExist;
	}
	
	public MemberDTO findByMemberIdAndEmail(MemberDTO member) {
		
		Member findmember = memberRepository.findByMemberIdAndEmail(member.getMemberId(), member.getEmail());
		
		return modelMapper.map(findmember, MemberDTO.class);
	}

	public MemberDTO findByMemberNameAndEmail(MemberDTO member) {
		
		log.info("[MemberService] memberName : {}", member.getMemberName());
		log.info("[MemberService] email : {}", member.getEmail());
		
		Member findmember = memberRepository.findByMemberNameAndEmail(member.getMemberName(), member.getEmail());

		
		return modelMapper.map(findmember, MemberDTO.class);
	}

	public void changeMemberPwd(MemberDTO findMember) {
		
		Member member = memberRepository.findByMemberIdAndEmail(findMember.getMemberId(), findMember.getEmail());
		member.setMemberPwd(findMember.getMemberPwd());
		
		memberRepository.save(member);
		
	}

	public void unjoinMembership(MemberDTO loginMember) {
		
		Member unjoinMember = memberRepository.findByMemberNo(loginMember.getMemberNo());
		unjoinMember.setMemberStatus("N");
		
	}

}
