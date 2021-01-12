package com.xcompany.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

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
				command = "LOGOUT";
			}
			
			switch (command) {
			case "LOGIN":
				verifyLogin(request, response);
				break;
			case "ADD":
				createUser(request, response);
				break;
			case "LOGOUT":
				logout(request, response);
				break;
			case "UPDATE":
				updateUser(request, response);
				break;
			default:
				logout(request, response);
			}

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
	private void createUser(HttpServletRequest request, HttpServletResponse response)throws Exception {
		String username = request.getParameter("newUsername");
		String password = request.getParameter("confirmedNewPassword");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		User user = new User();
		user.setUserUsername(username);
		user.setUserPassword(password);
		user.setUserFirstName(firstName);
		user.setUserLastName(lastName);
		
		dao.create(user);
		response.sendRedirect("login.jsp");
	}	
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		session.invalidate();
		response.sendRedirect("login.jsp");
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int userId = Integer.parseInt(request.getParameter("userId"));
		String username = request.getParameter("newUsername");
		String password = request.getParameter("newPassword");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		User user = new User();
		user.setUserId(userId);
		user.setUserUsername(username);
		user.setUserPassword(password);
		user.setUserFirstName(firstName);
		user.setUserLastName(lastName);
		
		dao.update(user);
		response.sendRedirect("SaleServlet");
	}
	
	private void verifyLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = dao.authorizeLogin(username, password);

		if (user == null) {
			response.sendRedirect("login.jsp");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("SaleServlet");
		}
	}
}
