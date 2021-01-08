package com.xcompany.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.xcompany.dao.SaleDao;
import com.xcompany.dao.UserDao;
import com.xcompany.model.User;

@WebServlet(urlPatterns = "/User", name = "User")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao dao;
	@Resource(name = "jdbc/salescrud")
	private DataSource datasource;

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			dao = new UserDao(datasource);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String command = request.getParameter("command");
			if (command == null) {
				response.sendRedirect("login.jsp");
			}
			
			switch (command) {
			case "LOGIN":
				verifyLogin(request, response);
			}
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void verifyLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = dao.authorizeLogin(username, password);

		if (user == null) {
			response.sendRedirect("login.jsp");
		} else {
			
			response.sendRedirect("SaleServlet");
		}
	}

}
