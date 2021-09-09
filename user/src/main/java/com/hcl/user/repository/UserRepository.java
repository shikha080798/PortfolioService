package com.hcl.user.repository;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.user.dto.Credentials;
import com.hcl.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findByUserNameAndPassword(String userName, String password);

	
}
