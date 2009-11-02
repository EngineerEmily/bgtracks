package org.csc480.bgclub.test;

import java.util.Date;
import java.util.List;

import org.csc480.bgclub.domain.Member;
import org.csc480.bgclub.repository.MemberDao;
import org.csc480.bgclub.util.DateUtil;
import org.csc480.bgclub.util.TestContext;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

/** Junit test for Member DAO
 * 
 * @author kenb
 *
 */
public class MemberDaoTest extends AbstractTransactionalDataSourceSpringContextTests {

	private MemberDao memberDao;
	
	protected String[] getConfigLocations() {
		return new String[]{TestContext.TEST_CONFIG};
	}
	
	/** Set member dao
	 * 
	 * @param memberDao
	 */
	public void setMemberDao(MemberDao memberDao){
		this.memberDao = memberDao;
	}
	
	public void test(){
		
		
		Member bart = new Member("Bart", "Simpson", new Date());
		bart.setBirthDate(DateUtil.date(1993, 1, 1));
		
		Member marge = new Member("Marge", "Simpson-Bouvier", new Date());
		marge.setBirthDate(DateUtil.date(1966, 1, 1));
		
		Member homer = new Member("Homer", "Simpson", new Date());
		homer.setBirthDate(DateUtil.date(1960, 1, 1));
		
		Member maggie = new Member("Maggie", "Simpson", new Date());
		maggie.setBirthDate(DateUtil.date(2006, 1, 1));
		
		memberDao.save(bart);
		memberDao.save(marge);
		memberDao.save(maggie);
		memberDao.save(homer);
		
		
		List<Member> members = memberDao.getByMatch("Q", "i", null,"","");
		assertEquals("Wrong number of members", 4, members.size());
		assertEquals("Wrong number of members", 3, memberDao.getByMatch("a", null, null,"","").size());
		assertEquals("Wrong number of members", 1, memberDao.getByMatch(null, null, DateUtil.date(2006, 1, 1),"","").size());
		assertEquals("Wrong number of members", 0, memberDao.getByMatch(null, null, DateUtil.date(2006, 1, 2),"","").size());
		assertEquals("Wrong number of members", 4, memberDao.getByMatch(null, null, null,"","").size());
		assertEquals("Wrong number of members", 1, memberDao.getByMatch(null, "ier", null,"","").size());
		
		
		
	}
}
