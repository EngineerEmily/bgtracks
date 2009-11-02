package org.csc480.bgclub.domain;

/** Validation issue
 * 
 * @author kenb
 *
 */
public class ValidationIssue {

	private Object object;
	private String code;
	private String description;
	private IssueSeverity severity;
	
	/** Issue severity
	 * 
	 * @author kenb
	 *
	 */
	public enum IssueSeverity{
		INFO(0),
		WARN(1),
		ERROR(2);
		
		private final int value;
	    
		IssueSeverity(int value){
			this.value = value;
		}
		
		public int getValue(){
			return value;
		}
	}
	
	/** Constructor
	 * 
	 */
	public ValidationIssue(){
	}
	
	/**
	 * @param object
	 * @param code
	 * @param description
	 */
	public ValidationIssue(Object object, IssueSeverity severity, String code, String description) {
		this.object = object;
		this.code = code;
		this.description = description;
		this.severity = severity;
	}
	/**
	 * @return the object
	 */
	public Object getObject() {
		return object;
	}
	/**
	 * @param object the object to set
	 */
	public void setObject(Object object) {
		this.object = object;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the severity
	 */
	public IssueSeverity getSeverity() {
		return severity;
	}

	/**
	 * @param severity the severity to set
	 */
	public void setSeverity(IssueSeverity severity) {
		this.severity = severity;
	}
	
	
	
	
}
