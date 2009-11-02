package org.csc480.bgclub.domain;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;


/** Member
 * 
 * @author kenb
 *
 */
@DataTransferObject()
public class Member extends AbstractPerson implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3214527314455813895L;
	@RemoteProperty
	private int memberId;
	@RemoteProperty
	private Integer siteId;
	@RemoteProperty
	private Date startDt;
	@RemoteProperty
	private Date terminationDt;
	@RemoteProperty
	private String schoolCd;
	@RemoteProperty
	private String gradeLevelCd;
	@RemoteProperty
	private String teacherName;
	@RemoteProperty
	private String doctorName;
	@RemoteProperty
	private String doctorPhone;
	@RemoteProperty
	private boolean insured;
	@RemoteProperty
	private String insuranceGroupNumber;
	@RemoteProperty
	private String insuranceMemberNumber;
	@RemoteProperty
	private String primaryLanguageCd;
	@RemoteProperty
	private boolean singleParentHousehold;
	@RemoteProperty
	private boolean militaryChild;
	private Set<GuardianRef> guardianRefs = new LinkedHashSet<GuardianRef>();
	private Set<Medication> medications = new LinkedHashSet<Medication>();
	private Set<MedicalCondition> conditions = new LinkedHashSet<MedicalCondition>();
	private Set<EmergencyContact> contacts = new LinkedHashSet<EmergencyContact>();
	
	/** Member
	 * 
	 */
	public Member(){
	}
	
	/** Constrcutor
	 * 
	 * @param firstName
	 * @param lastName
	 * @param startDt
	 */
	public Member(String firstName, String lastName, Date startDt){
		this.setFirstName(firstName);
		this.setLastName( lastName );
		this.startDt = startDt;
	}
	
	/**
	 * 
	 * @return member id
	 */
	
	public int getMemberId() {
		return memberId;
	}

	/**
	 * 
	 * @param memberId
	 */
	@RemoteProperty
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	
	
	/**
	 * @return the siteId
	 */
	@RemoteProperty
	public Integer getSiteId() {
		return siteId;
	}

	/**
	 * @param siteId the siteId to set
	 */
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	/**
	 * @return the startDt
	 */
	@RemoteProperty
	public Date getStartDt() {
		return startDt;
	}

	/**
	 * @param startDt the startDt to set
	 */
	public void setStartDt(Date startDt) {
		this.startDt = startDt;
	}

	/**
	 * @return the terminationDt
	 */
	@RemoteProperty
	public Date getTerminationDt() {
		return terminationDt;
	}

	/**
	 * @param terminationDt the terminationDt to set
	 */
	public void setTerminationDt(Date terminationDt) {
		this.terminationDt = terminationDt;
	}

	/**
	 * @return the schoolCd
	 */
	@RemoteProperty
	public String getSchoolCd() {
		return schoolCd;
	}

	/**
	 * @param schoolCd the schoolCd to set
	 */
	public void setSchoolCd(String schoolCd) {
		this.schoolCd = schoolCd;
	}

	/**
	 * @return the gradeLevelCd
	 */
	@RemoteProperty
	public String getGradeLevelCd() {
		return gradeLevelCd;
	}

	/**
	 * @param gradeLevelCd the gradeLevelCd to set
	 */
	public void setGradeLevelCd(String gradeLevelCd) {
		this.gradeLevelCd = gradeLevelCd;
	}

	
	/**
	 * @return the teacherName
	 */
	@RemoteProperty
	public String getTeacherName() {
		return teacherName;
	}

	/**
	 * @param teacherName the teacherName to set
	 */
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	/**
	 * @return the doctorName
	 */
	@RemoteProperty
	public String getDoctorName() {
		return doctorName;
	}

	/**
	 * @param doctorName the doctorName to set
	 */
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	/**
	 * @return the doctorPhone
	 */
	@RemoteProperty
	public String getDoctorPhone() {
		return doctorPhone;
	}

	/**
	 * @param doctorPhone the doctorPhone to set
	 */
	public void setDoctorPhone(String doctorPhone) {
		this.doctorPhone = doctorPhone;
	}

	/**
	 * @return if insured
	 */
	@RemoteProperty
	public boolean getInsured() {
		return insured;
	}

	/**
	 * @param insured the insured indicator to set
	 */
	public void setInsured(boolean insured) {
		this.insured = insured;
	}

	/**
	 * @return the insuranceGroupNumber
	 */
	@RemoteProperty
	public String getInsuranceGroupNumber() {
		return insuranceGroupNumber;
	}

	/**
	 * @param insuranceGroupNumber the insuranceGroupNumber to set
	 */
	public void setInsuranceGroupNumber(String insuranceGroupNumber) {
		this.insuranceGroupNumber = insuranceGroupNumber;
	}

	/**
	 * @return the insuranceMemberNumber
	 */
	@RemoteProperty
	public String getInsuranceMemberNumber() {
		return insuranceMemberNumber;
	}

	/**
	 * @param insuranceMemberNumber the insuranceMemberNumber to set
	 */
	public void setInsuranceMemberNumber(String insuranceMemberNumber) {
		this.insuranceMemberNumber = insuranceMemberNumber;
	}
	
	
	
	/**
	 * @return the primaryLanguageCd
	 */
	@RemoteProperty
	public String getPrimaryLanguageCd() {
		return primaryLanguageCd;
	}

	/**
	 * @param primaryLanguageCd the primaryLanguageCd to set
	 */
	public void setPrimaryLanguageCd(String primaryLanguageCd) {
		this.primaryLanguageCd = primaryLanguageCd;
	}

	/**
	 * @return the singleParentHousehold
	 */
	@RemoteProperty
	public boolean getSingleParentHousehold() {
		return singleParentHousehold;
	}

	/**
	 * @param singleParentHousehold the singleParentHousehold to set
	 */
	public void setSingleParentHousehold(boolean singleParentHousehold) {
		this.singleParentHousehold = singleParentHousehold;
	}

	/**
	 * @return the militaryChild indicator
	 */
	@RemoteProperty
	public boolean getMilitaryChild() {
		return militaryChild;
	}

	/**
	 * @param militaryChild the militaryChild indicator to set
	 */
	public void setMilitaryChild(boolean militaryChild) {
		this.militaryChild = militaryChild;
	}

	/**
	 * @return the guardians
	 */
	@RemoteProperty
	public Set<GuardianRef> getGuardianRefs() {
		return Collections.unmodifiableSet(guardianRefs);
	}
	
	/** Add a guardian ref
	 * 
	 * @param ref
	 */
	public void addGuardianRef(GuardianRef ref){
		guardianRefs.add(ref);
		ref.setParent(this);
	}
	
	/**
	 * @param guardianRefs the guardianRef to set
	 */
	@RemoteProperty
	public void setGuardianRefs(Set<GuardianRef> guardianRefs) {
		this.guardianRefs = guardianRefs;
		for(GuardianRef ref : guardianRefs){
			ref.setParent(this);
		}
	}

	/**
	 * @return the medications
	 */
	public Set<Medication> getMedications() {
		return Collections.unmodifiableSet(medications);
	}

	/** Add a medication
	 * 
	 * @param med
	 */
	@RemoteProperty
	public void addMedication(Medication med){
		this.medications.add(med);
		med.setParent(this);
	}
	
	/**
	 * @param medications the medications to set
	 */
	public void setMedications(Set<Medication> medications) {
		this.medications = medications;
		for(Medication med : medications){
			med.setParent(this);
		}
	}

	/**
	 * @return the conditions
	 */
	public Set<MedicalCondition> getConditions() {
		return Collections.unmodifiableSet(conditions);
	}
	
	public void addCondition(MedicalCondition condition){
		conditions.add(condition);
		condition.setParent(this);
	}

	/**
	 * @param conditions the conditions to set
	 */
	public void setConditions(Set<MedicalCondition> conditions) {
		this.conditions = conditions;
		for(MedicalCondition condition : conditions){
			condition.setParent(this);
		}
	}

	/**
	 * @return the contacts
	 */
	public Set<EmergencyContact> getContacts() {
		return Collections.unmodifiableSet(contacts);
	}
	
	/** Add a contact
	 * 
	 * @param contact
	 */
	public void addContact(EmergencyContact contact){
		this.contacts.add(contact);
		contact.setParent(this);
	}

	/**
	 * @param contacts the contacts to set
	 */
	public void setContacts(Set<EmergencyContact> contacts) {
		this.contacts = contacts;
		for(EmergencyContact contact : contacts){
			contact.setParent(this);
		}
	}
	
	
	
		
}
