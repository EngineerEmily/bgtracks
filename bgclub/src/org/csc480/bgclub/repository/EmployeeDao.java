package org.csc480.bgclub.repository;

import java.util.List;

import org.csc480.bgclub.domain.Employee;


/** Employee data access object
 * 
 * @author kenb
 *
 */
public interface EmployeeDao {

	/** Select an employee
	 * 
	 * @param employeeId
	 * @return
	 */
	public Employee get(int employeeId);
	
	/** Get Employee By Id Match
	 * @param employeeId
	 * @return
	 */
	public List<Employee> getAllById(String employeeId);
	
	/** Find employees
	 * 
	 * @param lastName
	 * @param maxResults
	 * 
	 * @return
	 */
	public List<Employee> getByLastName(String lastName, int maxResults);
	
	/** Find employees
	 * 
	 * @param maxResults
	 * 
	 * @return
	 */
	public List<Employee> getAll(int maxResults);
		
	/** Save an employee
	 * 
	 * @param employee
	 */
	public void save(Employee employee);
	
	/** Save employees
	 * 
	 * @param employees
	 */
	public void save(List<Employee> employees);
	
	/** Delete an employee
	 * 
	 * @param employeeId
	 */
	public void delete(int employeeId);
	
	
}
