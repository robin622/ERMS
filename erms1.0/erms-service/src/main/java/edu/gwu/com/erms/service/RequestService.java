package edu.gwu.com.erms.service;

import java.util.List;

import edu.gwu.com.erms.bean.Request;
import edu.gwu.com.erms.bean.User;

public interface RequestService {
	public Boolean addRequest(Request request);
	public List<Request> listRequests();
	public boolean deleteRequest(String requestId);
}
