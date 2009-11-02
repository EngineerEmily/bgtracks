package org.csc480.bgclub.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.csc480.bgclub.domain.Activity;
import org.csc480.bgclub.domain.ActivityLogEntry;
import org.csc480.bgclub.domain.Member;
import org.csc480.bgclub.domain.Site;
import org.csc480.bgclub.repository.ActivityDao;
import org.csc480.bgclub.repository.ActivityLogDao;
import org.csc480.bgclub.repository.MemberDao;
import org.csc480.bgclub.repository.SiteDao;
import org.csc480.bgclub.repository.ActivityLogDao.ActivityLogEntryType;
import org.csc480.bgclub.util.DateUtil;
import org.csc480.bgclub.util.TestContext;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

/** Test for ActivityLogDao
 * 
 * @author kenb
 *
 */
public class ActivityLogDaoTest extends AbstractTransactionalDataSourceSpringContextTests  {

	private ActivityLogDao activityLogDao = null;
	private ActivityDao activityDao = null;
	private MemberDao memberDao = null;
	private SiteDao siteDao = null;
	
	private Member member1 = null;
	private Member member2 = null;
	
	protected String[] getConfigLocations() {
		return new String[]{TestContext.TEST_CONFIG};
	}

	/**
	 * Spring will automatically inject dao on startup
	 * @param activityLogDao
	 */
	public void setActivityLogDao(ActivityLogDao activityLogDao) {
		this.activityLogDao = activityLogDao;
	}
	
	/**
	 * @param activityDao the activityDao to set
	 */
	public void setActivityDao(ActivityDao activityDao) {
		this.activityDao = activityDao;
	}

	/**
	 * @param memberDao the memberDao to set
	 */
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	/**
	 * @param siteDao the siteDao to set
	 */
	public void setSiteDao(SiteDao siteDao) {
		this.siteDao = siteDao;
	}
	
	

	protected void onSetUp() throws Exception {
		super.onSetUp();
		
		//this.setDefaultRollback(false);
		// Add two sites - site A and B
		
		siteDao.save(new Site("Site Junit-A"));
		siteDao.save(new Site("Site Junit-B"));
		
		// Add two activities - General Attendance and 
		activityDao.save(new Activity("Junit General Attendance"));
		activityDao.save(new Activity("Junit Power Hour"));
			
		// Add two members
		member1 = new Member("Bart", "Simpson", new Date());
		member2 = new Member("Lisa", "Simpson", new Date());
		
		memberDao.save(member1);
		memberDao.save(member2);
		
	}
	
	public void testSaveAndGet(){
	
		ActivityLogEntry entry = new ActivityLogEntry();
		
		Site site = siteDao.getByName("Site Junit-A");
		Activity activity = activityDao.getByName("Junit General Attendance");
		
		entry.setSiteId(site.getSiteId());
		entry.setActivityId(activity.getActivityId());
		entry.setCheckinTm(new Date());
		entry.setCheckoutTm(new Date(new Date().getTime() + 3600000));
		entry.setMemberId(member1.getMemberId());
		
		activityLogDao.save(entry);
		
		ActivityLogEntry retrieved = activityLogDao.get(entry.getActivityLogId());
		assertNotNull(retrieved);
		assertEquals(retrieved.getMemberId(), entry.getMemberId());
		assertEquals(retrieved.getSiteId(), entry.getSiteId());
		assertEquals(retrieved.getActivityId(), entry.getActivityId());
		assertEquals(retrieved.getCheckinTm(), entry.getCheckinTm());
		assertEquals(retrieved.getCheckoutTm(), entry.getCheckoutTm());
		
		
	}
	
	
	public void testGetSearch(){
		
		List<Integer> memberIds = new ArrayList<Integer>();
		
		
		ActivityLogEntry entry = new ActivityLogEntry();
		
		Site site = siteDao.getByName("Site Junit-A");
		Activity activity = activityDao.getByName("Junit General Attendance");
		
		entry.setSiteId(site.getSiteId());
		entry.setActivityId(activity.getActivityId());
		entry.setCheckinTm(new Date());
		entry.setCheckoutTm(new Date(new Date().getTime() + 3600000));
		entry.setMemberId(member1.getMemberId());
		
		activityLogDao.save(entry);
		
		
		// Do the search
		memberIds.add(member1.getMemberId());
		memberIds.add(member2.getMemberId());
		
		List<ActivityLogEntry> results = activityLogDao.get(null, null, memberIds, DateUtil.date(1900, 1, 1), DateUtil.date(2999, 1, 1), ActivityLogEntryType.BOTH);
		assertNotNull(results);
		assertTrue("No results returned", results.size() > 0);
		
		// TODO Write more searches and validate the results
		
		
		
	}
	
	public void testDelete(){
		

		ActivityLogEntry entry = new ActivityLogEntry();
		
		Site site = siteDao.getByName("Site Junit-A");
		Activity activity = activityDao.getByName("Junit General Attendance");
		
		entry.setSiteId(site.getSiteId());
		entry.setActivityId(activity.getActivityId());
		entry.setCheckinTm(new Date());
		entry.setCheckoutTm(new Date(new Date().getTime() + 3600000));
		entry.setMemberId(member1.getMemberId());
		
		activityLogDao.save(entry);
		
		int id = entry.getActivityLogId();
		assertNotNull(activityLogDao.get(id));
		
		activityLogDao.delete(entry);
		
		assertNull(activityLogDao.get(id));
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.test.AbstractTransactionalSpringContextTests#onTearDown()
	 */
	@Override
	protected void onTearDown() throws Exception {
		// TODO Auto-generated method stub
		super.onTearDown();
		
		//this.setComplete();
	}
	
	
	
}
