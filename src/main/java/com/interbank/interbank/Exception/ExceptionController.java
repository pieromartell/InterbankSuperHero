package com.interbank.interbank.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.interbank.interbank.DTO.ErrorDTO;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(value = RuntimeException.class )
	public ResponseEntity<ErrorDTO> runTimeExceptionHandle(RuntimeException ex){
		 ErrorDTO error = ErrorDTO.builder().code("").message(ex.getMessage()).build();
		 return new ResponseEntity<ErrorDTO>(error, HttpStatus.BAD_REQUEST);
	}
	
}
