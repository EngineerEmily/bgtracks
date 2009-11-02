package org.csc480.bgclub.test;

import java.util.Date;

import org.csc480.bgclub.domain.Activity;
import org.csc480.bgclub.domain.Member;
import org.csc480.bgclub.domain.Site;
import org.csc480.bgclub.service.ActivityManager;
import org.csc480.bgclub.service.MemberManager;
import org.csc480.bgclub.service.SiteManager;
import org.csc480.bgclub.util.DateUtil;
import org.csc480.bgclub.util.TestContext;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

/** Junit test for Activity manager
 * 
 * @author kenb
 *
 */
public class ActivityManagerTest extends AbstractTransactionalDataSourceSpringContextTests {

	private ActivityManager activityManager = null;
	private MemberManager memberManager = null;
	private SiteManager siteManager = null;
	
	protected String[] getConfigLocations() {
		return new String[]{TestContext.TEST_CONFIG};
	}
	
	
	public void test(){

		Activity activity = new Activity("Junit General Attendance");
		activityManager.saveActivity(activity);
		assertTrue(activity.getActivityId() > 0);
		
		Member bart = new Member("Bart", "Simpson", new Date());
		memberManager.saveMember(bart);
	
		Member lisa = new Member("Lisa", "Simpson", new Date());
		memberManager.saveMember(lisa);
		
		Site site = new Site("Site A");
		siteManager.saveSite(site);
		
		activityManager.checkIn(site.getSiteId(), activity.getActivityId(), new Date(), bart.getMemberId(), lisa.getMemberId());
		
		boolean exception = false;
		try{
			activityManager.checkIn(site.getSiteId(), activity.getActivityId(), new Date(), bart.getMemberId(), lisa.getMemberId());	
		}
		catch(Exception e){
			exception = true;
		}
		assertTrue("Exception not thrown for multiple checkins", exception);
		
		
		exception = false;
		try{
			activityManager.checkOut(site.getSiteId(), activity.getActivityId(), DateUtil.longAgo(), bart.getMemberId(), lisa.getMemberId());	
		}
		catch(Exception e){
			exception = true;
		}
		assertTrue("Exception not thrown for invalid checkout time", exception);
		
		
		activityManager.checkOut(site.getSiteId(), activity.getActivityId(), new Date(), bart.getMemberId(), lisa.getMemberId());
		
		exception = false;
		try{
			activityManager.checkOut(site.getSiteId(), activity.getActivityId(), new Date(), bart.getMemberId(), lisa.getMemberId());	
		}
		catch(Exception e){
			exception = true;
		}
		assertTrue("Exception not thrown for multiple checkouts", exception);
		
	}
	
	/**
	 * @param siteManager the siteManager to set
	 */
	public void setSiteManager(SiteManager siteManager) {
		this.siteManager = siteManager;
	}


	/**
	 * @param activityManager the activityManager to set
	 */
	public void setActivityManager(ActivityManager activityManager) {
		this.activityManager = activityManager;
	}


	/**
	 * @param memberManager the memberManager to set
	 */
	public void setMemberManager(MemberManager memberManager) {
		this.memberManager = memberManager;
	}
	
	
	
}
