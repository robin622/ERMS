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
	
	public boolean insertRequest(Request request){
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
		table.insert(document);
		DBCursor cur=table.find(document);
		while(cur.hasNext()){
			return true;
		}
		return false;
	}
	
	public List<Request> listRequests() {
		List<Request> requests=new ArrayList<Request>();
		DBCollection table=getTable();
		DBObject query=new QueryBuilder().get();
		DBCursor cursor=table.find(query);
		while(cursor.hasNext()){
			DBObject dbo=cursor.next();
			Request request=(Request)Util.converter(dbo,Request.class);
			//invoke user to get true name
			DBCollection user=connection.getConnection().getCollection("user");
			BasicDBObject document =new BasicDBObject("_id",new ObjectId(request.getOwner()));
			DBCursor cur=user.find(document);
			while(cur.hasNext()){
				DBObject udbo=cur.next();
				User userEntity=(User)Util.converter(udbo,User.class);
				request.setOwner(userEntity.getName());
			}
			requests.add(request);
		}
		return requests;
	}
	
	//delete a user by user's id
	public boolean deleteRequest(String requestId) {
//		DBCollection table=getTable();
//		BasicDBObject document =new BasicDBObject("_id",new ObjectId(userId));
//		table.remove(document);
//		DBCursor cur=table.find(document);
//		while(cur.hasNext()){
//			return false;
//		}
//		return true;
		return true;
	}
}
