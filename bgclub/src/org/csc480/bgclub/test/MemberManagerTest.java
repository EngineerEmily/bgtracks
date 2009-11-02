package org.csc480.bgclub.test;

import java.util.Date;
import java.util.List;

import org.csc480.bgclub.domain.EmergencyContact;
import org.csc480.bgclub.domain.Guardian;
import org.csc480.bgclub.domain.GuardianRef;
import org.csc480.bgclub.domain.MedicalCondition;
import org.csc480.bgclub.domain.Medication;
import org.csc480.bgclub.domain.Member;
import org.csc480.bgclub.domain.GuardianRef.RelationshipType;
import org.csc480.bgclub.domain.Person.Sex;
import org.csc480.bgclub.service.GuardianManager;
import org.csc480.bgclub.service.MemberManager;
import org.csc480.bgclub.util.TestContext;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

/** Member manager test
 * 
 * @author kenb
 *
 */
public class MemberManagerTest extends AbstractTransactionalDataSourceSpringContextTests {

	private MemberManager memberManager;
	private GuardianManager guardianManager;
	

	protected String[] getConfigLocations() {
		return new String[]{TestContext.TEST_CONFIG};
	}

	public void test(){
		
		Guardian guardian = new Guardian();
		guardian.setLastName("Simpson");
		guardian.setFirstName("Homer");
		guardian.setHomePhone("555-1000");
		guardianManager.saveGuardian(guardian);
		
		Member member = new Member();
		member.setLastName("Simpson");
		member.setFirstName("Bart");
		member.setStartDt(new Date());
		member.setSex(Sex.MALE);
		
		member.addCondition(new MedicalCondition("Asthma"));
		member.addContact(new EmergencyContact("Patty", "Bouvier", "555-1212"));
		member.addContact(new EmergencyContact("Gladys", "Bouvier", "555-1213"));
		member.addMedication(new Medication("Asthma Inhaler"));
		
		member.addGuardianRef(new GuardianRef(guardian.getGuardianId(), RelationshipType.PARENT));
		memberManager.saveMember(member);
		
		member = new Member();
		member.setLastName("Simpson");
		member.setFirstName("Lisa");
		member.setStartDt(new Date());
		member.setSex(Sex.FEMALE);
		
		member.addGuardianRef(new GuardianRef(guardian.getGuardianId(), RelationshipType.PARENT));
		memberManager.saveMember(member);
		
		assertNotNull(memberManager.getMember(member.getMemberId()));
		
		assertEquals(2, memberManager.getMemberByLastName("Simpson").size());

		List<Member> members = memberManager.findMembers("a", "lastName");
		assertEquals(2, members.size());
	
	}

	/**
	 * @param memberManager the memberManager to set
	 */
	public void setMemberManager(MemberManager memberManager) {
		this.memberManager = memberManager;
	}

	/**
	 * @param guardianManager the guardianManager to set
	 */
	public void setGuardianManager(GuardianManager guardianManager) {
		this.guardianManager = guardianManager;
	}
	
	
	
	
	
}
