package com.kuliah.pbkk.service.customer.exception;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public BadRequestException(String infoString) {
		super(infoString);
	}

}
