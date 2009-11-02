package org.csc480.bgclub.domain;

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;


/** Activity
 * 
 * @author kenb
 *
 */
@DataTransferObject
public class Activity {

	private int activityId;
	private String name;
	
	/** Constructor
	 * 
	 */
	public Activity(){
		
	}
	
	/** Constructor
	 * 
	 * @param name
	 */
	public Activity(String name){
		this.name = name;
	}
	
	/**
	 * @return the activityId
	 */
	@RemoteProperty
	public int getActivityId() {
		return activityId;
	}
	
	/**
	 * @param activityId the activityId to set
	 */
	@RemoteProperty
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	
	/**
	 * @return the name
	 */
	@RemoteProperty
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	@RemoteProperty
	public void setName(String name) {
		this.name = name;
	}
	
	
}
