package org.nucsc480.projectsite.web.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.csc480.bgclub.domain.Activity;
import org.csc480.projectsite.web.dataaccess.DataAccessPoint;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.stereotype.Service;

@Service
@RemoteProxy
public class ActivityService {

	protected final Log logger = LogFactory.getLog(getClass());


	@RemoteMethod
	public List<Activity> getActivities(){
		
		return DataAccessPoint.getActivityManagerAccess().getActivities();
		
	}
	
	@RemoteMethod
	public void addActivity(String name){
		
		DataAccessPoint.getActivityManagerAccess().saveActivity(new Activity(name));
			
	}
	
}
