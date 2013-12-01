package edu.gwu.com.erms.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import edu.gwu.com.erms.bean.Log;
import edu.gwu.com.erms.bean.Request;

public interface RequestLogDAO {
	public Log insertRequestLog(Log log);
	public List<Log> listRequestLog(String requestId);
	public List<Log> listUsersByDay(Date start, Date end);
}
