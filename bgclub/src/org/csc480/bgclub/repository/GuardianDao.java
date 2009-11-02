package org.csc480.bgclub.repository;

import java.util.List;

import org.csc480.bgclub.domain.Guardian;

/** Guardian DAO
 * 
 * @author kenb
 *
 */
public interface GuardianDao {

	/** Get a guardian by id
	 * 
	 * @param guardianId
	 * @return
	 */
	public Guardian get(int guardianId);
	
	
	/** Get a list of guardians by ids
	 * 
	 * @param guardianIds
	 * @return
	 */
	public List<Guardian> get(Integer... guardianIds);
	
	
	/** Save the guardian
	 * 
	 * @param guardian
	 */
	public void save(Guardian guardian);
	
	
	/** Delete a guardian
	 * 
	 * @param guardian
	 */
	public void delete(Guardian guardian);
	
	
}
