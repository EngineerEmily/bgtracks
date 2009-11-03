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
public class ActivityCheckinService {
	protected final Log logger = LogFactory.getLog(getClass());

	@RemoteMethod
	public BaseMessageResponse checkIn(int siteId, int activityId, int memberId,String successDelegate) {
		BaseMessageResponse response = new BaseMessageResponse();
		response.setSuccessDelegate(successDelegate);
		Date date = new Date();
		logger.info("Checking in member: " + memberId);
		try {
			DataAccessPoint.getActivityManagerAccess().checkIn(siteId,
					activityId, date, memberId);
			response.setData(DataAccessPoint.getMemberManagerAccess().getMember(memberId));
			response.setValid(true);
		} catch (Exception ex) {
			response.setMessage(ex.getMessage());
			logger.error(ex.getMessage());
		}
		return response;

	}

	@RemoteMethod
	public BaseMessageResponse checkInExact(int siteId, int activityId, Date date, int memberId,String successDelegate) {
		BaseMessageResponse response = new BaseMessageResponse();
		response.setSuccessDelegate(successDelegate);

		logger.info("Checking in member: " + memberId);
		try {
			DataAccessPoint.getActivityManagerAccess().checkIn(siteId,
					activityId, date, memberId);
			response.setData(DataAccessPoint.getMemberManagerAccess().getMember(memberId));
			response.setValid(true);
		} catch (Exception ex) {
			response.setMessage(ex.getMessage());
			logger.error(ex.getMessage());
		}
		return response;

	}

//	@RemoteMethod
//	public BaseMessageResponse checkInGroup(int siteId, int activityId,
//			int[] memberIds,String successDelegate) {
//		BaseMessageResponse response = new BaseMessageResponse();
//		response.setSuccessDelegate(successDelegate);
//
//		Date date = new Date();
//		logger.info("Checking in members");
//		try {
//			DataAccessPoint.getActivityManagerAccess().checkIn(siteId,
//					activityId, date, memberIds);
//			response.setValid(true);
//		} catch (Exception ex) {
//			response.setMessage(ex.getMessage());
//			logger.error(ex.getMessage());
//		}
//		return response;
//
//	}

//	@RemoteMethod
//	public BaseMessageResponse checkInGroupExact(int siteId, int activityId,
//			Date date, int[] memberIds,String successDelegate) {
//		BaseMessageResponse response = new BaseMessageResponse();
//		response.setSuccessDelegate(successDelegate);
//
//		logger.info("Checking in members");
//		try {
//			DataAccessPoint.getActivityManagerAccess().checkIn(siteId,
//					activityId, date, memberIds);
//			response.setValid(true);
//		} catch (Exception ex) {
//			response.setMessage(ex.getMessage());
//			logger.error(ex.getMessage());
//		}
//		return response;
//	}

	@RemoteMethod
	public BaseMessageResponse checkOut(int siteId, int activityId, int memberId,String successDelegate) {
		BaseMessageResponse response = new BaseMessageResponse();
		response.setSuccessDelegate(successDelegate);
		Date date = new Date();

		logger.info("Checking out member: " + memberId);
		try {
			DataAccessPoint.getActivityManagerAccess().checkOut(siteId,
					activityId, date, memberId);
			response.setData(DataAccessPoint.getMemberManagerAccess().getMember(memberId));
			response.setValid(true);
		} catch (Exception ex) {
			response.setMessage(ex.getMessage());
			logger.error(ex.getMessage());
		}
		return response;
	}

	@RemoteMethod
	public BaseMessageResponse checkOutExact(int siteId, int activityId,
			Date date, int memberId,String successDelegate) {

		BaseMessageResponse response = new BaseMessageResponse();
		response.setSuccessDelegate(successDelegate);

		logger.info("Checking out member: " + memberId);
		try {
			DataAccessPoint.getActivityManagerAccess().checkOut(siteId,
					activityId, date, memberId);
			response.setData(DataAccessPoint.getMemberManagerAccess().getMember(memberId));

			response.setValid(true);
		} catch (Exception ex) {
			response.setMessage(ex.getMessage());
			logger.error(ex.getMessage());
		}
		return response;

	}

//	@RemoteMethod
//	public BaseMessageResponse checkOutGroup(int siteId, int activityId,
//			int[] memberIds,String successDelegate) {
//		BaseMessageResponse response = new BaseMessageResponse();
//		response.setSuccessDelegate(successDelegate);
//
//		Date date = new Date();
//		logger.info("Checking out group");
//		try {
//			DataAccessPoint.getActivityManagerAccess().checkOut(siteId,
//					activityId, date, memberIds);
//			response.setValid(true);
//		} catch (Exception ex) {
//			response.setMessage(ex.getMessage());
//			logger.error(ex.getMessage());
//		}
//		return response;
//
//	}
//
//	@RemoteMethod
//	public BaseMessageResponse checkOutGroupExact(int siteId, int activityId,
//			Date date, int[] memberIds,String successDelegate) {
//
//		BaseMessageResponse response = new BaseMessageResponse();
//		response.setSuccessDelegate(successDelegate);
//
//		logger.info("Checking out group");
//		try {
//			DataAccessPoint.getActivityManagerAccess().checkOut(siteId,
//					activityId, date, memberIds);
//			response.setValid(true);
//		} catch (Exception ex) {
//			response.setMessage(ex.getMessage());
//			logger.error(ex.getMessage());
//		}
//		return response;
//
//	}

}
