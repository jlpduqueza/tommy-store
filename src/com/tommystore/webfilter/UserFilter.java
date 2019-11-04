package com.tommystore.webfilter;

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
import javax.servlet.http.HttpSession;

import com.tommystore.constant.Role;
import com.tommystore.domain.User;

@WebFilter(urlPatterns = {"/user/*"}, description = "Session Checker Filter")
public class UserFilter implements Filter {
    
    public void destroy() {
    }

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;  
		HttpServletResponse response = (HttpServletResponse) res;  
		
		HttpSession session = request.getSession();  
		
		User user = (User) session.getAttribute("user");
		
//		if(user == null || !user.getRole().equals(Role.USER)) {
//			req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
//		}

		if(user != null && user.getRole().equals(Role.ADMIN)) {
			req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		}
		
		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}