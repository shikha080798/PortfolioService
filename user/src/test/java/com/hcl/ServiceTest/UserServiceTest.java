package com.hcl.ServiceTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hcl.user.dto.Credentials;
import com.hcl.user.exception.InvalidCredentialsException;
import com.hcl.user.model.User;
import com.hcl.user.repository.UserRepository;
import com.hcl.user.service.impl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	UserRepository userRepository;

	@InjectMocks
	UserServiceImpl userServiceImpl;

	static Credentials credentials;
	static User user;

	@BeforeAll
	public static void setUp() {

		credentials = new Credentials();
		credentials.setUserName("Keerthi");
		credentials.setPassword("Nlkp@123");
//credentials.s

		user = new User();
		user.setPassword("Nlkp@123");
		user.setUserId(1);
		user.setPhoneNo(9010989047L);
		user.setUserName("sai");
		user.setMailId("k@gmail.com");
	}

	@Test
	@DisplayName("authentication : positive scenario")
	public void authenticationTest() {
	//context
	when(userRepository.findByUserNameAndPassword("Keerthi", "Nlkp@123")).thenReturn(user);
	//event
	String result = userServiceImpl.login(credentials);
	//outcome
	assertEquals("Login Success", result);
	//assertEquals(HttpStatus.OK, result);
	}
	@Test
	@DisplayName("authentication : negative scenario")
	public void authenticationTest1() {
	//context
	when(userRepository.findByUserNameAndPassword("Keerthi", "Nlkp@123")).thenReturn(null);
	//event and outcome
	assertThrows(InvalidCredentialsException.class, () ->userServiceImpl.login(credentials));
	}
	}