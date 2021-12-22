package com.example.demo.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.BookAlreadyExistsException;
import com.example.demo.exception.BookNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandlingAdvice {
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<String> exceptionhandling(BookNotFoundException ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BookAlreadyExistsException.class)
	public ResponseEntity<String> exceptionhandling(BookAlreadyExistsException ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.METHOD_NOT_ALLOWED);
	}
}
