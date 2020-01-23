package com.infotech.springjwtsecurityservice;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import com.infotech.springjwtsecurityservice.entity.User;
import com.infotech.springjwtsecurityservice.repository.UserRepository;
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class SpringJwtSecurityServiceApplication {
	@Autowired
	private UserRepository userrepo;
	
	@PostConstruct
	public void initUSers() {
		List<User> listOfUsers = Stream.of(new User(101, "Vikas", "vikas@123", "vikas@gmail.com"),
									new User(102, "Test", "test@123", "test@gmail.com"))
									.collect(Collectors.toList());
		
		
				userrepo.saveAll(listOfUsers);
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringJwtSecurityServiceApplication.class, args);
	}

}
