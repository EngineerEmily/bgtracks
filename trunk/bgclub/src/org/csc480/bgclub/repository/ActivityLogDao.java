package org.csc480.bgclub.repository;

import java.util.Date;
import java.util.List;

import org.csc480.bgclub.domain.ActivityLogEntry;

/** DAO for Activity Log entries
 * 
 * @author kenb
 *
 */
public interface ActivityLogDao {

	public enum ActivityLogEntryType{
		OPEN,
		CLOSED,
		BOTH
	}
	
	/** Get
	 * 
	 * @param activityLogId
	 * @return
	 */
	public ActivityLogEntry get(int activityLogId);
	
	/** Save an activity log entry
	 * 
	 * @param entry
	 */
	public void save(ActivityLogEntry entry);
		
	/** Get a list of activity entries
	 * 
	 * @param siteId Pass the site ids, or, pass an empty array for all sites
	 * @param activityId Pass the activity ids, or, pass an empty array for all activities
	 * @param memberIds Pass the member ids, or, pass an empty array for all members
	 * @param fromDt check-in from date
	 * @param toDt check-in to date
	 * @param type Activity log entry type
	 * @return
	 */
	public List<ActivityLogEntry> get(List<Integer> siteIds, List<Integer> activityIds, List<Integer> memberIds, Date fromDt, Date toDt, ActivityLogEntryType type);
	
	/** Delete an activity log entry
	 * 
	 * @param entry
	 */
	public void delete(ActivityLogEntry entry);
	

}
