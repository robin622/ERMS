package edu.gwu.com.erms.web.request;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;

import edu.gwu.com.erms.DateUtil;
import edu.gwu.com.erms.StringUtil;
import edu.gwu.com.erms.Util;
import edu.gwu.com.erms.bean.Log;
import edu.gwu.com.erms.bean.Request;
import edu.gwu.com.erms.bean.User;
import edu.gwu.com.erms.service.RequestService;
import edu.gwu.com.erms.service.UserService;
import edu.gwu.com.erms.service.mail.ERMSSendMail;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/UpdateRequestServlet")
public class UpdateRequestServlet extends HttpServlet {
	private static Logger log = Logger.getLogger(UpdateRequestServlet.class);
	private static final long serialVersionUID = 1L;
	@Inject
	private RequestService service;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateRequestServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User user=(User) request.getSession().getAttribute("user");
		String requestId=request.getParameter("requestId");
		String hour=request.getParameter("spendtime");
		String status=request.getParameter("status");
		String comment=request.getParameter("content");
		Log log=new Log();
		log.setComment(comment);
		log.setTime(Double.parseDouble(hour));
		log.setRequestId(requestId);
		Log relog=service.updateRequest(log, Integer.parseInt(status),user);
		if(relog!=null){
			
		}
	}

}
