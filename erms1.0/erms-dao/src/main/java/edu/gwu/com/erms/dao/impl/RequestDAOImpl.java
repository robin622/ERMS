package edu.gwu.com.erms.dao.impl;


import java.util.ArrayList;
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
import edu.gwu.com.erms.dao.RequestDAO;

public class RequestDAOImpl implements RequestDAO{
	private Connection connection;
	public DBCollection getTable(){
		DBCollection table = connection.getConnection().getCollection("request");
		return table;
	}
	public RequestDAOImpl() {
		connection = Connection.getInstance();
	}
	
	public Request insertRequest(Request request){
		DBCollection table=getTable();
		BasicDBObject document = new BasicDBObject();
		document.put("name", request.getName());
		document.put("content", request.getContent());
		document.put("owner", request.getOwner());
		document.put("creator",request.getCreator());
		document.put("createtime",DateUtil.getLocalUTCTime());
		document.put("endtime",request.getEndtime());
		document.put("isPublic",request.getIsPublic());
		document.put("forward", request.getForward());
		document.put("status",1);
		table.insert(document);
		DBCursor cur=table.find(document);
		while(cur.hasNext()){
			DBObject obj=cur.next();
			return (Request) Util.converter(obj,Request.class);
		}
		return null;
	}
	
	public List<Request> listRequestsByCondition(String condition, Object value) {
		List<Request> requests=new ArrayList<Request>();
		DBCollection table=getTable();
		DBObject query=new QueryBuilder().put("status").notEquals(0).put(condition).is(value).get();
		DBCursor cursor=table.find(query);
		while(cursor.hasNext()){
			DBObject dbo=cursor.next();
			Request request=(Request)Util.converter(dbo,Request.class);
			requests.add(request);
		}
		return requests;
	}
	
	public Request listRequestById(String id) {
		Request request=null;
		DBCollection table=getTable();
		BasicDBObject document =new BasicDBObject("_id",new ObjectId(id));
		DBCursor cursor=table.find(document);
		while(cursor.hasNext()){
			DBObject dbo=cursor.next();
			request=(Request)Util.converter(dbo,Request.class);
		}
		return request;
	}
	
	public List<Request> listRequests() {
		List<Request> requests=new ArrayList<Request>();
		DBCollection table=getTable();
		DBObject query=new QueryBuilder().put("status").notEquals(0).get();
		DBCursor cursor=table.find(query);
		while(cursor.hasNext()){
			DBObject dbo=cursor.next();
			Request request=(Request)Util.converter(dbo,Request.class);
//			//invoke user to get true name
//			DBCollection user=connection.getConnection().getCollection("user");
//			BasicDBObject document =new BasicDBObject("_id",new ObjectId(request.getOwner()));
//			DBCursor cur=user.find(document);
//			while(cur.hasNext()){
//				DBObject udbo=cur.next();
//				User userEntity=(User)Util.converter(udbo,User.class);
//				request.setOwner(userEntity.getName());
//			}
			requests.add(request);
		}
		return requests;
	}
	
	//delete a user by user's id --> change the status of this request
	public boolean deleteRequest(String requestId) {
		DBCollection table=getTable();
		BasicDBObject conditionDocument =new BasicDBObject("_id",new ObjectId(requestId));
		BasicDBObject updateDocument =new BasicDBObject("$set",new BasicDBObject("status",0));
		table.update(conditionDocument,updateDocument,false,false);
		DBCursor cur=table.find(conditionDocument);
		Request request=null;
		while(cur.hasNext()){
			DBObject dbo=cur.next();
			request=(Request)Util.converter(dbo,Request.class);
		}
		if(request==null||request.getStatus()!=0){
			return false;
		}
		return true;
	}
	
	//update status
	public Request updateRequestStatus(String requestId, int status) {
		DBCollection table=getTable();
		BasicDBObject conditionDocument =new BasicDBObject("_id",new ObjectId(requestId));
		BasicDBObject updateDocument =new BasicDBObject("$set",new BasicDBObject("status",status));
		table.update(conditionDocument,updateDocument,false,false);
		DBCursor cur=table.find(conditionDocument);
		Request request=null;
		while(cur.hasNext()){
			DBObject dbo=cur.next();
			request=(Request)Util.converter(dbo,Request.class);
		}
		if(request==null||request.getStatus()!=status){
			return null;
		}
		return request;
	}
	public List<Request> listOtherRequests(String email, String name) {
		List<Request> requests=new ArrayList<Request>();
		DBCollection table=getTable();
		DBObject query=new QueryBuilder().put("status").notEquals(0).put("owner").notEquals(email)
				.put("creator").notEquals(name).put("isPublic").is(1).get();
		DBCursor cursor=table.find(query);
		while(cursor.hasNext()){
			DBObject dbo=cursor.next();
			Request request=(Request)Util.converter(dbo,Request.class);
			requests.add(request);
		}
		return requests;
	}
}
