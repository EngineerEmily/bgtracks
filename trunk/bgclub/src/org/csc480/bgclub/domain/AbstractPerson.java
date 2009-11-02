package org.csc480.bgclub.domain;

import java.io.Serializable;
import java.util.Date;

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;

/** Abstract implementation of the Person interface
 * 
 * @author kenb
 *
 */
@DataTransferObject
public class AbstractPerson implements Person , Serializable  {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2609610432826877167L;

	private String prefix;
	
	private String firstName;
	
	private String lastName;
	
	private String middleName;
	
	private String nickName;
	
	private String suffix;
	
	private Date birthDate;
	
	private Sex sex;
	
	private String ethnicityCd;
	
	private String homePhone;
	
	private String cellPhone;
	
	private String workPhone;
	
	private String email;
	
	private String address1;
	
	private String address2;
	
	private String city;
	
	private String state;
	
	private String zip;

	@RemoteProperty
	public String getPrefix() {
		return prefix;
	}
	@RemoteProperty
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	@RemoteProperty
	public String getFirstName() {
		return firstName;
	}
	
	@RemoteProperty
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@RemoteProperty
	public String getLastName() {
		return lastName;
	}
	
	@RemoteProperty
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@RemoteProperty
	public String getMiddleName() {
		return middleName;
	}
	
	@RemoteProperty
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	@RemoteProperty
	public String getNickName() {
		return nickName;
	}
	@RemoteProperty
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@RemoteProperty
	public String getSuffix() {
		return suffix;
	}

	@RemoteProperty
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	@RemoteProperty
	public Date getBirthDate() {
		return birthDate;
	}
	@RemoteProperty
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	@RemoteProperty
	public Sex getSex() {
		return sex;
	}
	@RemoteProperty
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	@RemoteProperty
	public String getSexString(){
		return (sex == Sex.FEMALE ? "F" : "M");		
	}
	@RemoteProperty
	public void setSexString(String s){
		if(s == null){
			this.sex = null;
		}
		else if(s.toUpperCase().startsWith("F")){
			this.sex = Sex.FEMALE;
		}
		else{
			this.sex = Sex.MALE;
		}
	}
	@RemoteProperty
	public String getEthnicityCd() {
		return ethnicityCd;
	}
	
	@RemoteProperty
	public void setEthnicityCd(String ethnicityCd) {
		this.ethnicityCd = ethnicityCd;
	}
	
	@RemoteProperty
	public String getHomePhone() {
		return homePhone;
	}
	@RemoteProperty
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	@RemoteProperty
	public String getCellPhone() {
		return cellPhone;
	}
	@RemoteProperty
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	@RemoteProperty
	public String getWorkPhone() {
		return workPhone;
	}
	@RemoteProperty
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	@RemoteProperty
	public String getEmail() {
		return email;
	}
	
	@RemoteProperty
	public void setEmail(String email) {
		this.email = email;
	}

	@RemoteProperty
	public String getAddress1() {
		return address1;
	}
	@RemoteProperty
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	@RemoteProperty
	public String getAddress2() {
		return address2;
	}
	@RemoteProperty
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	@RemoteProperty
	public String getCity() {
		return city;
	}
	@RemoteProperty
	public void setCity(String city) {
		this.city = city;
	}
	@RemoteProperty
	public String getState() {
		return state;
	}
	@RemoteProperty
	public void setState(String state) {
		this.state = state;
	}
	@RemoteProperty
	public String getZip() {
		return zip;
	}
	@RemoteProperty
	public void setZip(String zip) {
		this.zip = zip;
	}
	

	

}
