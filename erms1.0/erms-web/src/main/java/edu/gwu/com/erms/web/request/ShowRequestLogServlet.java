package edu.gwu.com.erms.web.request;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import edu.gwu.com.erms.bean.Log;
import edu.gwu.com.erms.bean.Request;
import edu.gwu.com.erms.bean.User;
import edu.gwu.com.erms.service.RequestService;
import edu.gwu.com.erms.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/ShowRequestLogServlet")
public class ShowRequestLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private RequestService service;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowRequestLogServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestId=request.getParameter("requestId");
		List<Log> logs=service.listRequestlogs(requestId);
		request.setAttribute("logs", logs);
		request.getRequestDispatcher("/jsp/listRequestLog.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
