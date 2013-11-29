package edu.gwu.com.erms.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.QueryBuilder;

import edu.gwu.com.erms.DateUtil;
import edu.gwu.com.erms.Util;
import edu.gwu.com.erms.bean.Log;
import edu.gwu.com.erms.bean.Request;
import edu.gwu.com.erms.dao.Connection;
import edu.gwu.com.erms.dao.RequestLogDAO;

public class RequestLogDAOImpl implements RequestLogDAO {
	private Connection connection;
	
	public DBCollection getTable(){
		DBCollection table = connection.getConnection().getCollection("log");
		return table;
	}
	
	public RequestLogDAOImpl() {
		connection = Connection.getInstance();
	}
	
	public Log insertRequestLog(Log log) {
		DBCollection table=getTable();
		BasicDBObject document = new BasicDBObject();
		document.put("requestId", log.getRequestId());
		document.put("time", log.getTime());
		document.put("comment", log.getComment());
		document.put("createdate", DateUtil.getLocalUTCTime());
		table.insert(document);
		DBCursor cur=table.find(document);
		while(cur.hasNext()){
			DBObject obj=cur.next();
			return (Log) Util.converter(obj,Log.class);
		}
		return null;
	}

	public List<Log> listRequestLog(String requestId) {
		List<Log> logs=new ArrayList<Log>();
		DBCollection table=getTable();
		DBObject query=new QueryBuilder().put("requestId").is(requestId).get();
		DBCursor cursor=table.find(query);
		while(cursor.hasNext()){
			DBObject dbo=cursor.next();
			Log log=(Log)Util.converter(dbo,Log.class);
			logs.add(log);
		}
		return logs;
	}

}
