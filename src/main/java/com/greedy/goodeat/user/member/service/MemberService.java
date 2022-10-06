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

	public boolean selectMemberById(String memberId) {
		return memberRepository.findByMemberIdAndMemberStatus(memberId, "Y").isPresent();
	}

	public void joinMembership(MemberDTO member) {
		
		memberRepository.save(modelMapper.map(member, Member.class));
		
	}

}
