package org.csc480.bgclub.repository;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.csc480.bgclub.domain.Employee;


/** In memory employee DAO
 * 
 * @author kenb
 *
 */
public class EmployeeDaoMemory implements EmployeeDao {

	protected final Log logger = LogFactory.getLog(getClass());

	private static Map<Integer, Employee> employees = new Hashtable<Integer, Employee>();
	private static int nextNum = 1000;
	private static Object lockObject = new Object();
	
	
	@Override
	public void delete(int employeeId) {
		logger.debug("Deleting employee with id '" + employeeId + "'");
		employees.remove(employeeId);		
	}

	@Override
	public void save(Employee employee) {
		logger.debug("Saving employee '" + employee.getLastName() + ", " + employee.getFirstName() + "'");
		
		if(employee.getEmployeeId() == 0){
			synchronized(lockObject){
				employee.setEmployeeId(nextNum++);
			}	
		}
		
		employees.put(employee.getEmployeeId(), employee);
	}

	@Override
	public void save(List<Employee> employees) {
		logger.debug("Saving a list of employees");
		for(Employee employee : employees){
			save(employee);
		}
	}


	@Override
	public Employee get(int employeeId) {
		logger.debug("Getting employee with id '" + employeeId + "'");
		return employees.get(employeeId);
	}

	@Override
	public List<Employee> getByLastName(String lastName, int maxResults) {
		logger.debug("Getting employees with last name of '" + lastName + "'");
		
		List<Employee> results = new ArrayList<Employee>();
		for(Employee emp : employees.values()){
			if(emp.getLastName().equalsIgnoreCase(lastName)){
				results.add(emp);
				
				// Do not exceed max results
				if(results.size() == maxResults && maxResults > 0){
					break;
				}
			}
		}
		return results;
	}
	
	@Override
	public List<Employee> getAllById(String employeeId) {
		logger.debug("Getting employee with id '" + employeeId + "'");
		return null;//(List<Employee>) this.getHibernateTemplate().findByNamedParam("from employee e where e.employeeId like %employeeId%", "employeeId", employeeId);
	}

	@Override
	public List<Employee> getAll(int maxResults) {
		logger.debug("Getting all employees");

		// Return a copy of the employees
		return new ArrayList<Employee>(employees.values());
	}
	
}
