package org.csc480.bgclub.util;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class DateUtilTest {

	
	@Test
	public void testMinutes(){
		
		Date now = new Date();
		Date nowPlusOneMinute = new Date(now.getTime() + 60000);
		Date nowPlus59Seconds = new Date(now.getTime() + 59000);
		Date nowPlus29Seconds = new Date(now.getTime() + 29000);
		
		assertEquals("Wrong!!", 1, DateUtil.minutes(now, nowPlusOneMinute));
		assertEquals("Wrong!!", 1, DateUtil.minutes(now, nowPlus59Seconds));
		assertEquals("Wrong!!", 0, DateUtil.minutes(now, nowPlus29Seconds));
		
	}
	
	@Test
	public void testDate(){
		
		Date date = DateUtil.date(2009, 1, 1);
		assertTrue("Wrong date", date.toString().startsWith("Thu Jan 01 00:00:00"));
		
	}
}
