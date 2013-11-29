package edu.gwu.com.erms.web.user;

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
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private UserService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginName=request.getParameter("name");
		String loginPassword=request.getParameter("password");
		String email=request.getParameter("email");
		User user=new User();
		user.setName(loginName);
		user.setPassword(loginPassword);
		user.setEmail(email);
		user.setStatus(1);
		User u=service.addUser(user);
		if(u==null){
			request.setAttribute("message","System error, please try again later");
			request.getRequestDispatcher("/jsp/addUser.jsp")
			.forward(request, response);
		}else if(u.get_id()!=user.get_id()){
			request.setAttribute("message","Email is occupied, please change to another email");
			request.getRequestDispatcher("/jsp/addUser.jsp")
			.forward(request, response);
		}else{
			request.getRequestDispatcher("/ListUserServlet")
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
