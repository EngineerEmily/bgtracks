package org.csc480.bgclub.domain;

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;

/** Medical condition
 * 
 * @author kenb
 *
 */
@DataTransferObject
public class MedicalCondition {

	private Member parent;
	private int medicalConditionId;
	private String name;
	private String notes;
	
	/** Default constructor
	 * 
	 */
	public MedicalCondition(){
	}
	

	/** Constructor
	 * 
	 * @param name
	 * @param notes
	 */
	public MedicalCondition(String name){
		this.name = name;
	}
	
	
	/** Constructor
	 * 
	 * @param name
	 * @param notes
	 */
	public MedicalCondition(String name, String notes){
		this.name = name;
		this.notes = notes;
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
	 * @return the medicalConditionId
	 */
	@RemoteProperty
	public int getMedicalConditionId() {
		return medicalConditionId;
	}
	
	/**
	 * @param medicalConditionId the medicalConditionId to set
	 */
	@RemoteProperty
	public void setMedicalConditionId(int medicalConditionId) {
		this.medicalConditionId = medicalConditionId;
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
	
	/**
	 * @return the notes
	 */
	@RemoteProperty
	public String getNotes() {
		return notes;
	}
	
	/**
	 * @param notes the notes to set
	 */
	@RemoteProperty
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	
}
