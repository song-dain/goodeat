package com.greedy.goodeat.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.greedy.goodeat.user.repository.MemberRepository;

@Service
@Transactional
public class AuthenticationService {
	
	private final MemberRepository memberRepository;
	
	public AuthenticationService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	public Map<String, List<String>> getPermitListMap(){
		
		Map<String, List<String>> permitListMap = new HashMap<>();
		
		permitListMap.put("admin", memberRepository.findPermitList("ROLE_ADMIN"));
		permitListMap.put("admin", memberRepository.findPermitList("ROLE_MEMBER"));
		
		return permitListMap;
	}

}
