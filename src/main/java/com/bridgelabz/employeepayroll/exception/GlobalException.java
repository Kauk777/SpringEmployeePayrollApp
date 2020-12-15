package com.bridgelabz.employeepayroll.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bridgelabz.employeepayroll.models.EmpError;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler
	public ResponseEntity<EmpError> handle(EmployeeException ex) {
		if(ex instanceof NotFoundException) {
			return new ResponseEntity<EmpError>(new EmpError(ex.getMessage(),404),HttpStatus.NOT_FOUND);
		}
		if(ex instanceof BadRequestException) {
			return new ResponseEntity<EmpError>(new EmpError(ex.getMessage(),400),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<EmpError>(new EmpError(ex.getMessage(),400),HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
