package org.csc480.projectsite.web.data;

import java.io.Serializable;
import java.util.Date;

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
import org.springframework.security.GrantedAuthority;

/**
 * 
 * @author HIvie
 */
@DataTransferObject
@Entity
@Table(name = "USERDETAIL_AUTHORITY")
@NamedQueries( { @NamedQuery(name = "UserDetailAuthority.findAll", query = "SELECT u FROM UserDetailAuthority u") })
public class UserDetailAuthority implements Serializable, GrantedAuthority {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID")
	private Integer id;
	@Basic(optional = false)
	@Column(name = "AUTHORITY")
	private String authority;
	@Column(name = "CREATED")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	@Column(name = "USERDETAIL_ID")
	private int userDetailId;

	// -1 is no action,0 is add, 1 is delete
	@Transient
	private int addDeleteAction = -1;

	public UserDetailAuthority(String authority) {
		this.authority = authority;
	}

	public UserDetailAuthority() {
	}

	public UserDetailAuthority(Integer id) {
		this.id = id;
	}

	public UserDetailAuthority(Integer id, String authority) {
		this.id = id;
		this.authority = authority;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public int getUserDetailId() {
		return userDetailId;
	}

	public void setUserDetailId(int userDetailId) {
		this.userDetailId = userDetailId;
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
		if (!(object instanceof UserDetailAuthority)) {
			return false;
		}
		UserDetailAuthority other = (UserDetailAuthority) object;
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

	public int compareTo(Object arg0) {
		return 1;
	}

	public void setAddDeleteAction(int addDeleteAction) {
		this.addDeleteAction = addDeleteAction;
	}

	public int getAddDeleteAction() {
		return addDeleteAction;
	}

}
