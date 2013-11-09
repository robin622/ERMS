package edu.gwu.com.erms.dao.impl;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.QueryBuilder;
import com.mongodb.WriteResult;

import edu.gwu.com.erms.bean.User;
import edu.gwu.com.erms.dao.Connection;
import edu.gwu.com.erms.dao.UserDAO;

public class UserDAOImpl implements UserDAO{
	private Connection connection;
	public DBCollection getTable(){
		DBCollection table = connection.getConnection().getCollection("user");
		return table;
	}
	public UserDAOImpl() {
		connection = Connection.getInstance();
	}
	
	public boolean insertUser(User user){
		DBCollection table=getTable();
		BasicDBObject document = new BasicDBObject();
		document.put("name", user.getName());
		document.put("password", user.getPassword());
		document.put("email", user.getEmail());
		document.put("date",new Date());
		document.put("status",user.getStatus());
		int i=table.insert(document).getN();
		return i>0?true:false;
	}
	
	//check whether user exists or not
	public boolean checkUser(User user) {
		boolean b=false;
		DBCollection table=getTable();
		DBObject query = new QueryBuilder().put("name").is(user.getName())
				.and("password").is(user.getPassword())
				.and("status").is(user.getStatus()).get();
		DBCursor cur = table.find(query);
		if(cur.hasNext()){
			b=true;
		}
		return b;
	}
	
	public List<User> listUser() {
		List<User> users=new ArrayList<User>();
		DBCollection table=getTable();
		DBCursor cursor=table.find();
		while(cursor.hasNext()){
			DBObject dbo=cursor.next();
			User user=(User) converter2(dbo,User.class);
			users.add(user);
		}
		return users;
	}
	
	//delete 
	public boolean deleteAllUser(){
		DBCollection table=getTable();
		table.drop();
		return true;
	}
	
	private User converter(DBObject object){
		User user=new User();
		String name=(String)object.get("name");
		String password=(String)object.get("password");
		String email=(String)object.get("email");
		Date createDatetime=(Date)object.get("date");
		int status=(Integer) object.get("status");
		user.setName(name);
		user.setPassword(password);
		user.setEmail(email);
		user.setDate(createDatetime);
		user.setStatus(status);
		return user;
	}
	
	private Object converter2(DBObject source_object,Class className){
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
