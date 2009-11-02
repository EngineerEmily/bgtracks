package org.csc480.bgclub.repository;

import java.util.List;

import org.csc480.bgclub.domain.Activity;

/** Activity DAO
 * 
 * @author kenb
 *
 */
public interface ActivityDao  {

	/** Get a activity by id
	 * 
	 * @param activityId
	 * @return
	 */
	public Activity get(int activityId);
	
	/** Get activity by name
	 * 
	 * @param name
	 * @return
	 */
	public Activity getByName(String name);
	
	
	/** Get all activitiess
	 * 
	 * @return activities
	 */
	public List<Activity> getAll();
	
	
	/** Save the activity
	 * 
	 * @param activity
	 */
	public void save(Activity activity);
	
	
	/** Delete a activity
	 * 
	 * @param activity
	 */
	public void delete(Activity activity);
}
