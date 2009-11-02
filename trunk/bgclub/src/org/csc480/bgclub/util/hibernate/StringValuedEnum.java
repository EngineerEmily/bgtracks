package org.csc480.bgclub.util.hibernate;

/**
 * Utility class designed to allow dinamic fidding and manipulation of Enum 
 * instances which hold a string value.
 * 
 * This code was downloaded from https://www.hibernate.org/273.html
 */
public interface StringValuedEnum {    
    
    /**
     * Current string value stored in the enum.
     * @return string value.
     */
    public String getValue();
    
}