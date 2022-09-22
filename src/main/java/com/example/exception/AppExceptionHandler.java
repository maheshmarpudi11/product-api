package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> catchRuntimeException(RuntimeException e){
		
		ErrorResponse er = new ErrorResponse();
		er.setErrorMsg(e.getMessage());
		er.setErrorCode("500");
		
		return new ResponseEntity<ErrorResponse>(er,HttpStatus.INTERNAL_SERVER_ERROR);  // error object and 500
	}	
	
	@ExceptionHandler(ProductNotFound.class)
	public ResponseEntity<ErrorResponse> catchProductNotFoundException(RuntimeException e){
		
		ErrorResponse er = new ErrorResponse();
		er.setErrorMsg(e.getMessage());
		er.setErrorCode("300");
		
		return new ResponseEntity<ErrorResponse>(er,HttpStatus.OK);  // error object and 500
	}

}
