package edu.gwu.com.erms.web.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.gwu.com.erms.bean.User;

@WebFilter(urlPatterns = { "/AddRequestServlet", "/AddUserServlet", "/DeleteUserServlet",
		"/ListRequestServlet", "/ListUserServlet","/UpdateRequestServlet","/ShowRequestLogServlet"})
public class SessionFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rsp = (HttpServletResponse) response;
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            if ("".equals(user)) {
                rsp.sendRedirect("/");
                return;
            }
        }
        chain.doFilter(req, response);
    }

    public void destroy() {

    }

}