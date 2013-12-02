package edu.gwu.com.erms;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DateUtilTest {
    
    Calendar cal = null;

    @Before
    public void setUp() throws Exception {
        cal = Calendar.getInstance();
    }

    @After
    public void tearDown() throws Exception {
        cal = null;
    }

    @Test
    public void testGetLocalUTCTime() {
    	Date date=DateUtil.getLocalUTCTime();
    	cal.add(Calendar.HOUR,5);
    	Assert.assertEquals(date.toString(),cal.getTime().toString());
    }
    
    @Test
    public void testAddHours(){
    	Date date=DateUtil.addHours(cal.getTime(), 1);
    	cal.add(Calendar.HOUR, 1);
    	Assert.assertEquals(date.toString(),cal.getTime().toString());
    }
    
    @Test
    public void testGetTodayTime(){
    	Date date=DateUtil.getTodayTime();
    	cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0); 
    	Assert.assertEquals(date.toString(),cal.getTime().toString());
    }
    
    @Test
    public void testGetFirstDayofThisWeek(){
    	Date date=DateUtil.getFirstDayofThisWeek();
    	cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.getFirstDayOfWeek()+1);
    	Assert.assertEquals(date.toString(),cal.getTime().toString());
    }
    
    
    @Test
    public void testGetEndDayofThisWeek(){
    	Date date=DateUtil.getEndDayofThisWeek();
    	cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH), cal.getFirstDayOfWeek()+7);
    	Assert.assertEquals(date.toString(),cal.getTime().toString());
    }
    
    @Test
    public void testGetFirstDayofThisMonth(){
    	Date date=DateUtil.getFirstDayofThisMonth();
    	cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);
    	Assert.assertEquals(date.toString(),cal.getTime().toString());
    }
    
    @Test
    public void testGetNextDayTime(){
    	Date date=DateUtil.getNextDayTime();
    	cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE)+1, 0, 0, 0);
    	Assert.assertEquals(date.toString(),cal.getTime().toString());
    }
    
}
