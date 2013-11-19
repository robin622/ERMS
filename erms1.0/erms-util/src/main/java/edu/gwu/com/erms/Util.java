package edu.gwu.com.erms;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import com.mongodb.DBObject;

/**
 * Hello world!
 *
 */
public class Util 
{
	public static Object converter(DBObject source_object,Class className){
		Object obj=null;
		try {
			obj=Class.forName(className.getName()).newInstance();
			BeanInfo beanInfor=Introspector.getBeanInfo(className);
			PropertyDescriptor[] p = beanInfor.getPropertyDescriptors();
			 for(int i=0;i<p.length;i++){
				 if("class".equalsIgnoreCase(p[i].getName())){
					 continue;
				 }
				 String name=p[i].getName();
				 p[i].getWriteMethod().invoke(obj, source_object.get(name));
	            }
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
