package org.csc480.bgclub.test;

import java.util.GregorianCalendar;
import java.util.List;

import org.csc480.bgclub.domain.Employee;
import org.csc480.bgclub.domain.Person.Sex;
import org.csc480.bgclub.repository.EmployeeDao;
import org.csc480.bgclub.util.TestContext;
import org.junit.Test;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

/** EmployeeDaoHibernate test
 * 
 * @author kenb
 *
 */
public class EmployeeDaoTest extends AbstractTransactionalDataSourceSpringContextTests  {

	private EmployeeDao employeeDao = null;

	protected String[] getConfigLocations() {
		return new String[]{TestContext.TEST_CONFIG};
	}

	/**
	 * Spring will automatically inject UserDao object on startup
	 * @param employeeDao
	 */
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Test
	public void test(){

		
		Employee employee = new Employee();
		employee.setFirstName("John");
		employee.setLastName("Adams");
		employee.setBirthDate(new GregorianCalendar(1735, 9, 30).getTime());
		employee.setAddress1("133 Franklin St");
		employee.setCity("Quincy");
		employee.setState("MA");
		employee.setZip("02169-7823");
		employee.setHomePhone("617-773-1177");
		employee.setSex(Sex.MALE);
		employeeDao.save(employee);		

		assertTrue("Employee ID not set", employee.getEmployeeId() > 0);
		assertNotNull("Employee not found", employeeDao.get(employee.getEmployeeId()));
		assertEquals("Employee sex wrong", Sex.MALE, employeeDao.get(employee.getEmployeeId()).getSex());
		
		employee = new Employee();
		employee.setFirstName("Thomas");
		employee.setLastName("Jefferson");
		employeeDao.save(employee);

		employee = new Employee();
		employee.setFirstName("Abigail");
		employee.setLastName("Adams");
		employee.setSex(Sex.FEMALE); 
		employeeDao.save(employee);
		assertEquals("Employee sex wrong", Sex.FEMALE, employeeDao.get(employee.getEmployeeId()).getSex());
		
		List<Employee> employees = employeeDao.getByLastName("Adams", 10);
		assertEquals("Wrong number of employees returned", 2, employees.size());	
		for(Employee emp : employees){
			assertEquals("Wrong employee fetched", "Adams", emp.getLastName());
		}
		
		
		employees = employeeDao.getAll(10);
		assertEquals("Wrong number of employees returned", 3, employees.size());
	
	}
}
