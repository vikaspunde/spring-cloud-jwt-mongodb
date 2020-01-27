package com.infotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infotech.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findByUserName(String username);
}
