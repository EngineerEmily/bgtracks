package org.csc480.bgclub.repository;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.csc480.bgclub.domain.Guardian;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/** Hibernate implementation of the guardian DAO
 * 
 * @author kenb
 *
 */
public class GuardianDaoHibernate extends HibernateDaoSupport implements GuardianDao{

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public void delete(Guardian guardian) {
		logger.debug("Deleting guardian with id '" + guardian.getGuardianId() + "'");
		getHibernateTemplate().delete(guardian);
	}

	@Override
	public Guardian get(int guardianId) {
		logger.debug("Getting guardian with id '" + guardianId + "'");
		return (Guardian) getHibernateTemplate().get(Guardian.class, guardianId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Guardian> get(final Integer... guardianIds) {
		logger.debug("Getting list of guardians by id");
		
		return (List<Guardian>) getHibernateTemplate().execute( new HibernateCallback() {
			public Object doInHibernate( Session session ) throws HibernateException,SQLException{
				Query query = session.createQuery("from Guardian guardian where guardian.guardianId IN( :guardianIds )");
				query.setParameterList("guardianIds", guardianIds);
				return query.list();
			}
		} );
		
	}

	@Override
	public void save(Guardian guardian) {
		getHibernateTemplate().saveOrUpdate(guardian);
	}

}
