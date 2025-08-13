package com.hcl.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hcl.dto.FizzBuzzResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(FizzBuzzException.class)
	public ResponseEntity<FizzBuzzResponse> handleFizzBuzzException(FizzBuzzException ex) {
		FizzBuzzResponse response = new FizzBuzzResponse();
		response.setMessage(ex.getMessage());
		response.setErrorReason("Insufficient storage");
		
		return ResponseEntity.status(HttpStatusCode.valueOf(507)).body(response);
    }
	
	@ExceptionHandler(FizzException.class)
	public ResponseEntity<FizzBuzzResponse> handleFizzException(FizzException ex) {
		FizzBuzzResponse response = new FizzBuzzResponse();
		response.setMessage(ex.getMessage());
		response.setErrorReason("Internal Server Error");
		
		return ResponseEntity.status(HttpStatusCode.valueOf(500)).body(response);
    }
	
	@ExceptionHandler(BuzzException.class)
	public ResponseEntity<FizzBuzzResponse> handleBuzzException(BuzzException ex) {
		FizzBuzzResponse response = new FizzBuzzResponse();
		response.setMessage(ex.getMessage());
		response.setErrorReason("Bad request");
		
		return ResponseEntity.status(HttpStatusCode.valueOf(400)).body(response);
    }
}
