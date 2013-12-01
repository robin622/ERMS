package edu.gwu.com.erms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import net.sf.json.JSONObject;

import org.bson.types.ObjectId;

import edu.gwu.com.erms.DateUtil;
import edu.gwu.com.erms.bean.Log;
import edu.gwu.com.erms.bean.Request;
import edu.gwu.com.erms.bean.User;
import edu.gwu.com.erms.dao.RequestDAO;
import edu.gwu.com.erms.dao.RequestLogDAO;
import edu.gwu.com.erms.dao.UserDAO;
import edu.gwu.com.erms.service.RequestService;
import edu.gwu.com.erms.service.mail.ERMSSendMail;

public class RequestServiceImpl implements RequestService{
	@Inject
	private RequestDAO requestDAO;
	@Inject
	private RequestLogDAO requestLogDAO;
	@Inject
	private UserDAO userDAO;
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

	public JSONObject statisticsCount(String type) {
		String dateValue="";
		Date start=null;
		Date end=null;
		StringBuffer sb=new StringBuffer("[");
		JSONObject json = new JSONObject();
		String dateType[]=null;
		if("day".equalsIgnoreCase(type)){
			start=DateUtil.getTodayTime();
			end=DateUtil.getNextDayTime();
		}else if("week".equalsIgnoreCase(type)){
			start=DateUtil.getFirstDayofThisWeek();
			end=DateUtil.getEndDayofThisWeek();
		}else if("month".equalsIgnoreCase(type)){
			start=DateUtil.getFirstDayofThisMonth();
			end=DateUtil.getEndDayofThisMonth();
		}
		List<Log> logs=requestLogDAO.listUsersByDay(start,end);
		Set<String> requestIds=new HashSet<String>();
		for(int k=0;k<logs.size();k++){
			requestIds.add(logs.get(k).getRequestId());
		}
		int size=requestIds.size();
		dateType=new String[size];
		if(size>0){
			Iterator<String> iter=requestIds.iterator();
			int i=0;
			while(iter.hasNext()){
				String requestid=iter.next();
				Request request=requestDAO.listRequestById(requestid);
				dateType[i]=userDAO.checkUserNameByEmail(request.getOwner());
				sb.append("{name:'").append(request.getName()).append("',data:[")
				.append(getDateValue(requestid,i,size,logs)).append("]},");
				i++;
			}
		}
		//String str="[{name:'john',data:[1,2,3,4,5]},{name:'rose',data:[4,5,6,7,8]}]";
		sb.append("]");
		json.put("resultRequest", sb.toString());
		json.put("dateType", dateType);
		return json;
	}

	private String getDateValue(String requestid, int i, int size,List<Log> logs) {
		StringBuffer sb=new StringBuffer();
		Double sum=0.0;
		for(int n=0;n<logs.size();n++){
			Log log=logs.get(n);
			if(requestid.equals(log.getRequestId())){
				sum+=log.getTime();
			}
		}
		for(int j=0;j<size;j++){
			if(j!=size){
				if(j==i){
					sb.append(sum);
				}else{
					sb.append("0");
				}
				sb.append(",");
			}
		}
		return sb.toString();
	}
	
	
	/*
	 * {
            name: 'John',
            data: [0, 3, 4, 7, 2]
        }, {
            name: 'Jane',
            data: [2, 2, 3, 2, 1]
        }, {
            name: 'Joe',
            data: [3, 4, 4, 2, 5]
        }
	 */

}
