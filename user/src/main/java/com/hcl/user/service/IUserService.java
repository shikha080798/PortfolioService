package com.hcl.user.service;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.hcl.user.dto.Credentials;
import com.hcl.user.exception.InvalidCredentialsException;


public interface IUserService {


	String login(@Valid Credentials credentials);


}
