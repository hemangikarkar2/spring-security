package com.springboot.restAPI.Exception;

import org.springframework.http.HttpStatus;

public class customException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	HttpStatus httpStatus;

	private String message;
	
	public customException(String message){
		super(message);
		this.message =message;
	}
	public customException(String message,HttpStatus httpStatus) {
		super();
		this.httpStatus = httpStatus;
		this.message =message;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
