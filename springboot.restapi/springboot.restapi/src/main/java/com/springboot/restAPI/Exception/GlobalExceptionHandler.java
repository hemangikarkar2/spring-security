package com.springboot.restAPI.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice 
public class GlobalExceptionHandler {

	//handling custom validation errors
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails>  customvalidationErrorHandling(MethodArgumentNotValidException exception){
		//ErrorDetails errorDetails = new ErrorDetails(new Date(), "validation Error", exception.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<ErrorDetails>(new ErrorDetails(new Date(), "validation Error",HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
			
	}
	
	//this is exception class w
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> globalExceptionHandling(Exception exception ,WebRequest webRequest){
		//ErrorDetails errorDetails =new ErrorDetails(new Date(),exception.getMessage(), webRequest.getDescription(false));
		return new ResponseEntity<ErrorDetails>(new ErrorDetails(new Date(),exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(customException.class)
	public ResponseEntity<ErrorDetails> handledExceptiopn(customException exception ){
		//ErrorDetails errorDetails=new ErrorDetails(new Date(),exception.getMessage(),webRequest.getDescription(false));
		//return new ResponseEntity<>(exception.body());
		
		return new ResponseEntity<ErrorDetails>(new ErrorDetails(new Date(),exception.getMessage(),HttpStatus.CONFLICT),HttpStatus.CONFLICT);
	}
}

