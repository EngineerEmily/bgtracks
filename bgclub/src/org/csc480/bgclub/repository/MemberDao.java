package org.csc480.bgclub.repository;

import java.util.Date;
import java.util.List;

import org.csc480.bgclub.domain.Member;


/** Member data access object
 * 
 * @author kenb
 *
 */
public interface MemberDao {

	/** Select a Member
	 * 
	 * @param memberId
	 * @return
	 */
	public Member get(int memberId);

	/** Select by pattern
	 * 
	 * @param 
	 * @return
	 */
	public List<Member> getByLastName(String lastName);
	
	/** Select by pattern
	 * 
	 * @param 
	 * @return
	 */
	public List<Member> getByMatch(String firstName,String lastName,Date birthDate,String sortColumn,String sortDirection);

	/** Save a member
	 * 
	 * @param member
	 */
	public void save(Member member);

	/** Delete a member
	 * 
	 * @param member
	 */
	public void delete(Member member);
	
	
	/** Find members
	 * 
	 * @param searchString
	 * @param sortBy
	 * @return
	 */
	public List<Member> findMembers(String searchString, String... sortBy);
	
}
