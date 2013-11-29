package edu.gwu.com.erms.web.request;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.gwu.com.erms.bean.User;
import edu.gwu.com.erms.service.RequestService;
import edu.gwu.com.erms.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/DeleteRequestServlet")
public class DeleteRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private RequestService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRequestServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestId=request.getParameter("requestId");
		User user=(User) request.getSession().getAttribute("user");
		boolean b=service.deleteRequest(requestId,user);
		if(b){
			//do nothing
		}else{
			request.setAttribute("message","Can not delete, please try later!");
		}
		request.getRequestDispatcher("/ListRequestServlet")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
