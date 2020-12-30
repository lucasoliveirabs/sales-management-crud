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
			case "EDIT":
				updateSale(request, response);
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
		int productId = Integer.parseInt(request.getParameter("productId"));
		int leadId = Integer.parseInt(request.getParameter("leadId"));
		Date saleDate = parseDate(request.getParameter("saleDate"));
		Date deliveryDate = parseDate(request.getParameter("deliveryDate"));
		String deliveryAddress = request.getParameter("deliveryAddress");
		String status = request.getParameter("status");
		String obs = request.getParameter("observation");

		Sale sale = new Sale();
		sale.setProductId(productId);
		sale.setLeadId(leadId);
		sale.setSaleDate(saleDate);
		sale.setSaleDeliveryDate(deliveryDate);
		sale.setSaleDeliveryAddress(deliveryAddress);
		sale.setSaleStatus(status);
		sale.setSaleObs(obs);

		dao.create(sale);
	}

	private void readSales(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Sale> list = dao.readAll();
		request.setAttribute("salesList", list);
		RequestDispatcher rd = request.getRequestDispatcher("/sales.jsp");
		rd.forward(request, response);
	}

	private void updateSale(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String saleId = request.getParameter("saleId");
		Sale sale = dao.readById(saleId);
		request.setAttribute("sale", sale);
		RequestDispatcher rd = request.getRequestDispatcher("/update-sale.jsp");
		rd.forward(request, response);
	}

	private Date parseDate(String inputDate) throws ParseException { // set to do not allow empty inputs
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
		Date date = (Date) df.parse(inputDate);
		return date;
	}
}