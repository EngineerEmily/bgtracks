package org.csc480.projectsite.web.dataaccess;

import org.csc480.bgclub.service.ActivityManager;
import org.csc480.bgclub.service.EmployeeManager;
import org.csc480.bgclub.service.GuardianManager;
import org.csc480.bgclub.service.MemberManager;
import org.csc480.bgclub.service.SiteManager;

public class DataAccessPoint {
	private static UserDetailAccess userDetailAccess;
	private static EmployeeManager employeeManagerAccess;
	private static MemberManager memberManagerAccess;
	private static ActivityManager activityManagerAccess;
	private static SiteManager siteManagerAccess;
	private static GuardianManager guardianManagerAccess;
	
	/**
	 * Used by the IOC to to set the data
	 * 
	 * @param userDetailAccess
	 *            DataAccess Layer object
	 */
	public void setUserDetailAccess(UserDetailAccess userDetailAccess) {
		DataAccessPoint.userDetailAccess = userDetailAccess;
	}

	/**
	 * @return UserDetailAccess data access object
	 */
	public static UserDetailAccess getUserDetailAccess() {
		return userDetailAccess;
	}

	public void setEmployeeManagerAccess(EmployeeManager employeeManagerAccess) {
		DataAccessPoint.employeeManagerAccess = employeeManagerAccess;
	}

	public static EmployeeManager getEmployeeManagerAccess() {
		return employeeManagerAccess;
	}

	public void setMemberManagerAccess(MemberManager memberManagerAccess) {
		DataAccessPoint.memberManagerAccess = memberManagerAccess;
	}

	public static MemberManager getMemberManagerAccess() {
		return memberManagerAccess;
	}

	/**
	 * @return the activityManagerAccess
	 */
	public static ActivityManager getActivityManagerAccess() {
		return activityManagerAccess;
	}

	/**
	 * @param activityManagerAccess the activityManagerAccess to set
	 */
	public void setActivityManagerAccess(
			ActivityManager activityManagerAccess) {
		DataAccessPoint.activityManagerAccess = activityManagerAccess;
	}

	/**
	 * @return the siteManagerAccess
	 */
	public static SiteManager getSiteManagerAccess() {
		return siteManagerAccess;
	}

	/**
	 * @param siteManagerAccess the siteManagerAccess to set
	 */
	public void setSiteManagerAccess(SiteManager siteManagerAccess) {
		DataAccessPoint.siteManagerAccess = siteManagerAccess;
	}

	/**
	 * @return the guardianManagerAccess
	 */
	public static GuardianManager getGuardianManagerAccess() {
		return guardianManagerAccess;
	}

	/**
	 * @param guardianManagerAccess the guardianManagerAccess to set
	 */
	public void setGuardianManagerAccess(
			GuardianManager guardianManagerAccess) {
		DataAccessPoint.guardianManagerAccess = guardianManagerAccess;
	}
	
	
	
}
