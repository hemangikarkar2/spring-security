package com.springboot.restAPI.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ErrorDetails {

	private Date timestamp;
	private String message;
	private HttpStatus httpStatus;
	public ErrorDetails(Date timestamp, String message,HttpStatus httpStatus) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.httpStatus =httpStatus;
	}
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
	
}
