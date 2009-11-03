package org.csc480.projectsite.web.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.userdetails.UserDetails;

@DataTransferObject
@Entity
@Table(name = "USERDETAIL")
@NamedQueries( { @NamedQuery(name = "UserDetail.findAll", query = "SELECT u FROM UserDetail u") })
public class UserDetail implements Serializable, UserDetails, IAuditable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID")
	@RemoteProperty
	private Integer id;
	@Basic(optional = false)
	@Column(name = "USERNAME")
	@RemoteProperty
	private String username;
	@Column(name = "FIRSTNAME")
	@RemoteProperty
	private String firstName;
	@Column(name = "LASTNAME")
	@RemoteProperty
	private String lastName;
	@Column(name = "ENABLED", nullable = false)
	@RemoteProperty
	private boolean enabled;
	@Column(name = "PASSWORD")
	@RemoteProperty
	private String password;
	@Column(name = "EMAIL")
	@RemoteProperty
	private String email;
	@Column(name = "CREATED")
	@Temporal(TemporalType.TIMESTAMP)
	@RemoteProperty
	private Date created;
	@Column(name = "REGION")
	@RemoteProperty
	private String region;
	@Column(name = "EMPLOYEE_ID")
	@RemoteProperty
	private Integer employeeId;

	@Transient
	private List<UserDetailAuthority> userDetailAuthorityCollection = new ArrayList<UserDetailAuthority>();

	public UserDetail() {
	}

	public UserDetail(Integer id) {
		this.id = id;
	}

	public UserDetail(Integer id, String username) {
		this.id = id;
		this.username = username;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	/**
	 * @return the employeeId
	 */
	public Integer getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public List<UserDetailAuthority> getUserDetailAuthorityCollection() {
		return userDetailAuthorityCollection;
	}

	public void setUserDetailAuthorityCollection(
			List<UserDetailAuthority> userDetailAuthorityCollection) {
		this.userDetailAuthorityCollection = userDetailAuthorityCollection;
	}

	public GrantedAuthority[] getAuthorities() {
		return (GrantedAuthority[]) getUserDetailAuthorityCollection()
				.toArray(
						new GrantedAuthority[getUserDetailAuthorityCollection()
								.size()]);
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRegion() {
		return region;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof UserDetail)) {
			return false;
		}
		UserDetail other = (UserDetail) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return id.toString();
	}

	@Override
	public int getObjectId() {
		// TODO Auto-generated method stub
		return this.getId();
	}
}
