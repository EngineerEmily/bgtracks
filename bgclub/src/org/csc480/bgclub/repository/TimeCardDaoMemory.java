package org.csc480.bgclub.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.csc480.bgclub.domain.TimeCardEntry;


/** Time card entries saved in memory
 * 
 * @author kenb
 *
 */
public class TimeCardDaoMemory implements TimeCardDao{

	// TODO Add logging
	
	private static LinkedHashMap<Integer, TimeCardEntry> entries = new LinkedHashMap<Integer, TimeCardEntry>();
	private static Object lockObject = new Object();
	private static int nextNum = 1000;
	
	
	@Override
	public void delete(TimeCardEntry entry) {
		entries.remove(entry.getTimeCardId());
	}

	@Override
	public TimeCardEntry getOpenTimeCardEntry(int employeeId) {
		
		// Loop through the time cards... this isn't very efficient, but this DAO
		// isn't really meant to be used in a production environment
		for(TimeCardEntry entry : entries.values()){
			if(entry.getEmployeeId() == employeeId && entry.getClockoutTm() == null){
				return (TimeCardEntry) entry.clone();
			}
		}
		return null;
		
	}

	@Override
	public List<TimeCardEntry> getTimeCardEntries(int employeeId, Date fromDt, Date toDt) {
		List<TimeCardEntry> results = new ArrayList<TimeCardEntry>();
		for(TimeCardEntry entry : entries.values()){
			if(entry.getEmployeeId() == employeeId && entry.getClockinTm().after(fromDt) && entry.getClockoutTm().before(toDt)){
				results.add((TimeCardEntry) entry.clone());
			}
		}
		return results;
	}


	@Override
	public TimeCardEntry get(int id) {
		TimeCardEntry entry = entries.get(id);
		if(entry != null){
			return (TimeCardEntry) entry.clone();
		}
		return null;
	}

	@Override
	public void save(TimeCardEntry entry) {
		
		// Verify there are no other open time card entries
		if(entry.getClockoutTm() == null){
			if(getOpenTimeCardEntry(entry.getEmployeeId()) != null){
				throw new RuntimeException("There already exists an open time card entry for employee '" + entry.getEmployeeId() + "'");
			}
		}
		
		// Assign the next id if this is a new timecard entry
		if(entry.getTimeCardId() == 0){
			synchronized(lockObject){
				entry.setTimeCardId(nextNum++);
			}	
		}
		
		entries.put(entry.getTimeCardId(), (TimeCardEntry) entry.clone());
	}
	
}
