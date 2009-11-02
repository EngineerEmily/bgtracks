package org.csc480.bgclub.repository;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.csc480.bgclub.domain.Activity;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ActivityDaoHibernate extends HibernateDaoSupport implements ActivityDao {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public void delete(Activity activity) {
		logger.debug("Deleting activity " + activity.getActivityId());
		getHibernateTemplate().delete(activity);
	}

	@Override
	public Activity get(int activityId) {
		logger.debug("Getting activity " + activityId);
		return (Activity) getHibernateTemplate().get(Activity.class, activityId);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Activity> getAll() {
		logger.debug("Get all activities");
		return (List<Activity>) getHibernateTemplate().find("from Activity activity order by activity.name");
	}

	@Override
	public void save(Activity activity) {
		logger.debug("Saving activity " + activity.getActivityId());
		getHibernateTemplate().saveOrUpdate(activity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Activity getByName(String name) {
		logger.debug("Get all activities");
		List<Activity> matches = (List<Activity>) getHibernateTemplate().find("from Activity activity where activity.name = ?", name);
		return (matches.size() > 0 ? matches.get(0) : null);
	}

}
