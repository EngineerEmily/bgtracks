package org.nucsc480.projectsite.web.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.csc480.bgclub.domain.Employee;
import org.csc480.bgclub.domain.Member;
import org.csc480.bgclub.service.EmployeeManager;
import org.csc480.projectsite.web.data.BaseMessageResponse;
import org.csc480.projectsite.web.data.GridDataResponseMessage;
import org.csc480.projectsite.web.data.UserDetail;
import org.csc480.projectsite.web.data.UserDetailAuthority;
import org.csc480.projectsite.web.dataaccess.DataAccessPoint;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.stereotype.Service;

@Service
@RemoteProxy
public class EmployeeService {
	protected final Log logger = LogFactory.getLog(getClass());

	private static EmployeeManager cheaterTempEmployeeManager;
	private EmployeeManager employeeManager;

	public EmployeeService() {
		employeeManager = cheaterTempEmployeeManager;
	}

	@RemoteMethod
	public BaseMessageResponse deleteEmployee(int employeeId,
			String successDelegate) {
		BaseMessageResponse response = new BaseMessageResponse();
		response.setSuccessDelegate(successDelegate);
		logger.info("Employee Id: " + employeeId);
		try {
			response.setValid(DataAccessPoint.getUserDetailAccess()
					.deleteUserByUserId(employeeId));
		} catch (Exception ex) {
			response.setMessage(ex.getMessage());
		}

		return response;

	}

	@RemoteMethod
	public BaseMessageResponse addEmployee(UserDetail userDetail,
			String successDelegate) {
		BaseMessageResponse response = new BaseMessageResponse();
		response.setSuccessDelegate(successDelegate);
		try {
			List<UserDetailAuthority> roles = new ArrayList<UserDetailAuthority>(1);
			roles.add(new UserDetailAuthority("ROLE_SUPERVISOR"));
			userDetail.setUserDetailAuthorityCollection(roles);
			response.setValid(DataAccessPoint.getUserDetailAccess()
					.addUserDetail(userDetail));
		} catch (Exception ex) {
			response.setMessage(ex.getMessage());
		}

		return response;
	}

	@RemoteMethod
	public BaseMessageResponse updateEmployee(UserDetail userDetail,
			String successDelegate) {
		BaseMessageResponse response = new BaseMessageResponse();
		response.setSuccessDelegate(successDelegate);
		logger.info("Update Employee was called with a success delegate of " + successDelegate);
		try {
			response.setValid(DataAccessPoint.getUserDetailAccess()
					.updateUserDetail(userDetail));
			logger.info("Update Employee was successful: " + response.getIsValid());
		} catch (Exception ex) {
			response.setMessage(ex.getMessage());
		}

		return response;
	}

	@RemoteMethod
	public List<Employee> findEmployeesByMatch(String input) {
		List<Employee> result = new ArrayList<Employee>();
		result = DataAccessPoint.getEmployeeManagerAccess().findEmployeesById(
				input);
		return result;
	}

	@RemoteMethod
	public UserDetail findEmployeeById(int employeeId) {
		logger.info("Employee Id: " + employeeId);
		return DataAccessPoint.getUserDetailAccess().loadUserByUserId(
				employeeId);

	}

	@RemoteMethod
	public GridDataResponseMessage loadEmployees(int page, int rowsPer,
			String sortColumn, String sortDirection, String search) {
		logger.info("loadUsers was called");
		GridDataResponseMessage message = new GridDataResponseMessage();
		List<UserDetail> rows = DataAccessPoint.getUserDetailAccess()
				.findUsers(search,sortColumn,sortDirection);

		if (rows.size() > 0) {
			message.setTotal((int) Math.ceil((rows.size() * 1.0)
					/ (rowsPer * 1.0)));
		} else {
			message.setTotal(0);
		}
		message.setPage(page);
		if (message.getPage() > message.getTotal()) {
			message.setPage(message.getTotal());
		}

		message.setRecords(rows.size());
		if (rows.size() <= rowsPer) {
			message.setRows(rows);
		} else {
			int lower = (page - 1) * rowsPer;
			int upper = (((page - 1) + 1) * rowsPer);
			upper = upper >= rows.size() ? rows.size() : upper;
			message.setRows(rows.subList(lower, upper));
		}
		logger.info("Ceiling: " + Math.ceil(rows.size() / rowsPer));
		logger.info("Search: " + search);
		logger.info("Page: " + page);
		logger.info("Records: " + message.getRecords());
		logger.info("Total Records Returned: " + message.getRecords());
		return message;

	}
}
