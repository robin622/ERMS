package edu.gwu.com.erms.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.bson.types.ObjectId;

import edu.gwu.com.erms.bean.Log;
import edu.gwu.com.erms.bean.Request;
import edu.gwu.com.erms.bean.User;
import edu.gwu.com.erms.dao.RequestDAO;
import edu.gwu.com.erms.dao.RequestLogDAO;
import edu.gwu.com.erms.service.RequestService;
import edu.gwu.com.erms.service.mail.ERMSSendMail;

public class RequestServiceImpl implements RequestService{
	@Inject
	private RequestDAO requestDAO;
	@Inject
	private RequestLogDAO requestLogDAO;
	@Inject
	private ERMSSendMail mailer;
	
	public Request addRequest(Request request,User user) {
		Request reRequest=requestDAO.insertRequest(request);
		//send mail
		mailer.sendEmail(reRequest,user,"add",null);
		return reRequest;
	}
	
	public List<Request> listRequests() {
		return requestDAO.listRequests();
	}
	
	public boolean deleteRequest(String requestId,User user) {
		Boolean b=requestDAO.deleteRequest(requestId);
		Request request=requestDAO.listRequestById(requestId);
		//send mail
		mailer.sendEmail(request,user,"delete",null);
		return b;
	}
	
	public List<Request> listRequestsByCondition(String condition, String value) {
		return requestDAO.listRequestsByCondition(condition,value);
	}
	
	public Log updateRequest(Log log,int status,User user) {
		//1, update log
		Log relog=requestLogDAO.insertRequestLog(log);
		//2, update status of request
		Request request=requestDAO.updateRequestStatus(log.getRequestId(), status);
		//3, send email
		mailer.sendEmail(request,user,"update",log);
		return relog;
	}
	
	public List<Log> listRequestlogs(String requestId) {
		 List<Log> logs=new ArrayList<Log>();
		 return requestLogDAO.listRequestLog(requestId);
	}

}
