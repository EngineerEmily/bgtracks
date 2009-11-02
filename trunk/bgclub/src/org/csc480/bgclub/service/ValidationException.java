package org.csc480.bgclub.service;

import java.util.List;

import org.csc480.bgclub.domain.ValidationIssue;

/** Validation exception
 * 
 * @author kenb
 *
 */
public class ValidationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 871184280232372938L;

	private List<ValidationIssue> issues;
	
	
	/**
	 * 
	 */
	public ValidationException() {
		super();
	}
	

	/**
	 * @param arg0
	 * @param arg1
	 */
	public ValidationException(String message, List<ValidationIssue> issues) {
		super(message);
		this.issues = issues;
	}


	/**
	 * @param arg0
	 * @param arg1
	 */
	public ValidationException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * @param arg0
	 */
	public ValidationException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public ValidationException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @return the issues
	 */
	public List<ValidationIssue> getIssues() {
		return issues;
	}

	/**
	 * @param issues the issues to set
	 */
	public void setIssues(List<ValidationIssue> issues) {
		this.issues = issues;
	}

	
	
	
}
