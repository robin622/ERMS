package edu.gwu.com.erms.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.QueryBuilder;

import edu.gwu.com.erms.DateUtil;
import edu.gwu.com.erms.Util;
import edu.gwu.com.erms.bean.Request;
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
	
	public User insertUser(User user){
		DBCollection table=getTable();
		//email should be unique
		DBObject query = new QueryBuilder().put("email").is(user.getEmail()).get();
		DBCursor cur0 = table.find(query);
		if(cur0.hasNext()){
			DBObject obj=cur0.next();
			return (User) Util.converter(obj,User.class);
		}
		BasicDBObject document = new BasicDBObject();
		document.put("name", user.getName());
		document.put("password", user.getPassword());
		document.put("email", user.getEmail());
		document.put("date",DateUtil.getLocalUTCTime());
		document.put("status",user.getStatus());
		table.insert(document);
		DBCursor cur=table.find(document);
		while(cur.hasNext()){
			DBObject obj=cur.next();
			return (User) Util.converter(obj,User.class);
		}
		return null;
	}
	
	//check whether user exists or not
	public User checkUser(User user) {
		User b=null;
		DBCollection table=getTable();
		DBObject query = new QueryBuilder().put("name").is(user.getName())
				.and("password").is(user.getPassword())
				.and("status").is(user.getStatus()).get();
		DBCursor cur = table.find(query);
		if(cur.hasNext()){
			DBObject obj=cur.next();
			return (User) Util.converter(obj,User.class);
		}
		return b;
	}
	
	public List<User> listUser() {
		List<User> users=new ArrayList<User>();
		DBCollection table=getTable();
		DBObject query=new QueryBuilder().put("status").is(1.0).get();
		DBCursor cursor=table.find(query);
		while(cursor.hasNext()){
			DBObject dbo=cursor.next();
			User user=(User)Util.converter(dbo,User.class);
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
	//delete a user by user's id
	public boolean deleteUser(String userId) {
		DBCollection table=getTable();
		BasicDBObject document =new BasicDBObject("_id",new ObjectId(userId));
		table.remove(document);
		DBCursor cur=table.find(document);
		while(cur.hasNext()){
			return false;
		}
		return true;
	}
	
//	private User converter(DBObject object){
//		User user=new User();
//		String name=(String)object.get("name");
//		String password=(String)object.get("password");
//		String email=(String)object.get("email");
//		Date createDatetime=(Date)object.get("date");
//		double status=(Integer) object.get("status");
//		user.setName(name);
//		user.setPassword(password);
//		user.setEmail(email);
//		user.setDate(createDatetime);
//		user.setStatus(status);
//		return user;
//	}
	
	
	
}
