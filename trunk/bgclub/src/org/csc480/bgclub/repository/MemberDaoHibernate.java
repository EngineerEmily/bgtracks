package org.csc480.bgclub.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.csc480.bgclub.domain.Member;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Hibernate implementation of Member DAO
 * 
 * @author kenb
 * 
 */
public class MemberDaoHibernate extends HibernateDaoSupport implements
		MemberDao {

	protected final Log logger = LogFactory.getLog(getClass());

	@Override
	public void delete(Member member) {
		logger.debug("Deleting member " + member.getMemberId());
		getHibernateTemplate().delete(member);
	}

	@Override
	public Member get(int memberId) {
		logger.debug("Getting member " + memberId);
		return (Member) getHibernateTemplate().get(Member.class, memberId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Member> getByLastName(String lastName) {
		logger.debug("Getting members by last name");
		return (List<Member>) getHibernateTemplate().find(
				"from Member m where m.lastName = ? order by m.firstName",
				lastName);
	}

	@SuppressWarnings("unchecked")
	public List<Member> getByMatch(String firstName, String lastName, Date birthDate,String sortColumn,String sortDirection) {
		
		logger.debug("Getting members by last name");
		
		String hql = "from Member m where ";
		
		List<Object> o = new ArrayList<Object>();
		if(birthDate != null){
			hql += "m.birthDate = ? or ";
			o.add(birthDate);
		}
		if(firstName != null){
			hql += "m.firstName like ? or ";
			o.add("%" + firstName + "%");
		}
		if(lastName != null){
			hql += "m.lastName like ? or ";
			o.add("%" + lastName + "%");
		}
		
		if(hql.endsWith("or ")){
			hql = hql.substring(0, hql.length() - 3);
		}
		else{
			hql = hql.substring(0, hql.length() - 6);
		}
		
		if(sortColumn.trim().equals("")){
		hql += " order by m.firstName";
		}
		else
		{
			hql += " order by m." + sortColumn + " " + sortDirection;	
		}
		
		return (List<Member>) getHibernateTemplate().find(hql, o.toArray(new Object[o.size()]));
	}

	@Override
	public void save(Member member) {
		logger.debug("Saving member " + member.getMemberId());
		getHibernateTemplate().saveOrUpdate(member);
	}
	
	

	/**
	 * Find members
	 * 
	 * @param searchString
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Member> findMembers(String searchString, String... sortBy) {

		String[] tokens = searchString.split(" ");
		
		// Note, there has to be at least 2 columns or this algorithm will fail
		String[] columns = new String[] { "firstName", "lastName" }; 

		Criteria crit = this.getSession().createCriteria(Member.class);
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		if(sortBy != null){
			for(String thisSortBy : sortBy){
				crit.addOrder(Order.asc(thisSortBy));		
			}
		}
				
		LogicalExpression orExp = null;
		Criterion firstCrit = null;
		for (String token : tokens) {
			if (token.trim().length() > 0) {
				// Loop through each column to compare
				for (String column : columns) {
					Criterion thisCrit = Restrictions.like(column, '%' + token
							.trim() + '%');

					// First iteration, set the first criteria as we need two to
					// create the orExp
					if (firstCrit == null) {
						firstCrit = thisCrit;
					}

					// Second iteration, create the or expression by combining
					// the first criteria and this one
					else if (orExp == null) {
						orExp = Restrictions.or(firstCrit, thisCrit);
					}

					// Subsequent iteration, compound the or expression
					else {
						orExp = Restrictions.or(orExp, thisCrit);
					}
				}

			}

		}
		if (orExp != null) {
			crit.add(orExp);
		}
		List<Member> members = crit.list();
		return members;
	}

}
