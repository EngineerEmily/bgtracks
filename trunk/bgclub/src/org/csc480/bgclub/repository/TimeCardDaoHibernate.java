package org.csc480.bgclub.repository;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.csc480.bgclub.domain.TimeCardEntry;
import org.csc480.bgclub.service.TimeCardException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/** Hibernate implementation of timecard dao
 * 
 * @author kenb
 *
 */
public class TimeCardDaoHibernate extends HibernateDaoSupport implements TimeCardDao{

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public void delete(TimeCardEntry entry) {
		logger.debug("Deleting time card entry with id '" + entry.getTimeCardId() + "'");
		getHibernateTemplate().delete(entry);
		
	}

	@Override
	public TimeCardEntry get(int timeCardId) {
		logger.debug("Getting time card entry with id '" + timeCardId + "'");
		return (TimeCardEntry) this.getHibernateTemplate().get(TimeCardEntry.class, timeCardId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public TimeCardEntry getOpenTimeCardEntry(final int employeeId) {
		logger.debug("Getting open time card entry for employee id '" + employeeId + "'");
		
		// There is no straightforward way to create a query using the HibernateTemplate API, which is the recommended way to use hibernate in Sptring
		// So, we need to create a HibernateCallback object to pass to the hibernate template.  This callback object 
		// is passed the hibernate session by the spring framework, which then can create and execute the query and return the results
		List<TimeCardEntry> openEntries = (List<TimeCardEntry>) getHibernateTemplate().execute( new HibernateCallback() {
			public Object doInHibernate( Session session ) throws HibernateException,SQLException{
				Query query = session.createQuery("from TimeCardEntry entry where entry.employeeId = :id and entry.clockoutTm is null");
				query.setInteger("id", employeeId);	
				return query.list();
			}
		} );
		
		if(openEntries.size() > 1){
			throw new TimeCardException("Multiple open time card entries found in the database for employee '" + employeeId + "'");
		}
		
		return openEntries.size() == 1 ? openEntries.get(0) : null;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TimeCardEntry> getTimeCardEntries(final int employeeId, final Date fromDt, final Date toDt) {
		logger.debug("Getting time card entries for employee id '" + employeeId + "' between " + fromDt + " and " + toDt);
		
		List<TimeCardEntry> entries = (List<TimeCardEntry>) getHibernateTemplate().execute( new HibernateCallback() {
			public Object doInHibernate( Session session ) throws HibernateException,SQLException{
				Query query = session.createQuery("from TimeCardEntry entry where entry.employeeId = :id and entry.clockinTm between :clockinFrom and :clockinTo");
				query.setInteger("id", employeeId);	
				query.setDate("clockinFrom", fromDt);	
				query.setDate("clockinTo", toDt);	
				return query.list();
			}
		} );
				
		return entries;
	}

	@Override
	public void save(TimeCardEntry entry) {
		
		logger.debug("Saving timecard for employee id '" + entry.getEmployeeId() + "'");
		
		// Ensure there's only one open time card entry for the employee
		if(entry.getClockoutTm() == null){
			if(getOpenTimeCardEntry(entry.getEmployeeId()) != null){
				throw new TimeCardException("There are is already an open time card entry for employee '" + entry.getEmployeeId() + "'");
			}
		}
		
		this.getHibernateTemplate().saveOrUpdate(entry);
		
	}

}
