package org.csc480.bgclub.test;

import java.util.List;

import org.csc480.bgclub.domain.Guardian;
import org.csc480.bgclub.repository.GuardianDao;
import org.csc480.bgclub.util.TestContext;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

/** Guardian DAO test
 * 
 * @author kenb
 *
 */
public class GuardianDaoTest extends AbstractTransactionalDataSourceSpringContextTests {

	private GuardianDao guardianDao = null;

	protected String[] getConfigLocations() {
		return new String[]{TestContext.TEST_CONFIG};
	}

	/**
	 * Spring will automatically inject dao object on startup
	 * @param employeeDao
	 */
	public void setGuardianDao(GuardianDao guardianDao) {
		this.guardianDao = guardianDao;
	}

	
	public void test(){
		
		Guardian poppins = new Guardian();
		poppins.setFirstName("Mary");
		poppins.setLastName("Poppins");
		poppins.setPrefix("Ms.");
		poppins.setAddress1("17 Cherry Tree Lane");
		poppins.setCity("London");
		poppins.setZip("W1U 3LG");
		poppins.setHomePhone("44 08457 300 700");
		poppins.setCellPhone("44 08457 300 701");
		poppins.setWorkPhone("44 08457 300 702");
		poppins.setEmail("m.poppins@supercalifragilisticexpialidocious.com");
		poppins.setEmployer("Banks Family");
		guardianDao.save(poppins);
		assertTrue(poppins.getGuardianId() > 0);
		
		
		Guardian warbucks = new Guardian();
		warbucks.setFirstName("Oliver");
		warbucks.setLastName("Warbucks");
		warbucks.setPrefix("Mr.");
		warbucks.setSuffix("Zillionaire");
		warbucks.setAddress1("350 5th Ave");
		warbucks.setCity("New York");
		warbucks.setState("NY");
		warbucks.setCellPhone("212-736-3100");
		warbucks.setEmployer("Self Employed");
		guardianDao.save(warbucks);
		assertTrue(warbucks.getGuardianId() > 0);
		
		
		Guardian guardian = guardianDao.get(poppins.getGuardianId());
		assertEquals("Mary", guardian.getFirstName());
		assertEquals("Poppins", guardian.getLastName());
		assertEquals("Ms.", guardian.getPrefix());
		assertEquals("17 Cherry Tree Lane", guardian.getAddress1());
		assertEquals("London", guardian.getCity());
		assertEquals("W1U 3LG", guardian.getZip());
		assertEquals("Banks Family", guardian.getEmployer());
		assertEquals("m.poppins@supercalifragilisticexpialidocious.com", guardian.getEmail());
		assertEquals("44 08457 300 700", guardian.getHomePhone());
		assertEquals("44 08457 300 701", guardian.getCellPhone());
		assertEquals("44 08457 300 702", guardian.getWorkPhone());
		
		guardian = guardianDao.get(warbucks.getGuardianId());
		assertEquals("Zillionaire", guardian.getSuffix());
		assertEquals("NY", guardian.getState());
		
		List<Guardian> guardians = guardianDao.get(poppins.getGuardianId(), warbucks.getGuardianId());
		assertEquals(2, guardians.size());
		
		int poppinsId = poppins.getGuardianId();
		guardianDao.delete(poppins);
		
		assertNull(guardianDao.get(poppinsId));
		
		
		
		
		
	}
}
