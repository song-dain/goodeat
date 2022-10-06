package com.greedy.goodeat.user.login.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greedy.goodeat.user.login.repository.LoginRepository;


@Service
@Transactional
public class AuthenticationService implements UserDetailsService {
	
	private final LoginRepository loginRepository;
	
	public AuthenticationService(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}
	
	public Map<String, List<String>> getPermitListMap(){
		
		Map<String, List<String>> permitListMap = new HashMap<>();
		
		permitListMap.put("admin", loginRepository.findPermitList("ROLE_ADMIN"));
		permitListMap.put("member", loginRepository.findPermitList("ROLE_MEMBER"));
		
		return permitListMap;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
