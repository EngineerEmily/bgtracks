package org.csc480.bgclub.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.csc480.bgclub.domain.ValidationIssue;
import org.csc480.bgclub.service.ValidationException;

/** Validation util
 * 
 * @author kenb
 *
 */
public class ValidationUtil {

	
	/** Sort validation issues
	 * 
	 * @return
	 */
	public static void sort(List<ValidationIssue> issues){
		
		Collections.sort(issues, new ValidationComparator());
		
	}
	

	/** Throw the validation exception if there is one
	 * 
	 * @param issues
	 */
	public static void throwValidationException(List<ValidationIssue> issues){
		
    	if(issues.size() > 1){
    		throw new ValidationException("Multiple validation issues", issues);
    	}
    	else if(issues.size() == 1){
    		throw new ValidationException(issues.get(0).getDescription(), issues);
    	}
    	
    	// Throw no issues
		
	}
	
	
	/** Validation comparator
	 * 
	 * @author kenb
	 *
	 */
	private static class ValidationComparator implements Comparator<ValidationIssue>{

		@Override
		public int compare(ValidationIssue o1, ValidationIssue o2) {
			return o2.getSeverity().getValue() - o1.getSeverity().getValue();
		}

		
	}
	
}
