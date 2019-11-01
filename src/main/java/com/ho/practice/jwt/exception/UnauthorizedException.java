package com.ho.practice.jwt.exception;

public class UnauthorizedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7545169112228181351L;
	
	public UnauthorizedException(String msg) {
		super(msg);
	}

}
