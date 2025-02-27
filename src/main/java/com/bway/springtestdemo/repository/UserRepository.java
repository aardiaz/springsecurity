package com.bway.springtestdemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.springtestdemo.model.User;

public interface UserRepository  extends JpaRepository<User, Integer>{
  
	Optional<User>  findByEmail(String email);
}
