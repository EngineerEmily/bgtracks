package org.csc480.bgclub.service;

public class TimeCardException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1099243014662235615L;

	/**
	 * 
	 */
	public TimeCardException() {
		super();
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public TimeCardException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * @param arg0
	 */
	public TimeCardException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public TimeCardException(Throwable arg0) {
		super(arg0);
	}

	
}
