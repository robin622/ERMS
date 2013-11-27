package edu.gwu.com.erms.dao;

import java.util.List;

import edu.gwu.com.erms.bean.Request;
import edu.gwu.com.erms.bean.User;

public interface RequestDAO {
	public boolean insertRequest(Request request);
	public List<Request> listRequests();
	public boolean deleteRequest(String requestId);
}
