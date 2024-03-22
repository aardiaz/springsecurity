package com.bway.springtestdemo.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bway.springtestdemo.model.User;
import com.bway.springtestdemo.repository.UserRepository;

public class CustomUserDetailServiceIml  implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> user = userRepo.findByEmail(username);
		
		 return user.map(CustomUserDetailImpl::new)
		  .orElseThrow(()-> new UsernameNotFoundException("username not found"));
		
	}

}
