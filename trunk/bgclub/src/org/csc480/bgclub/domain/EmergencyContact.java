package org.csc480.bgclub.domain;

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;

/** Emergency contact
 * 
 * @author kenb
 *
 */
@DataTransferObject
public class EmergencyContact {

	private Member parent;
	private int emergencyContactId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	
	/** Constructor
	 * 
	 */
	public EmergencyContact(){
	}
	
		
	/**
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 */
	public EmergencyContact(String firstName, String lastName, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}





	/**
	 * @return the parent
	 */
	@RemoteProperty
	public Member getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	@RemoteProperty
	public void setParent(Member parent) {
		this.parent = parent;
	}

	/**
	 * @return the emergencyContactId
	 */
	@RemoteProperty
	public int getEmergencyContactId() {
		return emergencyContactId;
	}
	
	/**
	 * @param emergencyContactId the emergencyContactId to set
	 */
	@RemoteProperty
	public void setEmergencyContactId(int emergencyContactId) {
		this.emergencyContactId = emergencyContactId;
	}
	
	/**
	 * @return the firstName
	 */
	@RemoteProperty
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @param firstName the firstName to set
	 */
	@RemoteProperty
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @return the lastName
	 */
	@RemoteProperty
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @param lastName the lastName to set
	 */
	@RemoteProperty
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * @return the phoneNumber
	 */
	@RemoteProperty
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	@RemoteProperty
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
