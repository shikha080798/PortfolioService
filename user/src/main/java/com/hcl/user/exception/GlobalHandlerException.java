package com.hcl.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4149319448425801792L;

	@ExceptionHandler( InvalidCredentialsException.class)
	public ResponseEntity<ErrorDetails> exceptionHandling( InvalidCredentialsException exception){
	ErrorDetails errorDetails = new ErrorDetails();
	errorDetails.setMessage(exception.getMessage());
	errorDetails.setStatusCode(500);
	return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.OK);
	}
}
