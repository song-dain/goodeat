package com.greedy.goodeat.user.member.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greedy.goodeat.common.dto.MemberDTO;
import com.greedy.goodeat.common.entity.Member;
import com.greedy.goodeat.user.member.repository.MemberRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class AuthenticationService implements UserDetailsService {

	private final MemberRepository memberRepository;
	private final ModelMapper modelMapper;
	
	public AuthenticationService(MemberRepository memberRepository, ModelMapper modelMapper) {
		this.memberRepository = memberRepository;
		this.modelMapper = modelMapper;
	}
	
	public Map<String, List<String>> getPermitListMap(){
		
		Map<String, List<String>> permitListMap = new HashMap<>();
		
		permitListMap.put("admin", memberRepository.findPermitList("ROLE_ADMIN"));
		permitListMap.put("member", memberRepository.findPermitList("ROLE_MEMBER"));
		
		return permitListMap;
	}

	@Override
	public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
		
		Member selectedMember = memberRepository.findByMemberIdAndMemberStatus(memberId, "Y").orElseThrow(() -> new UsernameNotFoundException("회원 정보가 존재하지 않습니다."));

		MemberDTO member = modelMapper.map(selectedMember, MemberDTO.class);
		
		log.info("[AuthenticationService] member : {}", member);
        
        return member;

	}

}
