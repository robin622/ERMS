package edu.gwu.com.erms.service.impl;

import java.util.List;

import javax.inject.Inject;

import edu.gwu.com.erms.bean.Request;
import edu.gwu.com.erms.dao.RequestDAO;
import edu.gwu.com.erms.service.RequestService;

public class RequestServiceImpl implements RequestService{
	@Inject
	private RequestDAO requestDAO;
	public Request addRequest(Request request) {
		return requestDAO.insertRequest(request);
	}
	public List<Request> listRequests() {
		return requestDAO.listRequests();
	}
	public boolean deleteRequest(String userId) {
		return requestDAO.deleteRequest(userId);
	}
	public List<Request> listRequestsByCondition(String condition, String value) {
		return requestDAO.listRequestsByCondition(condition,value);
	}

}
