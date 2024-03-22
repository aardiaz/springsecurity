package com.bway.springtestdemo.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bway.springtestdemo.model.User;

public class CustomUserDetailImpl implements UserDetails {

	private String username;
	private String password;
	private List<GrantedAuthority> grantedAuthority;
	
	public CustomUserDetailImpl(User user) {
		 
		username = user.getUsername();
		password = user.getPassword();
		grantedAuthority = Arrays.stream(user.getRoles().split(","))
				                  .map(SimpleGrantedAuthority::new)
				                  .collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return grantedAuthority;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
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
