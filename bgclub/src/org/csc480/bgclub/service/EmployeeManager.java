package org.csc480.bgclub.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.csc480.bgclub.domain.Employee;
import org.csc480.bgclub.domain.TimeCardEntry;
import org.csc480.bgclub.domain.ValidationIssue;
import org.csc480.bgclub.domain.ValidationIssue.IssueSeverity;
import org.csc480.bgclub.repository.EmployeeDao;
import org.csc480.bgclub.repository.TimeCardDao;
import org.csc480.bgclub.util.DateUtil;
import org.csc480.bgclub.util.ValidationUtil;

/** Employee manager implementation
 * 
 * @author kenb
 *
 */
public class EmployeeManager  {

	private EmployeeDao employeeDao;
	private TimeCardDao timeCardDao;
    protected final Log logger = LogFactory.getLog(getClass());

    

    /** Get an employee
     * 
     * @param employeeId
     * @return
     */
    public Employee getEmployee(int employeeId){
    	return employeeDao.get(employeeId);
    }
    
    
    /** Get all employees
     * 
     * @return
     */
    public List<Employee> getEmployees(){
    	return employeeDao.getAll(0);
    }
    

    /** Save an employee.  
     * 
     * @param employee
     * @throws ValidationException If there are validation exceptions
     * 
     */
    public void saveEmployee(Employee employee){
    	
    	// First, validate the employee.  If this validation fails, a validation exception is throws.  The exception contains the issues
    	validate(employee);
    	
    	employeeDao.save(employee);
    }
    
    /** Clock in an employee
     * 
     * @param employeeId
     * @param time
     * @param siteId
     */
	public void clockIn(int employeeId, Date time, int siteId) {
		TimeCardEntry entry = timeCardDao.getOpenTimeCardEntry(employeeId);
		
		// Ensure there's no open time card
		if(entry != null){
			throw new TimeCardException("There is an open time card already.  Please clock out first");
		}
		
		// Set the time card values
		entry = new TimeCardEntry();
		entry.setClockinTm(time);
		entry.setEmployeeId(employeeId);
		entry.setSiteId(siteId);
		
		// Save the time card
		timeCardDao.save(entry);
				
		
	}
	


	/** Clock out an employee
	 * 
	 * @param employeeId
	 * @param time
	 */
	public void clockOut(int employeeId, Date time) {
		
		// Ensure there's an open time card
		TimeCardEntry entry = timeCardDao.getOpenTimeCardEntry(employeeId);
		
		// Ensure there's no open time card
		if(entry == null){
			throw new TimeCardException("There is no open time card.  Please clock in first");
		}
		
		// Set the clock out time
		entry.setClockoutTm(time);
		
		// Compute the minutes
		entry.setMinutes(DateUtil.minutes(entry.getClockinTm(), time));
		
		// Save the time card
		timeCardDao.save(entry);
		
	}
	
	
	/** Validate the employee
	 * 
	 * @param employee
	 */
	public List<ValidationIssue> getValidationIssues(Employee employee){
		
		List<ValidationIssue> issues = new ArrayList<ValidationIssue>();
		
		if(employee.getTerminationDt() != null && employee.getStartDt().after(employee.getTerminationDt())){
    		issues.add(new ValidationIssue(employee, IssueSeverity.ERROR, "TerminationDtBeforeStartDt", "Termination date cannot be prior to start date"));
    	}
		
		// TODO Write more validations!!
		
		
		// Sort the issues, Errors first
		ValidationUtil.sort(issues);
		
		return issues;
    	
	}
	
	/** Validate the employee
	 * 
	 * @param employee
	 */
	private void validate(Employee employee){
		
		List<ValidationIssue> issues = getValidationIssues(employee);
		
		if(issues.size() > 0){
			ValidationUtil.throwValidationException(issues);
		}
		
		
	}
	

	/** Spring will inject the employee dao
	 * 
	 * @param employeeDao
	 */
	public void setEmployeeDao(EmployeeDao employeeDao){
		this.employeeDao = employeeDao;
	}
	
	/** Spring will inject the time card dao
	 * 
	 * @param timeCardDao the timeCardDao to set
	 */
	public void setTimeCardDao(TimeCardDao timeCardDao) {
		this.timeCardDao = timeCardDao;
	}
	public List<Employee> findEmployeesById(String input)
	{
		List<Employee> result = new ArrayList<Employee>(); 
		result = employeeDao.getAllById(input);
		return result;
	
	}
	
}
