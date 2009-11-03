package org.nucsc480.projectsite.web.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.csc480.bgclub.domain.Site;
import org.csc480.projectsite.web.dataaccess.DataAccessPoint;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.stereotype.Service;

@Service
@RemoteProxy
public class SiteService {

	protected final Log logger = LogFactory.getLog(getClass());

	
	@RemoteMethod
	public List<Site> getSites(){
		
		return DataAccessPoint.getSiteManagerAccess().getSites();
		
		
	}
	
	@RemoteMethod
	public void addSite(String name){
		
		DataAccessPoint.getSiteManagerAccess().saveSite(new Site(name));
		
	}
	
}
