package org.csc480.bgclub.domain;

import java.util.Date;

import org.csc480.bgclub.util.hibernate.StringValuedEnum;


/** Person interface
 * 
 * @author kenb
 *
 */
public interface Person {


	public enum Sex implements StringValuedEnum{
		MALE("M"),
		FEMALE("F");

	    /** 
	     * Internal storage of field value
	     */ 
	    private final String code;
	    
	    /** 
	     * Enum constructor for Sex.
	     * @param code Value of sex.
	     */
	    Sex(final String code){
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
	
	public abstract String getPrefix();

	public abstract void setPrefix(String prefix);

	public abstract String getFirstName();

	public abstract void setFirstName(String firstName);

	public abstract String getLastName();

	public abstract void setLastName(String lastName);

	public abstract String getMiddleName();

	public abstract void setMiddleName(String middleName);

	public abstract String getNickName();

	public abstract void setNickName(String nickName);

	public abstract String getSuffix();

	public abstract void setSuffix(String suffix);

	public abstract Date getBirthDate();

	public abstract void setBirthDate(Date birthDate);

	public abstract Sex getSex();

	public abstract void setSex(Sex sex);
	
	public abstract String getEthnicityCd();
	
	public abstract void setEthnicityCd(String ethnicityCd);

	public abstract String getHomePhone();

	public abstract void setHomePhone(String homePhone);

	public abstract String getCellPhone();

	public abstract void setCellPhone(String cellPhone);

	public abstract String getWorkPhone();

	public abstract void setWorkPhone(String workPhone);

	public abstract String getEmail();

	public abstract void setEmail(String email);
	
	public abstract String getAddress1();
	
	public abstract void setAddress1(String address1);
	
	public abstract String getAddress2();
	
	public abstract void setAddress2(String address2);
	
	public abstract String getCity();
	
	public abstract void setCity(String city);
	
	public abstract String getState();
	
	public abstract void setState(String state);
	
	public abstract String getZip();
	
	public abstract void setZip(String zip);
	
}