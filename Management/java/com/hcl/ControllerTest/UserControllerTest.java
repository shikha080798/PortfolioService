package com.hcl.ControllerTest;

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

import com.hcl.user.controller.UserController;
import com.hcl.user.dto.Credentials;
import com.hcl.user.exception.InvalidCredentialsException;
import com.hcl.user.service.IUserService;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

	@Mock
	IUserService userService;
	@InjectMocks
	UserController userController;
	static Credentials credentials;

	// static CustomerRequestDto login;
	// static CustomerRequestDto negativeLogin;
	@BeforeAll
	public static void setUp() {
		credentials = new Credentials();
		credentials.setPassword("1234");
		credentials.setUserName("Keerthi");
	}

	@Test
	@DisplayName("Login Function: Positive Scenario")
	public void loginTest() throws InvalidCredentialsException {
		// context
		when(userService.login(credentials)).thenReturn("Login Success");
		// event
		String result = userService.login(credentials);
		// outcome
		assertEquals("Login Success", result);
//		assertEquals(HttpStatus.OK, result);
	}

	@Test
	@DisplayName("Login Function: Negative Scenario")
	public void loginTest2() throws InvalidCredentialsException {
		// context
		when(userService.login(credentials)).thenThrow(InvalidCredentialsException.class);
		// event
		// outcome
		assertThrows(InvalidCredentialsException.class, () -> userController.login(credentials));
	}
}
