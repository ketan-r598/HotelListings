package com.dxc.exception;

public class HotelDoesNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HotelDoesNotExistException() {
		super();
	}

	public HotelDoesNotExistException(String message) {
		super(message);
	}
	

}
