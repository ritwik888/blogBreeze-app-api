package com.blogbreeze.app.api.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blogbreeze.app.api.payloads.ApiResponse;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(value= {ResourceNotFoundException.class})
	public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException re){
		return null;
	}
	
}
