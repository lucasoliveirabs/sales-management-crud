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

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) request;
		HttpServletResponse response = (HttpServletResponse) response;
		HttpSession session = request.getSession(false);
		String url = httpServletRequest.getRequestURI();
		
		if(session.getAttribute("user") != null || url.lastIndexOf("login.jsp")>-1 || url.lastIndexOf("User")>-1 || url.lastIndexOf("add-user.jsp")>-1) {
			chain.doFilter(request, response);
		} else {
			((HttpServletResponse) response).sendRedirect("login.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}