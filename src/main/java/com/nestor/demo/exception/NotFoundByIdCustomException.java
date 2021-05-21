package com.nestor.demo.exception;

public class NotFoundByIdCustomException extends Exception {

	public NotFoundByIdCustomException() {
		super("Id cannot be zero or negative");
	}
}
