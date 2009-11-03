package org.csc480.projectsite.web.data;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.directwebremoting.annotations.DataTransferObject;

@DataTransferObject
@Entity
@Table(name = "AUDITLOG")
public class AuditLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID")
	private Integer id;
	@Basic(optional = false)
	@Column(name = "CLASS")
	private String className;

	@Basic(optional = false)
	@Column(name = "OBJECTID")
	private Integer objectId;
	
	@Basic()
	@Column(name = "CURRENTSTATE")
	private String currentState;

	@Basic()
	@Column(name = "NEWSTATE")
	private String newState;

	@Basic(optional = false)
	@Column(name = "ACTION")
	private String action;

	@Column(name = "CREATED")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	
	@Basic(optional = false)
	@Column(name = "ACTOR")
	private String actor;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassName() {
		return className;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}

	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}

	public Integer getObjectId() {
		return objectId;
	}

	public String getCurrentState() {
		return currentState;
	}

	public void setNewState(String newState) {
		this.newState = newState;
	}

	public String getNewState() {
		return newState;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getAction() {
		return action;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getCreated() {
		return created;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getActor() {
		return actor;
	}

}
