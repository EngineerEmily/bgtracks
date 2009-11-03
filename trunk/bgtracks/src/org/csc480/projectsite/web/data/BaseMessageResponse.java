package org.csc480.projectsite.web.data;

import java.io.Serializable;

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;
@DataTransferObject
public class BaseMessageResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8072387549699696840L;
	@RemoteProperty
	private boolean isValid = false;
	@RemoteProperty
	private String message = "";
	@RemoteProperty
	private Object data = null;
	@RemoteProperty
	private String successDelegate = "";
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public boolean getIsValid() {
		return isValid;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Object getData() {
		return data;
	}
	public void setSuccessDelegate(String successDelegate) {
		this.successDelegate = successDelegate;
	}
	public String getSuccessDelegate() {
		return successDelegate;
	}
		

}
