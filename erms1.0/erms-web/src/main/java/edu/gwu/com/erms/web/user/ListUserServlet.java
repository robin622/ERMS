package edu.gwu.com.erms.web.user;

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
		String operation=request.getParameter("operation");
		List<User> list=service.listUsers();
		if(operation==null){
			request.setAttribute("userList",list);
			request.getRequestDispatcher("/jsp/listUser.jsp").forward(request, response);
		}else if("getAllOwners".equalsIgnoreCase(operation)){
			//return json data from ajax
			JSONArray array = new JSONArray();
			if(list != null && list.size() > 0){
		        for(User u : list){
		            JSONObject json = new JSONObject();
		            try {
						json.put("userEmail", u.getEmail());
					} catch (JSONException e) {
						e.printStackTrace();
					}
		            array.put(json);
		        }
		    }
			response.getWriter().print(array.toString());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
