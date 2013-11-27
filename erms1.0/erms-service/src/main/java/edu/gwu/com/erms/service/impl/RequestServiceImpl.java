package edu.gwu.com.erms.service.impl;

import java.util.List;

import javax.inject.Inject;

import edu.gwu.com.erms.bean.Request;
import edu.gwu.com.erms.bean.User;
import edu.gwu.com.erms.dao.RequestDAO;
import edu.gwu.com.erms.dao.UserDAO;
import edu.gwu.com.erms.dao.impl.UserDAOImpl;
import edu.gwu.com.erms.service.RequestService;
import edu.gwu.com.erms.service.UserService;

public class RequestServiceImpl implements RequestService{
	@Inject
	private RequestDAO requestDAO;
	public Boolean addRequest(Request request) {
		return requestDAO.insertRequest(request);
	}
	public List<Request> listRequests() {
		return requestDAO.listRequests();
	}
	public boolean deleteRequest(String userId) {
		return requestDAO.deleteRequest(userId);
	}

}
