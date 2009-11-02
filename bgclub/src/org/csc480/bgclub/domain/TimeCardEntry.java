package org.csc480.bgclub.domain;

import java.util.Date;

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;


/** Timecard entry
 * 
 * @author kenb
 *
 */
@DataTransferObject
public class TimeCardEntry implements Cloneable{

	private int timeCardId;
	private int employeeId;
	private Date clockinTm;
	private Date clockoutTm;
	private int minutes;
	private int siteId;
	
	/**
	 * @return the timeCardId
	 */
	@RemoteProperty
	public int getTimeCardId() {
		return timeCardId;
	}
	
	/**
	 * @param timeCardId the timeCardId to set
	 */
	@RemoteProperty
	public void setTimeCardId(int timeCardId) {
		this.timeCardId = timeCardId;
	}
	
	/**
	 * @return the employeeId
	 */
	@RemoteProperty
	public int getEmployeeId() {
		return employeeId;
	}
	
	/**
	 * @param employeeId the employeeId to set
	 */
	@RemoteProperty
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	/**
	 * @return the clockinTm
	 */
	@RemoteProperty
	public Date getClockinTm() {
		return clockinTm;
	}
	
	/**
	 * @param clockinTm the clockinTm to set
	 */
	@RemoteProperty
	public void setClockinTm(Date clockinTm) {
		this.clockinTm = clockinTm;
	}
	
	/**
	 * @return the clockoutTm
	 */
	@RemoteProperty
	public Date getClockoutTm() {
		return clockoutTm;
	}
	
	/**
	 * @param clockoutTm the clockoutTm to set
	 */
	@RemoteProperty
	public void setClockoutTm(Date clockoutTm) {
		this.clockoutTm = clockoutTm;
	}
	
	/**
	 * @return the minutes
	 */
	@RemoteProperty
	public int getMinutes() {
		return minutes;
	}
	
	/**
	 * @param minutes the minutes to set
	 */
	@RemoteProperty
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
	

	/**
	 * @return the siteId
	 */
	@RemoteProperty
	public int getSiteId() {
		return siteId;
	}

	/**
	 * @param siteId the siteId to set
	 */
	@RemoteProperty
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	@Override
	public Object clone()  {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
		
		
	}
	
	
	
	
}
