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
import edu.gwu.com.erms.bean.Request;
import edu.gwu.com.erms.bean.User;
import edu.gwu.com.erms.service.RequestService;
import edu.gwu.com.erms.service.UserService;
import edu.gwu.com.erms.service.mail.ERMSSendMail;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/AddRequestServlet")
public class AddRequestServlet extends HttpServlet {
	private static Logger log = Logger.getLogger(AddRequestServlet.class);
	private static final long serialVersionUID = 1L;
	@Inject
	private RequestService service;
	@Inject
	private UserService uservice;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddRequestServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		if (operation == null) {
			String requestName = request.getParameter("name");
			String content = request.getParameter("content");
			String owner = request.getParameter("owner");
			User currentUser = (User) request.getSession().getAttribute("user");
			String creator = currentUser.getName();
			String requestTime = request.getParameter("requesttime");
			String requestDatetime = request.getParameter("requestdatetime");
			String isPublic = request.getParameter("isPublic");
			String forward = request.getParameter("utv");
			String gap = request.getParameter("gap");
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			DateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			Date date = DateUtil.getLocalUTCTime();
			if (requestTime != null && !"".equals(requestTime)) {
				try {
					date = dateFormat.parse(requestTime);
					if (!StringUtil.isEmpty(requestDatetime)) {
						date = timeFormat
								.parse(new StringBuffer(requestTime)
										.append(" ").append(requestDatetime)
										.toString());
					}
					date = DateUtil.addHours(date, Integer.parseInt(gap));
				} catch (ParseException e) {
					log.error(e.getMessage(), e);
				}
			}
			Request brequest = new Request();
			brequest.setName(requestName);
			brequest.setContent(content);
			brequest.setOwner(owner);
			brequest.setCreator(creator);
			brequest.setEndtime(date);
			if (isPublic != null) {
				brequest.setIsPublic(1);
			} else {
				brequest.setIsPublic(0);
			}
			brequest.setForward(forward);
			User user=(User) request.getSession().getAttribute("user");
			Request reRequest = service.addRequest(brequest,user);
			if (reRequest!=null) {
				request.getRequestDispatcher("/ListRequestServlet").forward(
						request, response);
			} else {
				request.setAttribute("message",
						"System error, Please add a request again!");
				request.getRequestDispatcher("/addrequest.jsp").forward(request,
						response);
			}
		} else if ("init".equalsIgnoreCase(operation)) {
			List<User> list = uservice.listUsers();
			request.setAttribute("users", list);
			request.getRequestDispatcher("/jsp/addRequest.jsp").forward(
					request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
