package org.csc480.bgclub.domain;

import org.csc480.bgclub.util.hibernate.StringValuedEnum;
import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;

/** Guardian reference
 * 
 * @author kenb
 *
 */
@DataTransferObject
public class GuardianRef {

	public enum RelationshipType implements StringValuedEnum{
		PARENT("PARENT"),
		LEGAL_GUARDIAN("GUARDIAN"),
		OTHER("OTHER");
		

	    /** 
	     * Internal storage of field value
	     */ 
	    private final String code;
	    
	    /** 
	     * Enum constructor 
	     * @param code 
	     */
	    RelationshipType(final String code){
	        this.code = code;
	    }

	    /**
	     * Current string value stored in the enum.
	     * @return string value.
	     */
	    public String getValue() {
	        return this.code;
	    }
	}

	private Member parent;
	private int guardianRefId;
	private int guardianId;
	private RelationshipType relationship;
	
	/** Constructor
	 * 
	 */
	public GuardianRef(){	
	}
	
	
	/** Constructor
	 * 
	 * @param guardianId
	 * @param relationship
	 */
	public GuardianRef(int guardianId, RelationshipType relationship){
		this.guardianId = guardianId;
		this.relationship = relationship;
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
	 * @return the guardianRefId
	 */
	@RemoteProperty
	public int getGuardianRefId() {
		return guardianRefId;
	}
	
	/**
	 * @param guardianRefId the guardianRefId to set
	 */
	@RemoteProperty
	public void setGuardianRefId(int guardianRefId) {
		this.guardianRefId = guardianRefId;
	}
	
	/**
	 * @return the guardianId
	 */
	@RemoteProperty
	public int getGuardianId() {
		return guardianId;
	}
	
	/**
	 * @param guardianId the guardianId to set
	 */
	@RemoteProperty
	public void setGuardianId(int guardianId) {
		this.guardianId = guardianId;
	}
	
	
	/**
	 * @return the relationship
	 */
	@RemoteProperty
	public RelationshipType getRelationship() {
		return relationship;
	}
	
	/**
	 * @param relationship the relationship to set
	 */
	@RemoteProperty
	public void setRelationship(RelationshipType relationship) {
		this.relationship = relationship;
	}
	
	
	
	
	
}
