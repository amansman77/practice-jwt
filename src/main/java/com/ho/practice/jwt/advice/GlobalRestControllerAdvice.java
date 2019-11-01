package com.ho.practice.jwt.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ho.practice.jwt.exception.UnauthorizedException;

@RestControllerAdvice
public class GlobalRestControllerAdvice {
	
	@ExceptionHandler(value = {UnauthorizedException.class})
	public ResponseEntity<String> unauthorizedException(UnauthorizedException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNAUTHORIZED);
	}

}
