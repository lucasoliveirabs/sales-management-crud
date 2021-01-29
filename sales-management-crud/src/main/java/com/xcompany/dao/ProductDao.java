package com.xcompany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.xcompany.model.Product;

public class ProductDao implements Dao<Product> {

	private DataSource datasource;
	public static final String SQL_CREATE = "INSERT INTO products (product_department, product_class, product_name) VALUES (?, ?)";
	public static final String SQL_READALL = "SELECT * FROM products ORDER BY product_department";
	public static final String SQL_UPDATE = "UPDATE products SET product_department=?, product_class=?, product_name=? WHERE product_id=?";
	public static final String SQL_READBYID = "SELECT * FROM products WHERE product_id=?";

	public ProductDao(DataSource ds) {
		datasource = ds;
	}
	
	@Override
	public void create(Product product) {
		Connection connection = null;
		PreparedStatement st = null;
		try {
			connection = datasource.getConnection();
			st = connection.prepareStatement(SQL_CREATE);
			st.setString(1, product.getProductDepartment());
			st.setString(2, product.getProductClass());
			st.setString(3, product.getProductName());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, st, null);
		}
	}

	@Override
	public List<Product> readAll() {
		Connection connection = null;
		PreparedStatement st = null;
		List<Product> list = new ArrayList<Product>();
		ResultSet rs = null;
		try {
			connection = datasource.getConnection();
			st = connection.prepareStatement(SQL_READALL);
			rs = st.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getInt(1));
				product.setProductDepartment(rs.getString(2));
				product.setProductClass(rs.getString(3));
				product.setProductName(rs.getString(4));
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, st, rs);
		}
		return list;
	}

	@Override
	public void update(Product product) {
		Connection connection = null;
		PreparedStatement st = null;
		try {
			connection = datasource.getConnection();
			st = connection.prepareStatement(SQL_UPDATE);
			st.setString(1, product.getProductDepartment());
			st.setString(2, product.getProductClass());
			st.setString(3, product.getProductName());
			st.setInt(4, product.getProductId());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, st, null);
		}
	}

	@Override
	public Product readById(String s) {
		Connection connection = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int productId = Integer.parseInt(s);
		Product product = null;
		try {
			connection = datasource.getConnection();
			st = connection.prepareStatement(SQL_READBYID);
			st.setInt(1, productId);
			rs = st.executeQuery();
			if (rs.next()) {
				product = new Product();
				product.setProductId(rs.getInt(1));
				product.setProductDepartment(rs.getString(2));
				product.setProductClass(rs.getString(3));
				product.setProductName(rs.getString(2));
			} else {
				throw new Exception("Id '" + productId + "' not found.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(connection, st, rs);
		}
		return product;
	}

	@Override
	public void delete(String s) {
		// TODO Auto-generated method stub
	}

	@Override
	public Product authorizeLogin(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	private void close(Connection connection, PreparedStatement st, ResultSet rs) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Connection closing failure");
			}
			connection = null;
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Statement closing failure");
			}
			st = null;
		}

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("ResultSet closing failure");
			}
			rs = null;
		}
	}
}
