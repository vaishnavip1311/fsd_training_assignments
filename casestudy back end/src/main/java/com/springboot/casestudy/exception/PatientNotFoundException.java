package com.springboot.casestudy.exception;

public class PatientNotFoundException extends RuntimeException{
	
private static final long serialVersionUID = 1L;
	
	private String message;

	public PatientNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	} 

}
