package com.nestor.demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.nestor.demo.exception.NotFoundByIdCustomException;
import com.nestor.demo.exception.NotFoundCustomException;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(NotFoundCustomException.class)
	protected ResponseEntity<Object> notFoundCustomException(
			NotFoundCustomException ex, WebRequest request) {

		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	@ExceptionHandler(NotFoundByIdCustomException.class)
	protected ResponseEntity<Object> notFoundByIdCustomException(
			NotFoundByIdCustomException ex, WebRequest request) {

		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	

	

}
