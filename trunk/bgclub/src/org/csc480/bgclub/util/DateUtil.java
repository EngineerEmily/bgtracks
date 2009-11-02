package org.csc480.bgclub.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

	/** Compute the minutes between two dates
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static int minutes(Date start, Date end){
		
		BigDecimal milliseconds = new BigDecimal( end.getTime() - start.getTime() );
		BigDecimal minutes = milliseconds.divide(new BigDecimal("60000"), RoundingMode.HALF_UP);
		return minutes.intValue();
		
	}
	
	/** Compose a date
	 * 
	 * @param year
	 * @param month 1=Jan, 12=Dec
	 * @param day 
	 * @return
	 */
	public static Date date(int year, int month, int day){
		
		return new GregorianCalendar(year, month -1, day).getTime();
	}
	
	/** A long ago date
	 * 
	 * @return
	 */
	public static Date longAgo(){
		return date(1900, 1, 1);
	}
	
	/** Way in the future
	 * 
	 * @return
	 */
	public static Date farFuture(){
		return date(2999, 1, 1);
	}
}
