package com.xcompany.controller;

import java.io.IOException;
import java.util.List;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

@WebServlet(urlPatterns = { "/home", "/SaleServlet" }, name = "SaleServlet")
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
			String command = request.getParameter("command");

			if (command == null) {
				command = "LIST";
			}

			switch (command) {
			case "ADD":
				createSale(request, response);
				break;
			case "LIST":
				readSales(request, response);
				break;			
			default:
				readSales(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	private void createSale(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Sale s = new Sale();
		s.setLeadId(Integer.parseInt(request.getParameter("productId")));
		s.setProductId(Integer.parseInt(request.getParameter("leadId")));
		s.setSaleDate(parseDate(request.getParameter("saleDate")));
		s.setSaleDeliveryDate(parseDate(request.getParameter("deliveryDate")));
		s.setSaleDeliveryAddress(request.getParameter("deliveryAddress"));
		s.setSaleObs(request.getParameter("observation"));
		dao.create(s);
	}
	
	private void readSales(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Sale> list = dao.readAll();
		request.setAttribute("salesList", list);
		RequestDispatcher rd = request.getRequestDispatcher("/sales.jsp");
		rd.forward(request, response);
	}
	
	private Date parseDate(String inputDate) throws ParseException { //set to do not allow empty inputs
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
		Date date = (Date) df.parse(inputDate); 
		return date;
	}
}