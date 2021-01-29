package com.xcompany.controller;

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

@WebFilter("/*")
public class SessionFilter implements Filter {
    public SessionFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String url = request.getRequestURI();
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user") != null || url.lastIndexOf("add-user.jsp") > -1 
				|| url.lastIndexOf("login.jsp") > -1 || url.lastIndexOf("css") > -1
				|| url.lastIndexOf("User") > -1 ) {
			
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
	        response.setHeader("Pragma", "no-cache"); 
	        response.setDateHeader("Expires", 0); 
			chain.doFilter(request, response);
			
		} else {
			response.sendRedirect("login.jsp");	
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}