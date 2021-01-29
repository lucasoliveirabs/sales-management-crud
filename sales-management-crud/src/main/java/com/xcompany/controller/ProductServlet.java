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

import com.xcompany.dao.ProductDao;
import com.xcompany.model.Product;

@WebServlet(urlPatterns = "/ProductServlet", name = "ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductDao dao;
	@Resource(name = "jdbc/salescrud")
	private DataSource datasource;

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			dao = new ProductDao(datasource);
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
				readAllProducts(request, response);
				break;
			case "LOAD":
				loadProduct(request, response);
				break;
			default:
				readAllProducts(request, response);
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
				readAllProducts(request, response);
			}
			
			switch (command) {
			case "ADD":
				createProduct(request, response);
				break;
			case "UPDATE":
				updateProduct(request, response);
				break;
			default:
				readAllProducts(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void createProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String productDepartment = request.getParameter("productDepartment");
		String productClass = request.getParameter("productClass");
		String productName = request.getParameter("productName");
		
		Product product = new Product();
		product.setProductDepartment(productDepartment);
		product.setProductClass(productClass);
		product.setProductName(productName);
		
		dao.create(product);
		readAllProducts(request, response);
	}
	
	private void readAllProducts(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Product> list = dao.readAll();
		request.setAttribute("productList", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/products.jsp");
		rd.forward(request, response);
	}
	
	private void loadProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String productId = request.getParameter("productId");
		Product product = dao.readById(productId);
		request.setAttribute("product", product);
	
		RequestDispatcher rd = request.getRequestDispatcher("/update-product.jsp");
		rd.forward(request, response);
	}
	
	private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int productId = Integer.parseInt(request.getParameter("productId"));
		String productDepartment = request.getParameter("productDepartment");
		String productClass = request.getParameter("productClass"); 
		String productName = request.getParameter("productName");
		
		Product product = new Product();
		product.setProductId(productId);
		product.setProductDepartment(productDepartment);
		product.setProductClass(productClass);
		product.setProductName(productName);
		
		dao.update(product);
		readAllProducts(request, response);
	}
}
