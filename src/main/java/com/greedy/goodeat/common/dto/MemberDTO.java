package com.greedy.goodeat.common.dto;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class MemberDTO implements UserDetails {
	
	private Integer memberNo;
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String phone;
	private String email;
	private String gender;
	private java.sql.Date birthDate;
	private Integer zipCode;
	private String address;
	private String detailAddress;
	private java.sql.Date joinDate;
	private String memberStatus;
	private AuthorityDTO authority;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(authority.getAuthorityName()));
		return roles;
	}
	
	@Override
	public String getPassword() {
		return memberPwd;
	}
	@Override
	public String getUsername() {
		return memberId;
	}
	@Override
	public boolean isAccountNonExpired() {
        return true;
    }
	
	@Override
	public boolean isAccountNonLocked() {
        return true;
    }
	
	@Override
	public boolean isCredentialsNonExpired() {
        return true;
    }
	
	@Override
	public boolean isEnabled() {
        return true; 
    }

}
