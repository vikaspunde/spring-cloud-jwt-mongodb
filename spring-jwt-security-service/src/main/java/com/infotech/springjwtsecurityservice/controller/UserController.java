package com.infotech.springjwtsecurityservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infotech.springjwtsecurityservice.entity.AuthRequest;
import com.infotech.springjwtsecurityservice.util.JWTUtil;

@RestController
public class UserController {
	
	@Autowired 
	private JWTUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@GetMapping("/hello")
	public String hello()
	{
		return "hello";
	}
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		
		try {
		authManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception("invalid username / password");
		}
		
		return jwtUtil.generateToken(authRequest.getUsername());
	}
}
