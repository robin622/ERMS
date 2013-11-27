package edu.gwu.com.erms.service;

import java.util.List;

import edu.gwu.com.erms.bean.Request;

public interface RequestService {
	public Request addRequest(Request request);
	public List<Request> listRequests();
	public boolean deleteRequest(String requestId);
	public List<Request> listRequestsByCondition(String condition,String value);
}
