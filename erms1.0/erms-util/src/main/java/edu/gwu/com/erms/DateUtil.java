package edu.gwu.com.erms;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import com.mongodb.DBObject;

/**
 * Hello world!
 *
 */
public class DateUtil 
{
	/**
	 * get local UTC time
	 */
	public static Date getLocalUTCTime(){
		final Calendar cal=Calendar.getInstance();
		final int zoneOffset=cal.get(Calendar.ZONE_OFFSET);
		final int dstOffset=cal.get(Calendar.DST_OFFSET);
		cal.add(Calendar.MILLISECOND, -(zoneOffset+dstOffset));
		return cal.getTime();
	}
	
	/**
	 * utc
	 */
	public static Date getUTCTime(){
		Calendar calendar = Calendar.getInstance();  
		TimeZone tztz = TimeZone.getTimeZone("GMT+8");         
		calendar.setTimeZone(tztz); 
		return calendar.getTime();
	}
	
	/**
	 * change to local UTC time
	 */
	public static Date changeToUTCTime(Date date){
		final Calendar cal=Calendar.getInstance();
		cal.setTime(date);
		final int zoneOffset=cal.get(Calendar.ZONE_OFFSET);
		final int dstOffset=cal.get(Calendar.DST_OFFSET);
		cal.add(Calendar.MILLISECOND, -(zoneOffset+dstOffset));
		return cal.getTime();
	}
	
	public static final Date addHours(Date date, int hours) {
		if (date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR_OF_DAY, hours);
		return cal.getTime();
	}
	
	public static Date getTodayTime(){
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0); 
		Date today=cal.getTime();
		return today;
	}
	
	public static Date getFirstDayofThisWeek(){
		int mondayPlus=getMondayPlus();
		GregorianCalendar currentDate=new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus);
		return currentDate.getTime();
	}
	
	private static int getMondayPlus(){
		Calendar cal=Calendar.getInstance();
		int dayOfWeek=cal.get(Calendar.DAY_OF_WEEK)-1;
		if(dayOfWeek==1){
			return 0;
		}else{
			return 1-dayOfWeek;
		}
	}
	
	public static Date getEndDayofThisWeek(){
		int mondayPlus=getMondayPlus();
		GregorianCalendar currentDate=new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus+6);
		return currentDate.getTime();
	}
	
	public static Date getFirstDayofThisMonth(){
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.DATE,1);
		Date today=cal.getTime();
		return today;
	}
	
	public static Date getEndDayofThisMonth(){
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.DATE, 1);
		cal.add(Calendar.MONTH, 1);
		cal.add(Calendar.DATE, -1);
		Date today=cal.getTime();
		return today;
	}
	
	public static Date getNextDayTime(){
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0); 
		Date nextDay=cal.getTime();
		return nextDay;
	}

}
