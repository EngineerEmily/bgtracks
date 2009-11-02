package org.csc480.bgclub.repository;

import java.util.Date;
import java.util.List;

import org.csc480.bgclub.domain.TimeCardEntry;

/**
 * 
 * @author kenb
 *
 */
public interface TimeCardDao {

	/** Get a time card entry
	 * 
	 * @param id
	 * @return
	 */
	public TimeCardEntry get(int id);
	
	/** Get a list of time card entries
	 * 
	 * @param employeeId
	 * @param fromDt
	 * @param toDt
	 * @return
	 */
	public List<TimeCardEntry> getTimeCardEntries(int employeeId, Date fromDt, Date toDt);
	

	/** Get the open time card entry for the current employee
	 * 
	 * @param employeeId
	 * @return
	 */
	public TimeCardEntry getOpenTimeCardEntry(int employeeId);
	
	/** Save a time card entry
	 * 
	 * @param entry
	 */
	public void save(TimeCardEntry entry);
	
	
	/** Delete a time card entry
	 * 
	 * @param entry 
	 */
	public void delete(TimeCardEntry entry);
	
}
