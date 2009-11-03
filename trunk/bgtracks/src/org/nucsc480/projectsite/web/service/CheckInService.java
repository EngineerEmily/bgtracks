package org.nucsc480.projectsite.web.service;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.csc480.projectsite.web.data.BaseMessageResponse;
import org.csc480.projectsite.web.dataaccess.DataAccessPoint;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.stereotype.Service;

@Service
@RemoteProxy
public class CheckInService {
	protected final Log logger = LogFactory.getLog(getClass());
	
	/** Constructor
	 * 
	 */
	public CheckInService(){
	}

	/**
	 * This function will add a check in time for a given user
	 * 
	 * @param userID
	 * @return true if the check in was successful and false otherwise
	 */
	@RemoteMethod
	public BaseMessageResponse checkInUser(int userID, int siteID,String successDelegate) {
		BaseMessageResponse response = new BaseMessageResponse();
		response.setSuccessDelegate(successDelegate);
		logger.info("Checking in user: " + userID);
		if (userID > 0) {
			try {
				DataAccessPoint.getEmployeeManagerAccess().clockIn(userID, new Date(), siteID);
				response.setData(DataAccessPoint.getEmployeeManagerAccess().getEmployee(userID));
				response.setValid(true);
			} catch (Exception ex) {
				response.setMessage(ex.getMessage());
				logger.error(ex.getMessage());
			}
		}
		return response;
	}
	/**
	 * This function will add a check out time for a given user
	 * 
	 * @param userID
	 * @return true if the check out was successful and false otherwise
	 */
	@RemoteMethod
	public BaseMessageResponse checkOutUser(int userID,String successDelegate) {
		BaseMessageResponse response = new BaseMessageResponse();
		response.setSuccessDelegate(successDelegate);
		logger.info("Checking out user: " + userID);
		if (userID > 0) {
			try {
				DataAccessPoint.getEmployeeManagerAccess().clockOut(userID, new Date());
				response.setValid(true);
				response.setData(DataAccessPoint.getEmployeeManagerAccess().getEmployee(userID));
			} catch (Exception ex) {
				response.setMessage(ex.getMessage());
				logger.error(ex.getMessage());
			}
		}
		return response;
	}
}
