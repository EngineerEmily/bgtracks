package org.csc480.bgclub.test;


import java.util.List;

import org.csc480.bgclub.domain.Site;
import org.csc480.bgclub.service.SiteManager;
import org.csc480.bgclub.service.ValidationException;
import org.csc480.bgclub.util.TestContext;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

public class SiteManagerTest extends AbstractTransactionalDataSourceSpringContextTests{

	private SiteManager siteManager;
	
	protected String[] getConfigLocations() {
		return new String[]{TestContext.TEST_CONFIG};
	}
	
		
	/**
	 * @param siteManager the siteManager to set
	 */
	public void setSiteManager(SiteManager siteManager) {
		this.siteManager = siteManager;
	}


	public void test(){
		
		
		Site site = new Site("Site B");
		siteManager.saveSite(site);
		int siteBid = site.getSiteId();
		
		site = new Site("Site A");
		siteManager.saveSite(site);
		
		// Attempt to save an invalid site
		boolean exceptionThrown = false;
		try{
			siteManager.saveSite(new Site(""));
		}
		catch(ValidationException e){
			exceptionThrown = true;
		}
		assertTrue("Validation exception not thrown", exceptionThrown);
		
		List<Site> sites = siteManager.getSites();
		assertEquals("Wrong # of sites", 2, sites.size());
		
		assertEquals("Wrong ordering of sites", "Site A", sites.get(0).getName());
		
		Site rs = siteManager.getSite(siteBid);
		assertEquals("Wrong site", rs.getName(), "Site B");
		
		
	}
}
