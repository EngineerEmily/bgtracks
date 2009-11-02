package org.csc480.bgclub.repository;

import java.util.List;

import org.csc480.bgclub.domain.Site;

/** Site DAO
 * 
 * @author kenb
 *
 */
public interface SiteDao {

	/** Get a site by id
	 * 
	 * @param siteId
	 * @return
	 */
	public Site get(int siteId);
	
	
	/** Get all sites
	 * 
	 * @return sites
	 */
	public List<Site> getAll();
	
	
	/** Get name
	 * 
	 * @param name
	 * @return
	 */
	public Site getByName(String name);

	/** Save the site
	 * 
	 * @param site
	 */
	public void save(Site site);
	
	
	/** Delete a site
	 * 
	 * @param site
	 */
	public void delete(Site site);
}
