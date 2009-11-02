package org.csc480.bgclub.repository;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.csc480.bgclub.domain.Employee;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/** Hibernate implementation of EmployeeDao
 * 
 * @author kenb
 *
 */
public class EmployeeDaoHibernate extends HibernateDaoSupport implements EmployeeDao {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	
	@Override
	public void delete(int employeeId) {
		logger.debug("Deleting employee with id '" + employeeId + "'");
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		this.getHibernateTemplate().delete(employee);
				
	}

	@Override
	public void save(Employee employee) {		
		logger.debug("Saving employee '" + employee.getLastName() + ", " + employee.getFirstName() + "'");
		this.getHibernateTemplate().saveOrUpdate(employee);
	}

	@Override
	public void save(List<Employee> employees) {
		logger.debug("Saving a list of employees");
		this.getHibernateTemplate().saveOrUpdate(employees);
		
	}

	@Override
	public Employee get(int employeeId) {
		logger.debug("Getting employee with id '" + employeeId + "'");
		return (Employee) this.getHibernateTemplate().get(Employee.class, employeeId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllById(String employeeId) {
		logger.debug("Getting employee with id '" + employeeId + "'");
		return (List<Employee>) this.getHibernateTemplate().findByNamedParam("from Employee e where e.employeeId is not null and cast(e.employeeId,string) like :employeeId", "employeeId", '%' + employeeId + '%');
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getByLastName(String lastName, int maxResults) {
		logger.debug("Getting employees with last name of '" + lastName + "'");
		return (List<Employee>) this.getHibernateTemplate().find("from Employee employee where employee.lastName = ? order by employee.firstName ASC", lastName);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAll(int maxResults) {
		logger.debug("Getting all employees");
		return (List<Employee>) getHibernateTemplate().find("from Employee");
	}
	
	

}
