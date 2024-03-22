package com.bway.springtestdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue
	private int id;
	private String username;
	private String email;
	private String password;
    private String roles;
}
