package org.csc480.bgclub.domain;

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;

/** Parent or legal guardian
 * 
 * @author kenb
 *
 */
@DataTransferObject
public class Guardian extends AbstractPerson{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1783837059118481746L;
	private int guardianId;
	private String employer;

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
	 * @return the employer
	 */
	@RemoteProperty
	public String getEmployer() {
		return employer;
	}

	/**
	 * @param employer the employer to set
	 */
	@RemoteProperty
	public void setEmployer(String employer) {
		this.employer = employer;
	}
	
	
	
	
}
