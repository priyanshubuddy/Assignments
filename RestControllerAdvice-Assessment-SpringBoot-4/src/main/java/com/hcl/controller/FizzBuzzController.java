package com.hcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.dto.FizzBuzzResponse;
import com.hcl.service.FizzBuzzService;

@RestController
@RequestMapping("/controller_advice")
public class FizzBuzzController {
	
	@Autowired
	private FizzBuzzService fizzBuzzService;

	@GetMapping("/{code}")
	public ResponseEntity<String> acceptResponse(@PathVariable String code){
		return fizzBuzzService.generateResponse(code);
	}
}
