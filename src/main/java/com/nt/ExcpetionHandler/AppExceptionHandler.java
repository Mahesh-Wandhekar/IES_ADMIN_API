package com.nt.ExcpetionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

	
	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<AppException> handelException(String str){
	
		AppException exception=new AppException();
		exception.setExcCode("EX003");
		exception.setExcDesc(str);
		exception.setExcDate(LocalDateTime.now());
		
		return  new ResponseEntity<>(exception,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
