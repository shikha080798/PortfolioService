package com.hcl.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.user.dto.Credentials;
import com.hcl.user.exception.InvalidCredentialsException;
import com.hcl.user.model.User;
import com.hcl.user.service.IUserService;

@RestController

public class UserController {	
	@Autowired
	IUserService userService; 
	
	
	@PostMapping("/users/login")
	public ResponseEntity<String> login(@Valid @RequestBody Credentials credentials)  throws InvalidCredentialsException {
		 return new ResponseEntity<String>(userService.login(credentials), HttpStatus.OK);
	}
	}
	

