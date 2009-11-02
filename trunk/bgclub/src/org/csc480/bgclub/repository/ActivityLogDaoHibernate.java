/**
 * 
 */
package org.csc480.bgclub.repository;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.csc480.bgclub.domain.ActivityLogEntry;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.type.IntegerType;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author kenb
 *
 */
public class ActivityLogDaoHibernate extends HibernateDaoSupport implements ActivityLogDao {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public void delete(ActivityLogEntry entry) {
		logger.debug("Deleting activity log entry " + entry.getActivityLogId());
		getHibernateTemplate().delete(entry);
	}

	
	@Override
	public ActivityLogEntry get(int activityLogId) {
		logger.debug("Getting activity log entry " + activityLogId);
		return (ActivityLogEntry) getHibernateTemplate().get(ActivityLogEntry.class, activityLogId);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<ActivityLogEntry> get(final List<Integer> siteIds, final List<Integer> activityIds, 
			final List<Integer> memberIds, final Date fromDt, final Date toDt, final ActivityLogEntryType type) {
		
		
		return (List<ActivityLogEntry>) getHibernateTemplate().execute( new HibernateCallback() {
			public Object doInHibernate( Session session ) throws HibernateException,SQLException{
				
				StringBuilder hql = new StringBuilder("from ActivityLogEntry entry where ");
				
				if(siteIds != null && siteIds.size() > 0){
					hql.append("entry.siteId in ( :siteIds ) and ");
				}
				if(activityIds != null && activityIds.size() > 0){
					hql.append("entry.activityId in ( :activityIds ) and ");
				}
				if(memberIds != null && memberIds.size() > 0){
					hql.append("entry.memberId in ( :memberIds )  and ");
				}
				
				hql.append("entry.checkinTm between :fromDt and :toDt ");
				
				
				if(type == ActivityLogEntryType.CLOSED){
					hql.append("and entry.checkoutTm is not null");
				}
				else if(type == ActivityLogEntryType.OPEN){
					hql.append("and entry.checkoutTm is null");
				}
				
				Query query = session.createQuery(hql.toString());
				
				
				if(siteIds != null && siteIds.size() > 0){
					query.setParameterList("siteIds", siteIds.toArray(new Integer[siteIds.size()]));	
				}
				if(activityIds != null && activityIds.size() > 0){
					query.setParameterList("activityIds", activityIds.toArray(new Integer[activityIds.size()]));	
				}
				if(memberIds != null && memberIds.size() > 0){
					query.setParameterList("memberIds", memberIds, new IntegerType());	
				}
				query.setDate("fromDt", fromDt);
				query.setDate("toDt", toDt);
				
				return query.list();
			}
		} );
		
		
	}

	
	@Override
	public void save(ActivityLogEntry entry) {
		logger.debug("Saving activity log entry " + entry.getActivityLogId());
		getHibernateTemplate().saveOrUpdate(entry);
	}

}
