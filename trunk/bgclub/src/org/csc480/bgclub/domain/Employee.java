package org.csc480.bgclub.domain;

import java.util.Date;

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;

/** Employee
 * 
 * @author kenb
 *
 */
@DataTransferObject
public class Employee extends AbstractPerson{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3546947248191487799L;
	private int employeeId;
	private Date startDt;
	private Date terminationDt;
	private String title;

	/** Default constructor
	 * 
	 */
	public Employee(){
	}


	/** 
	 * 
	 * @return employee id
	 */
	@RemoteProperty
	public int getEmployeeId() {
		return employeeId;
	}


	/**
	 * 
	 * @param employeeId
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	

	/**
	 * 
	 * @return start date
	 */
	@RemoteProperty
	public Date getStartDt() {
		return startDt;
	}
	

	/**
	 * 
	 * @param startDt
	 */
	public void setStartDt(Date startDt) {
		this.startDt = startDt;
	}
	

	/**
	 * 
	 * @return termination date
	 */
	@RemoteProperty
	public Date getTerminationDt() {
		return terminationDt;
	}
	

	/**
	 * 
	 * @param terminationDt
	 */
	public void setTerminationDt(Date terminationDt) {
		this.terminationDt = terminationDt;
	}
	

	/**
	 * 
	 * @return title
	 */
	@RemoteProperty
	public String getTitle() {
		return title;
	}


	/** 
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	
	
	
}
