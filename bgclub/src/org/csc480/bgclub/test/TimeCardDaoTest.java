package org.csc480.bgclub.test;

import java.util.Date;

import org.csc480.bgclub.domain.Employee;
import org.csc480.bgclub.domain.Site;
import org.csc480.bgclub.domain.TimeCardEntry;
import org.csc480.bgclub.repository.EmployeeDao;
import org.csc480.bgclub.repository.SiteDao;
import org.csc480.bgclub.repository.TimeCardDao;
import org.csc480.bgclub.util.TestContext;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;


/** Junit test for Time Card Dao
 * 
 * @author kenb
 *
 */
public class TimeCardDaoTest extends AbstractTransactionalDataSourceSpringContextTests  {

	private TimeCardDao timeCardDao;
	private EmployeeDao employeeDao;
	private SiteDao siteDao;

	protected String[] getConfigLocations() {
		return new String[]{TestContext.TEST_CONFIG};
	}


	/** Spring will inject this attribute
	 * @param timeCardDao the timeCardDao to set
	 */
	public void setTimeCardDao(TimeCardDao timeCardDao) {
		this.timeCardDao = timeCardDao;
	}
	
	
	/** Spring will inject this
	 * 
	 * @param employeeDao
	 */
	public void setEmployeeDao(EmployeeDao employeeDao){
		this.employeeDao = employeeDao;
	}

	/** Spring will inject this
	 * 
	 * @param siteDao
	 */
	public void setSiteDao(SiteDao siteDao){
		this.siteDao = siteDao;
	}
	
	
	/** Test save and get
	 * 
	 */
	public void testSaveAndGet(){
		
		Site site = new Site("Site A");
		siteDao.save(site);
		
		Date clockIn = new Date();
		Date clockOut = new Date(clockIn.getTime() + 60000);
				
		Employee emp = new Employee();
		emp.setLastName("Junit");
		employeeDao.save(emp);
		
		
		TimeCardEntry entry = new TimeCardEntry();
		entry.setEmployeeId(emp.getEmployeeId());
		entry.setClockinTm(clockIn);
		entry.setClockoutTm(clockOut);
		entry.setMinutes(60);
		entry.setSiteId(site.getSiteId());
		
		timeCardDao.save(entry);
		
		assertTrue("Entry id not set", entry.getTimeCardId() > 0);
		int originalTimeCardId = entry.getTimeCardId();
		
		TimeCardEntry fetchedEntry = timeCardDao.get(originalTimeCardId);
		assertNotNull("Entry not fetched", fetchedEntry);
		assertEquals("Entry id", originalTimeCardId, originalTimeCardId);
		assertEquals("Entry clockin wrong", clockIn, fetchedEntry.getClockinTm());
		assertEquals("Entry clockout wrong", clockOut, fetchedEntry.getClockoutTm());
		assertEquals("Entry minutes", 60, fetchedEntry.getMinutes());
		assertEquals("Entry site wrong", site.getSiteId(), fetchedEntry.getSiteId());
		
		assertEquals("Employee id wrong", fetchedEntry.getEmployeeId(), entry.getEmployeeId());
		
		
	}
	
	// TODO Write tests for all the other functions

	
	
	
}
