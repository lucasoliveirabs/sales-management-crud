package com.xcompany.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.xcompany.dao.SaleDao;
import com.xcompany.model.Sale;

@WebServlet("/SaleServlet")
public class SaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SaleDao dao;

	@Resource(name = "jdbc/salescrud")
	private DataSource datasource;

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			dao = new SaleDao(datasource);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			readSales(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	private void readSales(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Sale> list = dao.readAll();
		request.setAttribute("salesList", list);
		RequestDispatcher rd = request.getRequestDispatcher("/sales.jsp");
		rd.forward(request, response);
	}

}
