package com.cg.flp.exception;

public class HospitalException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	String message;

	public HospitalException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;

	}

}
