package edu.gwu.com.erms.web;

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

import edu.gwu.com.erms.bean.Request;
import edu.gwu.com.erms.bean.User;
import edu.gwu.com.erms.service.RequestService;
import edu.gwu.com.erms.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/ListRequestServlet")
public class ListRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private RequestService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListRequestServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Request> list= null;
		User user=(User) request.getSession().getAttribute("user");
		String who=request.getParameter("who");
		if("tome".equalsIgnoreCase(who)){
			list=service.listRequestsByCondition("owner",user.getEmail());
		}else if("fromme".equalsIgnoreCase(who)){
			list=service.listRequestsByCondition("creator",user.getName());
		}else if("others".equalsIgnoreCase(who)){
			
		}else{
			list=service.listRequests();
		}
		request.setAttribute("requestList",list);
		request.getRequestDispatcher("/jsp/listRequest.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
