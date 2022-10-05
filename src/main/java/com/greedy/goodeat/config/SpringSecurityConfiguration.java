package com.greedy.goodeat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SpringSecurityConfiguration {
	
//	private final AuthenticationService authenticationService;
//	
//	@Autowired
//	public SpringSecurityConfiguration(AuthenticationService authenticationService) {
//		this.AuthenticationService = authenticationService;
//	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean WebSecurityCustomizer configure() {
		return (web) -> web.ignoring().antMatchers("/css/**", "js/**", "/images/**");
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) {
		
		return null;
	}
	

}
