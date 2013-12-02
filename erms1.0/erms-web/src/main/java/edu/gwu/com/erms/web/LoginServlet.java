package edu.gwu.com.erms.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.gwu.com.erms.bean.User;
import edu.gwu.com.erms.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private UserService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(null!=request.getSession().getAttribute("message")){
			request.getSession().removeAttribute("message");
		}
		String loginName=request.getParameter("loginName");
		String loginPassword=request.getParameter("loginPassword");
		String identity=request.getParameter("role");
		User user=new User();
		user.setName(loginName);
		user.setPassword(loginPassword);
		user.setStatus(Double.parseDouble(identity));
		User b=service.checkUser(user);
		if(b!=null){
			request.getSession().setAttribute("user", b);
			request.getRequestDispatcher("/jsp/home.jsp")
			.forward(request, response);
		}else{
			request.setAttribute("message","Please check your username and password");
			request.getRequestDispatcher("/index.jsp")
			.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
