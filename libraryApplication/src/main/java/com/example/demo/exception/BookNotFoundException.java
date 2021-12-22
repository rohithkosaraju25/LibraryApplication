package com.example.demo.exception;

public class BookNotFoundException extends Exception {
	String message;

	public BookNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
}
