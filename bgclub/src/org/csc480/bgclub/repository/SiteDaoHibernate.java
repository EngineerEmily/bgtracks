package org.csc480.bgclub.repository;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.csc480.bgclub.domain.Site;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/** Hibernate implementation of Site DAO
 * 
 * @author kenb
 *
 */
public class SiteDaoHibernate extends HibernateDaoSupport implements SiteDao {

	protected final Log logger = LogFactory.getLog(getClass());
	
	
	@Override
	public void delete(Site site) {
		logger.debug("Delete site id " + site.getSiteId());
		getHibernateTemplate().delete(site);
	}

	@Override
	public Site get(int siteId) {
		logger.debug("Getting site with id " + siteId);
		return (Site) getHibernateTemplate().get(Site.class, siteId);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Site> getAll() {
		logger.debug("Getting all sites");
		return (List<Site>) getHibernateTemplate().find("from Site site order by site.name");
	}

	@Override
	public void save(Site site) {
		logger.debug("Saving site");
		getHibernateTemplate().saveOrUpdate(site);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Site getByName(String name) {
		logger.debug("Getting site by name '" + name + "'");
		List<Site> matches = (List<Site>) getHibernateTemplate().find("from Site site where site.name = ?", name);
		return (matches.size() > 0 ? matches.get(0) : null);
	}

}
