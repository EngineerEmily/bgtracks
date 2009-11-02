package org.csc480.bgclub.service;

import java.util.ArrayList;
import java.util.List;

import org.csc480.bgclub.domain.Site;
import org.csc480.bgclub.domain.ValidationIssue;
import org.csc480.bgclub.domain.ValidationIssue.IssueSeverity;
import org.csc480.bgclub.repository.SiteDao;
import org.csc480.bgclub.util.ValidationUtil;

/** Site manager
 * 
 * @author kenb
 *
 */
public class SiteManager {

	private SiteDao siteDao;
	
	
	/** Get a site
	 * 
	 * @param siteId
	 * @return
	 */
	public Site getSite(int siteId){
		return siteDao.get(siteId);
	}
	
	
	/** Get all sites
	 * 
	 * @return
	 */
	public List<Site> getSites(){
		
		return siteDao.getAll();
		
	}
	
	/** Save an existing or new site
	 * 
	 * @param site
	 */
	public void saveSite(Site site){
		
		validate(site);
		
		siteDao.save(site);
		
	}
	
	
	/** Validate the site
	 * 
	 * @param employee
	 */
	public List<ValidationIssue> getValidationIssues(Site site){
		
		List<ValidationIssue> issues = new ArrayList<ValidationIssue>();
		
		if(site.getName() == null || site.getName().length() == 0){
    		issues.add(new ValidationIssue(site, IssueSeverity.ERROR, "EmptySiteName", "Please enter a site name"));
    	}
		
		// TODO Write more validations!!
		
		
		// Sort the issues, Errors first
		ValidationUtil.sort(issues);
		
		return issues;
    	
	}
	

	/** Validate the site
	 * 
	 * @param site
	 */
	private void validate(Site site){
		
		List<ValidationIssue> issues = getValidationIssues(site);
		
		if(issues.size() > 0){
			ValidationUtil.throwValidationException(issues);
		}
		
	}
	


	/**
	 * @param siteDao the siteDao to set
	 */
	public void setSiteDao(SiteDao siteDao) {
		this.siteDao = siteDao;
	}

	
	
	
	
}
