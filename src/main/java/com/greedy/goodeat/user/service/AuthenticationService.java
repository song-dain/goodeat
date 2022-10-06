package com.greedy.goodeat.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greedy.goodeat.user.repository.MemberRepository;

@Service
@Transactional
public class AuthenticationService implements UserDetailsService {
	
	private final MemberRepository memberRepository;
	
	public AuthenticationService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	public Map<String, List<String>> getPermitListMap(){
		
		Map<String, List<String>> permitListMap = new HashMap<>();
		
		permitListMap.put("admin", memberRepository.findPermitList("ROLE_ADMIN"));
		permitListMap.put("member", memberRepository.findPermitList("ROLE_MEMBER"));
		
		return permitListMap;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
