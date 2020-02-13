package com.mycompany.falg.exception;

/**
 * The Class DataNotFoundException.
 */
public class DataNotFoundException extends Exception {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 795447721794187825L;


	/**
	 * Instantiates a new data not found exception.
	 */
	public DataNotFoundException() {
		super();
	}

	/**
	 * Instantiates a new data not found exception.
	 *
	 * @param message the message
	 */
	public DataNotFoundException(String message) {
		super(message);
	}
}
