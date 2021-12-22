package com.example.demo.exception;

public class BookAlreadyExistsException extends Exception{
	String message;

	public BookAlreadyExistsException(String message) {
		super();
		this.message = message;
	}
	
	@Override 
	public String getMessage() {
		return message;
	}
	
	
}
