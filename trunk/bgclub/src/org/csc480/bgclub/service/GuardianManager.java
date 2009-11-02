package org.csc480.bgclub.service;

import java.util.ArrayList;
import java.util.List;

import org.csc480.bgclub.domain.Guardian;
import org.csc480.bgclub.domain.GuardianRef;
import org.csc480.bgclub.domain.Member;
import org.csc480.bgclub.repository.GuardianDao;

/** Guardian mansger
 * 
 * @author kenb
 *
 */
public class GuardianManager {

	
	private GuardianDao guardianDao;
	
	
	/** Save a guardian
	 * 
	 * @param guardian
	 */
	public void saveGuardian(Guardian guardian){
		guardianDao.save(guardian);
	}

	/** Get all guardians for a member
	 * 
	 * @param member
	 * @return
	 */
	public List<Guardian> getGuardians(Member member){
		
		List<Integer> guardianIds = new ArrayList<Integer>();
		for(GuardianRef guardianRef : member.getGuardianRefs()){
			guardianIds.add(guardianRef.getGuardianId());
		}
		return guardianDao.get(guardianIds.toArray(new Integer[guardianIds.size()]));
		
		
	}


	/**
	 * @param guardianDao the guardianDao to set
	 */
	public void setGuardianDao(GuardianDao guardianDao) {
		this.guardianDao = guardianDao;
	}

	
}
