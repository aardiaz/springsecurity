package com.bway.springtestdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	  @Bean
	  public  UserDetailsService  userDetailsService() {
		  
//		  UserDetails user1 = User.withUsername("hari")
//				                  .password(passwordEncoder().encode("1234"))
//				                  .roles("ADMIN")
//				                  .build();
//		  UserDetails user2 = User.withUsername("ram")
//                  .password(passwordEncoder().encode("456"))
//                  .roles("STUDENT")
//                  .build();
//		  new InMemoryUserDetailsManager(user1,user2);
		  
		  return new CustomUserDetailServiceIml();
	  }
	  
	  @Bean
	  public SecurityFilterChain securityFilterChain(HttpSecurity https) throws Exception {
		  
		  https.csrf().disable()
		   .authorizeHttpRequests()
		   .requestMatchers("/studentSignup")
		   .permitAll()
		   .anyRequest()
		   .authenticated()
		   .and()
		   .formLogin() 
		   .permitAll();
		 
		return https.build();
	  }
	  
	  
	  
	  @Bean
	  public  PasswordEncoder  passwordEncoder() {
		  
		  return new BCryptPasswordEncoder();
	  }

}
