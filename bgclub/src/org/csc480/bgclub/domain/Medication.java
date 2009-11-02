package org.csc480.bgclub.domain;

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;

/** Medication
 * 
 * @author kenb
 *
 */
@DataTransferObject
public class Medication {

	private int medicationId;
	private Member parent;
	private String name;
	private String notes;
	
	/** Default constructor
	 * 
	 */
	public Medication(){
		
	}

	/**
	 * @param name
	 */
	public Medication(String name) {
		this.name = name;
	}

	
	/**
	 * @param name
	 * @param notes
	 */
	public Medication(String name, String notes) {
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
	 * @return the medicationId
	 */
	@RemoteProperty
	public int getMedicationId() {
		return medicationId;
	}
	
	/**
	 * @param medicationId the medicationId to set
	 */
	@RemoteProperty
	public void setMedicationId(int medicationId) {
		this.medicationId = medicationId;
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
