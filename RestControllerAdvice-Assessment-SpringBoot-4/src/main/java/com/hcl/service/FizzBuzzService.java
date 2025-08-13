package com.hcl.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.hcl.exceptions.BuzzException;
import com.hcl.exceptions.FizzBuzzException;
import com.hcl.exceptions.FizzException;

@Service
public class FizzBuzzService {

	public ResponseEntity<String> generateResponse(String code) {
		if(code.equals("success")) {
			return ResponseEntity.status(200).body("Successfully completed fizzbuzz test");
		} else if(code.equals("fizz")) {
			throw new FizzException("Fizz exception was thrown");
		} else if(code.equals("buzz")) {
			throw new BuzzException("Buzz exception was thrown");
		} else if(code.equals("fizzbuzz")){
			throw new FizzBuzzException("FizzBuzz exception was thrown");
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Code did not match");
		}
	}

}
