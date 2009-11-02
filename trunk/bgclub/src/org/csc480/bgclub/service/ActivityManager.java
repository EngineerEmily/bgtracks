package org.csc480.bgclub.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.csc480.bgclub.domain.Activity;
import org.csc480.bgclub.domain.ActivityLogEntry;
import org.csc480.bgclub.domain.ValidationIssue;
import org.csc480.bgclub.domain.ValidationIssue.IssueSeverity;
import org.csc480.bgclub.repository.ActivityDao;
import org.csc480.bgclub.repository.ActivityLogDao;
import org.csc480.bgclub.repository.ActivityLogDao.ActivityLogEntryType;
import org.csc480.bgclub.util.DateUtil;
import org.csc480.bgclub.util.ValidationUtil;

/** Activity manager
 * 
 * @author kenb
 *
 */
public class ActivityManager {

	private ActivityDao activityDao;
	private ActivityLogDao activityLogDao;
	
	/** Get an activity
	 * 
	 * @param activityId
	 * @return
	 */
	public Activity getActivity(int activityId){
		return activityDao.get(activityId);
	}
	
	/** Save an activity
	 * 
	 * @param activity
	 */
	public void saveActivity(Activity activity){
		
		validate(activity);
		activityDao.save(activity);
		
	}
	
	/** Get all activities
	 * 
	 * @return
	 */
	public List<Activity> getActivities(){
		return activityDao.getAll();
	}
	
	
	/** Check in a member for an activity
	 * 
	 * @param siteId
	 * @param activityId
	 * @param date
	 * @param memberId
	 */
	public void checkIn(int siteId, int activityId, Date date, int... memberIds ){
		
		List<String> errors = new ArrayList<String>();
		for(Integer memberId : memberIds){
			
			// See if the member is already checked in
			List<ActivityLogEntry> open = activityLogDao.get(Arrays.asList(siteId), Arrays.asList(activityId), Arrays.asList(memberId),  DateUtil.longAgo(), DateUtil.farFuture(), ActivityLogEntryType.OPEN);
			if(open.size() > 0){
				errors.add("The member '" + memberId + "' is already checked in");
			}
			else{
				ActivityLogEntry entry = new ActivityLogEntry();
				entry.setMemberId(memberId);
				entry.setSiteId(siteId);
				entry.setActivityId(activityId);
				entry.setCheckinTm(date);
				activityLogDao.save(entry);				
			}

		}
		
		// TODO Normalize exception handling
		if(errors.size() > 0){
			StringBuilder errorString = new StringBuilder();
			for(String error : errors){
				errorString.append(error).append("\n");
			}
			throw new RuntimeException(errorString.toString());
		}
		
	}
	
	/** Check out a member from an activity
	 * 
	 * @param siteId
	 * @param activityId
	 * @param date
	 * @param memberId
	 */
	public void checkOut(int siteId, int activityId, Date date, int... memberIds ){
		
		List<String> errors = new ArrayList<String>();
		for(Integer memberId : memberIds){
			
			// See if the member is already checked in
			List<ActivityLogEntry> open = activityLogDao.get(Arrays.asList(siteId), Arrays.asList(activityId), Arrays.asList(memberId),  DateUtil.longAgo(), DateUtil.farFuture(), ActivityLogEntryType.OPEN);
			if(open.size() == 1){
				
				ActivityLogEntry entry = open.get(0);
				
				if(date.before(entry.getCheckinTm())){
					errors.add("Attempting to check out before the checkin time");
				}
				else{
					entry.setCheckoutTm(date);
					activityLogDao.save(entry);	
				}
				
			}
			else if(open.size() == 0){
				
				errors.add("The member '" + memberId + "' is not checked into the activity" );
				
			}
			else{
				
				errors.add("The member '" + memberId + "' is checked into the same activity multiple times.  Please contact the system administrator");
			}
			

		}
		
		// TODO Normalize exception handling
		if(errors.size() > 0){
			StringBuilder errorString = new StringBuilder();
			for(String error : errors){
				errorString.append(error).append("\n");
			}
			throw new RuntimeException(errorString.toString());
		}
		
	}
	
	
	/** Validate the activity
	 * 
	 * @param activity
	 */
	public List<ValidationIssue> getValidationIssues(Activity activity){
		
		List<ValidationIssue> issues = new ArrayList<ValidationIssue>();
		
		if(activity.getName() == null || activity.getName().trim().length() == 0){
    		issues.add(new ValidationIssue(activity, IssueSeverity.ERROR, "EmptyActivityName", "Please enter an activity name"));
    	}
		
		// TODO Write more validations!!
		
		
		// Sort the issues, Errors first
		ValidationUtil.sort(issues);
		
		return issues;
    	
	}
	

	/** Validate the activity
	 * 
	 * @param activity
	 */
	private void validate(Activity activity){
		
		List<ValidationIssue> issues = getValidationIssues(activity);
		
		if(issues.size() > 0){
			ValidationUtil.throwValidationException(issues);
		}
		
	}
	
	
	/**
	 * @param activityDao the activityDao to set
	 */
	public void setActivityDao(ActivityDao activityDao) {
		this.activityDao = activityDao;
	}

	/**
	 * @param activityLogDao the activityLogDao to set
	 */
	public void setActivityLogDao(ActivityLogDao activityLogDao) {
		this.activityLogDao = activityLogDao;
	}
	
	
	
	
	
	
}
