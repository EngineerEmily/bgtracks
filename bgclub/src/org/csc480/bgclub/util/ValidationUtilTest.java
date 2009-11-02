package org.csc480.bgclub.util;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.csc480.bgclub.domain.ValidationIssue;
import org.csc480.bgclub.domain.ValidationIssue.IssueSeverity;
import org.junit.Test;


/** Junit test for validation util
 * 
 * @author kenb
 *
 */
public class ValidationUtilTest {

	@Test
	public void testSort(){
		
		List<ValidationIssue> issues = new ArrayList<ValidationIssue>();
		
		issues.add(new ValidationIssue(null, IssueSeverity.INFO, "A", "Info A"));
		issues.add(new ValidationIssue(null, IssueSeverity.WARN, "B", "Warn B"));
		issues.add(new ValidationIssue(null, IssueSeverity.ERROR, "C", "Error C"));
		issues.add(new ValidationIssue(null, IssueSeverity.ERROR, "D", "Error D"));
		issues.add(new ValidationIssue(null, IssueSeverity.WARN, "E", "Warn E"));
		
		
		// Ensure the errors are front loaded in the array
		int lastSeverity = Integer.MAX_VALUE;
		ValidationUtil.sort(issues);
		for(ValidationIssue issue : issues){
			
			System.out.println(issue.getDescription());
			assertTrue(issue.getSeverity().getValue() <= lastSeverity);
			lastSeverity = issue.getSeverity().getValue();
			
		}
		
		
		
	}
}
