package com.xcompany.controller;

import java.io.IOException;
import java.util.List;

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
			case "LIST":
				readAllSales(request, response);
				break;
			case "LOAD":
				loadSale(request, response);
				break;
			case "DELETE":
				deleteSale(request, response);
				break;
			default:
				readAllSales(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String command = request.getParameter("command");
			if (command == null) {
				readAllSales(request, response);
			}
			
			switch (command) {
			case "ADD":
				createSale(request, response);
				break;
			case "UPDATE":
				updateSale(request, response);
				break;
			default:
				readAllSales(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void createSale(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int productId = Integer.parseInt(request.getParameter("productId"));
		int leadId = Integer.parseInt(request.getParameter("leadId"));
		Date saleDate = parseStringToDate(request.getParameter("saleDate"));
		Date deliveryDate = parseStringToDate(request.getParameter("deliveryDate"));
		String deliveryAddress = request.getParameter("deliveryAddress");
		String obs = request.getParameter("observation");

		Sale sale = new Sale();
		sale.setProductId(productId);
		sale.setLeadId(leadId);
		sale.setSaleDate(saleDate);
		sale.setSaleDeliveryDate(deliveryDate);
		sale.setSaleDeliveryAddress(deliveryAddress);
		sale.setSaleStatus("N");
		sale.setSaleObs(obs);

		dao.create(sale);
		readAllSales(request, response);
	}

	private void readAllSales(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Sale> list = dao.readAll();
		request.setAttribute("salesList", list);
		RequestDispatcher rd = request.getRequestDispatcher("/sales.jsp");
		rd.forward(request, response);
	}

	private void loadSale(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String saleId = request.getParameter("saleId");
		Sale sale = dao.readById(saleId);
		String saleDate = parseDateToString(sale.getSaleDate());
		String deliveryDate = parseDateToString(sale.getSaleDeliveryDate());
		String cancelDate = parseDateToString(sale.getSaleCancelDate());
		request.setAttribute("saleDate", saleDate);
		request.setAttribute("deliveryDate", deliveryDate);
		request.setAttribute("cancelDate", cancelDate);
		request.setAttribute("sale", sale);
		RequestDispatcher rd = request.getRequestDispatcher("/update-sale.jsp");
		rd.forward(request, response);
	}

	private void updateSale(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int saleId = Integer.parseInt(request.getParameter("saleId"));
		int productId = Integer.parseInt(request.getParameter("productId"));
		int leadId = Integer.parseInt(request.getParameter("leadId"));
		Date saleDate = parseStringToDate(request.getParameter("saleDate"));
		Date deliveryDate = parseStringToDate(request.getParameter("deliveryDate"));
		String deliveryAddress = request.getParameter("deliveryAddress");
		String obs = request.getParameter("observation");
		String status = request.getParameter("status");
		Date cancelDate = parseStringToDate(request.getParameter("cancelDate"));
		String cancelReason = request.getParameter("cancelReason");

		Sale sale = new Sale();
		sale.setSaleId(saleId);
		sale.setProductId(productId);
		sale.setLeadId(leadId);
		sale.setSaleDate(saleDate);
		sale.setSaleDeliveryDate(deliveryDate);
		sale.setSaleDeliveryAddress(deliveryAddress);
		sale.setSaleStatus("N");
		sale.setSaleObs(obs);
		sale.setSaleStatus(status);
		sale.setSaleCancelDate(cancelDate);
		sale.setSaleCancelReason(cancelReason);

		dao.update(sale);
		readAllSales(request, response);
	}

	private void deleteSale(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer saleId = Integer.valueOf(request.getParameter("saleId"));
		dao.delete(saleId);
		readAllSales(request, response);
	}

	private Date parseStringToDate(String inputDate) throws ParseException {
		if (inputDate == null || inputDate.trim().isEmpty()) {
			return null;
		} else {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
			Date date = df.parse(inputDate);
			return date;
		}
	}

	private String parseDateToString(Date inputDate) throws ParseException {
		if (inputDate == null) {
			return null;
		} else {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
			String date = df.format(inputDate);
			return date;
		}
	}

}