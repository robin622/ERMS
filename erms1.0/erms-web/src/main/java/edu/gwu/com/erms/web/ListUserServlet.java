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

import edu.gwu.com.erms.bean.User;
import edu.gwu.com.erms.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/ListUserServlet")
public class ListUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private UserService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListUserServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> list=service.listUsers();
		if(list.size()>0){
			
		}
		request.getRequestDispatcher("/jsp/listUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
