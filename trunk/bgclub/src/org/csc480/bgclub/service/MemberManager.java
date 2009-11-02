package org.csc480.bgclub.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.csc480.bgclub.domain.Member;
import org.csc480.bgclub.domain.ValidationIssue;
import org.csc480.bgclub.repository.MemberDao;
import org.csc480.bgclub.util.ValidationUtil;

/**
 * Member manager
 * 
 * @author kenb
 * 
 */
public class MemberManager {

	private MemberDao memberDao;

	public boolean deleteMember(int memberId) {
		try {
			memberDao.delete(memberDao.get(memberId));
			return true;
		} catch (Exception ex) {
			return false;

		}
	}

	public Member getMember(int memberId) {
		return memberDao.get(memberId);
	}

	/**
	 * Create or update a member
	 * 
	 * @param member
	 */
	public void saveMember(Member member) {

		validate(member);

		memberDao.save(member);

	}

	public List<Member> getMemberByLastName(String lastName) {
		return memberDao.getByLastName(lastName);

	}

	public List<Member> getMemberByMatch(String firstName, String lastName,
			Date birthDate,String sortColumn,String sortDirection) {
		return memberDao.getByMatch(firstName, lastName, birthDate, sortColumn, sortDirection);
	}

	/**
	 * Validate the site
	 * 
	 * @param member
	 */
	public List<ValidationIssue> getValidationIssues(Member member) {

		List<ValidationIssue> issues = new ArrayList<ValidationIssue>();

		// TODO Write validations!!

		// Sort the issues, Errors first
		ValidationUtil.sort(issues);

		return issues;

	}

	/**
	 * Validate the member
	 * 
	 * @param member
	 */
	private void validate(Member member) {

		List<ValidationIssue> issues = getValidationIssues(member);

		if (issues.size() > 0) {
			ValidationUtil.throwValidationException(issues);
		}

	}

	/**
	 * @param memberDao
	 *            the memberDao to set
	 */
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	
	/** Find members
	 * 
	 * @param searchString
	 * @param sortBy
	 * @return
	 */
	public List<Member> findMembers(String searchString, String... sortBy){
		return  memberDao.findMembers(searchString, sortBy);
	}
}
