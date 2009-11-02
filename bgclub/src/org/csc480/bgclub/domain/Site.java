package org.csc480.bgclub.domain;

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;

/** Site
 * 
 * @author kenb
 *
 */
@DataTransferObject
public class Site {

	private int siteId;
	private String name;
	
	/** Constructor
	 * 
	 */
	public Site(){
	}
	
	/** Constructor
	 * 
	 * @param name
	 */
	public Site(String name){
		this.name = name;
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
