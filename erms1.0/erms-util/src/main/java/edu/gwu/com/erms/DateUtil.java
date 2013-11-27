package edu.gwu.com.erms;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.Date;
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

}
