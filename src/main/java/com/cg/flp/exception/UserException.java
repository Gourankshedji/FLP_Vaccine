package com.cg.flp.exception;

public class UserException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	String message;
	
	public class UserNotFoundException extends RuntimeException{
		public UserNotFoundException(String message) {
			super(message);
		}
	}

	public UserException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;

	}

}
