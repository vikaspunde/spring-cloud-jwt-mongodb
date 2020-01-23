package com.infotech.springjwtsecurityservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.infotech.springjwtsecurityservice.entity.User;
import com.infotech.springjwtsecurityservice.repository.UserRepository;
@Service
public class CustomUserDetailService implements UserDetailsService{
	@Autowired
	private UserRepository userRepository; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		
		UserBuilder builder = null;
	    if (user != null) {
	      builder = org.springframework.security.core.userdetails.User.withUsername(user.getUsername());
	      builder.password(user.getPassword());
	      List<GrantedAuthority> role_name =new ArrayList<>();
	      builder.authorities(role_name);
	      
	    } else {
	      throw new UsernameNotFoundException("User not found.");
	    }

		return builder.build();
	}
	
}
