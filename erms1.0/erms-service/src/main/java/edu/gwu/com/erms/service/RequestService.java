package edu.gwu.com.erms.service;

import java.util.List;

import net.sf.json.JSONObject;
import edu.gwu.com.erms.bean.Log;
import edu.gwu.com.erms.bean.Request;
import edu.gwu.com.erms.bean.User;

public interface RequestService {
	public Request addRequest(Request request,User user);
	public List<Request> listRequests();
	public boolean deleteRequest(String requestId,User user);
	public List<Request> listRequestsByCondition(String condition,String value);
	public Log updateRequest(Log log,int status,User user);
	public List<Log> listRequestlogs(String requestId);
	public JSONObject statisticsCount(String string);
	public List<Request> listOtherRequests(User user);
}
