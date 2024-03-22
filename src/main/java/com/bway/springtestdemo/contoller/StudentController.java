package com.bway.springtestdemo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bway.springtestdemo.model.User;
import com.bway.springtestdemo.repository.UserRepository;

@RestController
public class StudentController {
	
	@Autowired
	private UserRepository  userRepo;
	
	@Autowired
	private  PasswordEncoder  passwordEncoder;
	
	@PreAuthorize("hasAuthority('ROLE_STUDENT')")
	@GetMapping("/studentLogin")
	public String getLogin() {
		
		return "student login";
	}
	
	//@PreAuthorize("hasAuthority('ROLE_STUDENT')")
	@PostMapping("/studentSignup")
	public String getSignup(@RequestBody User user) {
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepo.save(user);
		
		return "signup success";
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/admin")
	public String getAdmin() {
		
		return "welcome to admin";
	}
	
	@PreAuthorize("hasAuthority('ROLE_TEACHER')")
	@GetMapping("/exam")
	public String getExam() {
		
		return "welcome to exam";
	}
	

}
