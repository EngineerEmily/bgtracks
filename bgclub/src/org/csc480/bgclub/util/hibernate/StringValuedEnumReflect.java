package org.csc480.bgclub.util.hibernate;

/**
 * Utility class designed to inspect StringValuedEnums.
 * 
 * This code was downloaded from https://www.hibernate.org/273.html
 */
public class StringValuedEnumReflect {
    
    /**
     * Don't let anyone instantiate this class.
     * @throws UnsupportedOperationException Always.
     */
    private StringValuedEnumReflect() {
        throw new UnsupportedOperationException("This class must not be instanciated.");
    }
    
    /**
     * All Enum constants (instances) declared in the specified class. 
     * @param enumClass Class to reflect
     * @return Array of all declared EnumConstants (instances).
     */
    @SuppressWarnings("unchecked")
	private static <T extends Enum> T[] 
            getValues(Class<T> enumClass){
        return enumClass.getEnumConstants();
    }
    
    /**
     * All possible string values of the string valued enum.
     * @param enumClass Class to reflect.
     * @return Available string values.
     */
    @SuppressWarnings("unchecked")
	public static <T extends Enum & StringValuedEnum> String[] 
            getStringValues(Class<T> enumClass){ 
        T[] values = getValues(enumClass);
        String[] result = new String[values.length];
        for (int i=0; i<values.length; i++){
            result[i] = values[i].getValue();
        }
        return result;
    }
    
    /**
     * Name of the enum instance which hold the especified string value.
     * If value has duplicate enum instances than returns the first occurency.
     * @param enumClass Class to inspect.
     * @param value String.
     * @return name of the enum instance.
     */
    @SuppressWarnings("unchecked")
	public static <T extends Enum & StringValuedEnum> String 
            getNameFromValue(Class<T> enumClass, String value){
        T[] values = getValues(enumClass);
        for (int i=0; i<values.length; i++){
            if (values[i].getValue().compareTo(value)==0){
                return values[i].name();
            }
        }
        return "";
    }
    
}