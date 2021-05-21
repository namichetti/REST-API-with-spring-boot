package com.nestor.demo.exception;

public class NotFoundCustomException extends Exception {

	public NotFoundCustomException() {
		super("Not found by Id");
	}
}
