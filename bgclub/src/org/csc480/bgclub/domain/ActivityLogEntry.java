package org.csc480.bgclub.domain;

import java.util.Date;

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;

@DataTransferObject
public class ActivityLogEntry {

	private int activityLogId;
	private int siteId;
	private int memberId;
	private int activityId;
	private Date checkinTm;
	private Date checkoutTm;
	
	/**
	 * @return the activityLogId
	 */
	@RemoteProperty
	public int getActivityLogId() {
		return activityLogId;
	}
	
	/**
	 * @param activityLogId the activityLogId to set
	 */
	@RemoteProperty
	public void setActivityLogId(int activityLogId) {
		this.activityLogId = activityLogId;
	}
	
	/**
	 * @return the siteId
	 */
	@RemoteProperty
	public int getSiteId() {
		return siteId;
	}
	
	/**
	 * @param siteId the siteId to set
	 */
	@RemoteProperty
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}
	
	/**
	 * @return the memberId
	 */
	@RemoteProperty
	public int getMemberId() {
		return memberId;
	}
	
	/**
	 * @param memberId the memberId to set
	 */
	@RemoteProperty
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
	/**
	 * @return the activityId
	 */
	@RemoteProperty
	public int getActivityId() {
		return activityId;
	}
	
	/**
	 * @param activityId the activityId to set
	 */
	@RemoteProperty
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	
	/**
	 * @return the checkinTm
	 */
	@RemoteProperty
	public Date getCheckinTm() {
		return checkinTm;
	}
	
	/**
	 * @param checkinTm the checkinTm to set
	 */
	@RemoteProperty
	public void setCheckinTm(Date checkinTm) {
		this.checkinTm = checkinTm;
	}
	
	/**
	 * @return the checkoutTim
	 */
	@RemoteProperty
	public Date getCheckoutTm() {
		return checkoutTm;
	}
	
	/**
	 * @param checkoutTim the checkoutTm to set
	 */
	@RemoteProperty
	public void setCheckoutTm(Date checkoutTm) {
		this.checkoutTm = checkoutTm;
	}
	
	
	
	
	
	
}
