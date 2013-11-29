package edu.gwu.com.erms.dao;

import java.util.List;

import edu.gwu.com.erms.bean.Request;
import edu.gwu.com.erms.bean.User;

public interface RequestDAO {
	public Request insertRequest(Request request);
	public List<Request> listRequests();
	public boolean deleteRequest(String requestId);
	public List<Request> listRequestsByCondition(String condition, Object value);
	public Request listRequestById(String id);
	public Request updateRequestStatus(String requestiId,int status);
}
