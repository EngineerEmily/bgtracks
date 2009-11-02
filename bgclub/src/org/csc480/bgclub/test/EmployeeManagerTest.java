package org.csc480.bgclub.test;

import java.util.Date;
import java.util.List;

import org.csc480.bgclub.domain.Employee;
import org.csc480.bgclub.domain.Site;
import org.csc480.bgclub.domain.TimeCardEntry;
import org.csc480.bgclub.repository.EmployeeDao;
import org.csc480.bgclub.repository.SiteDao;
import org.csc480.bgclub.repository.TimeCardDao;
import org.csc480.bgclub.service.EmployeeManager;
import org.csc480.bgclub.service.TimeCardException;
import org.csc480.bgclub.util.DateUtil;
import org.csc480.bgclub.util.TestContext;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

/** JUnit tests for EmployeeManager
 * 
 * @author kenb
 *
 */
public class EmployeeManagerTest extends AbstractTransactionalDataSourceSpringContextTests {

	private static final int ONE_HOUR = 3600000;
	private EmployeeManager mgr = null;
	private TimeCardDao timeCardDao = null;
	private EmployeeDao employeeDao = null;
	private SiteDao siteDao;
	
	protected String[] getConfigLocations() {
		return new String[]{TestContext.TEST_CONFIG};
	}

	/**
	 * Spring will automatically inject employeeDao object on startup
	 * @param employeeManager
	 */
	public void setEmployeeManager(EmployeeManager employeeManager) {
		this.mgr = employeeManager;
	}
	
	/** Spring will inject this
	 * 
	 * @param timeCardDao
	 */
	public void setTimeCardDao(TimeCardDao timeCardDao){
		this.timeCardDao =  timeCardDao;
	}
	
	/** Spring will inject this
	 * 
	 * @param employeeDao
	 */
	public void setEmployeeDao(EmployeeDao employeeDao){
		this.employeeDao = employeeDao;
	}

	
	/**
	 * @param siteDao the siteDao to set
	 */
	public void setSiteDao(SiteDao siteDao) {
		this.siteDao = siteDao;
	}

	@Override
	protected void onSetUp() throws Exception {
		super.onSetUp();
		
		Employee bilbo = new Employee();
		bilbo.setFirstName("Bilbo");
		bilbo.setLastName("Baggins");
		
		Employee frodo = new Employee();
		frodo.setFirstName("Frodo");
		frodo.setLastName("Baggins");
		
		employeeDao.save(bilbo);
		employeeDao.save(frodo);
		
	}

	public void testClockInClockOut(){
		
		Site site = new Site("Site");
		siteDao.save(site);
		List<Employee> employees = employeeDao.getByLastName("Baggins", 2);
	
		Employee bilbo = employees.get(0).getFirstName().equals("Bilbo") ? employees.get(0) : employees.get(1);
		
		Date clockInTime = new Date();
		Date clockOutTime = new Date(clockInTime.getTime() + ONE_HOUR);
		
		// Attempt to clock out bilbo without clocking him in, this should throw an exception
		boolean exceptionThrown = false;
		try{
			mgr.clockOut(bilbo.getEmployeeId(), new Date());	
		}
		catch(TimeCardException e){
			// We want this exception
			exceptionThrown = true;
		}
		assertTrue("Expected time card exception was not thrown", exceptionThrown);
		
		// Clock in bilbo
		mgr.clockIn(bilbo.getEmployeeId(), new Date(), site.getSiteId());
				
		// Check to make sure we have an open time card
		TimeCardEntry entry = timeCardDao.getOpenTimeCardEntry(bilbo.getEmployeeId());
		assertNotNull("No open time card", entry);
		
		// Attempt to clock him in again, this should throw an exception
		exceptionThrown = false;
		try{
			mgr.clockIn(bilbo.getEmployeeId(), new Date(), site.getSiteId());	
		}
		catch(TimeCardException e){
			// We want this exception
			exceptionThrown = true;
		}
		assertTrue("Expected time card exception was not thrown", exceptionThrown);
		
		// Clock out bilbo
		mgr.clockOut(bilbo.getEmployeeId(), clockOutTime);
		
		// Attempt to clock him out again, this should throw an exception
		exceptionThrown = false;
		try{
			mgr.clockOut(bilbo.getEmployeeId(), new Date());	
		}
		catch(TimeCardException e){
			// We want this exception
			exceptionThrown = true;
		}
		assertTrue("Expected time card exception was not thrown", exceptionThrown);
		
		// Ensure we have one time card with the appropriate values
		List<TimeCardEntry> entries = timeCardDao.getTimeCardEntries( bilbo.getEmployeeId(),  DateUtil.date(1900, 1, 1), DateUtil.date(2999, 12, 31));
		assertEquals("There should be 1 entry", 1, entries.size());
		
		entry = entries.get(0);
		
		assertEquals("Wrong employee id", entry.getEmployeeId(), bilbo.getEmployeeId());
		assertEquals("Wrong clockin time", entry.getClockinTm().toString(), clockInTime.toString());
		assertEquals("Wrong clockout time", entry.getClockoutTm().toString(), clockOutTime.toString());
		assertEquals("Wrong # minutes", 60, entry.getMinutes());
		
	}
}



