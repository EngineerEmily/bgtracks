package org.csc480.projectsite.web.data;

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;

@DataTransferObject
public class Test
{
	@RemoteProperty
	private String testString;

	public void setTestString(String testString) {
		this.testString = testString;
	}
	@RemoteProperty
	public String getTestString() {
		return testString;
	}
}
