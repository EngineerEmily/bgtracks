package org.csc480.bgclub.domain;

import java.util.LinkedHashMap;
import java.util.Map;

/** Code set
 * 
 * @author kenb
 *
 */
public class CodeSet {

	private String name;
	private Map<String, String> codes = new LinkedHashMap<String, String>();
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/** Get a value 
	 * 
	 * @param name
	 * @return
	 */
	public String getValue(String name){
		return codes.get(name);
	}
	
	
	/** Set a value
	 * 
	 * @param name
	 * @param value
	 */
	public void setValue(String name, String value){
		codes.put(name, value);
	}
	
	
}
