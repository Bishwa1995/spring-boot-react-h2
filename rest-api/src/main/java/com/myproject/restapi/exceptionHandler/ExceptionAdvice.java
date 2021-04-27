package com.myproject.restapi.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handleNotFoundException(RuntimeException ex) {
		return new ResponseEntity<>("Bad request", HttpStatus.BAD_REQUEST);
	}
}