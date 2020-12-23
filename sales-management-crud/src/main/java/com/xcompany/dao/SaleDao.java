package com.xcompany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.xcompany.model.Sale;

public class SaleDao implements Dao<Sale> {

	private DataSource datasource;
	public static final String SQL_CREATE = "INSERT INTO sales (product_id, lead_id, sale_date, sale_delivery_date,"
			+ " sale_delivery_adress, sale_observation, sale_status, sale_cancel_date, sale_cancel_reason)"
			+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String SQL_READALL = "SELECT * FROM sales ORDER BY sale_date DESC";
	public static final String SQL_UPDATE = "UPDATE sales SET product_id=?, lead_id=?, sale_date=?, sale_delivery_date=?,"
			+ "sale_delivery_adress=?, sale_observation=?, sale_status=?, sale_cancel_date=?, sale_cancel_reason=?"
			+ "WHERE sale_id=?";
	public static final String SQL_DELETE = "DELETE FROM sales WHERE sale_id=?";

	public SaleDao(DataSource ds) {
		datasource = ds;
	}

	public void create(Sale sale) {
		Connection connection = null;
		PreparedStatement st = null;
		try {
			connection = datasource.getConnection();
			st = connection.prepareStatement(SQL_CREATE);
			st.setInt(1, sale.getProductId());
			st.setInt(2, sale.getLeadId());
			st.setDate(3, new java.sql.Date(sale.getSaleDate().getTime()));
			st.setDate(4, new java.sql.Date(sale.getSaleDeliveryDate().getTime()));
			st.setString(5, sale.getSaleDeliveryAddress());
			st.setString(6, sale.getSaleObs());
			st.setString(7, sale.getSaleStatus());
			st.setDate(8, new java.sql.Date(sale.getSaleCancelDate().getTime()));
			st.setString(9, sale.getSaleCancelReason());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, st);
		}
	}

	public List<Sale> readAll() {
		Connection connection = null;
		PreparedStatement st = null;
		List<Sale> list = new ArrayList<Sale>();
		ResultSet rs = null;
		try {
			connection = datasource.getConnection();
			st = connection.prepareStatement(SQL_READALL);
			rs = st.executeQuery();
			while (rs.next()) {
				Sale s = new Sale();
				s.setSaleId(rs.getInt(1));
				s.setProductId(rs.getInt(2));
				s.setLeadId(rs.getInt(3));
				s.setSaleDate(rs.getDate(4));
				s.setSaleDeliveryDate(new java.util.Date(rs.getDate(5).getTime()));
				s.setSaleDeliveryAddress(rs.getString(6));
				s.setSaleObs(rs.getString(7));
				s.setSaleStatus(rs.getString(8));
				Date cancelDate = rs.getDate(9);
				if (cancelDate == null) {
					s.setSaleCancelDate(cancelDate);
				} else {
					s.setSaleCancelDate(new java.util.Date(cancelDate.getTime()));
				}
				s.setSaleCancelReason(rs.getString(10));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, st, rs);
		}
		return list;
	}

	public void update(Sale sale) {
		Connection connection = null;
		PreparedStatement st = null;
		try {
			connection = datasource.getConnection();
			st = connection.prepareStatement(SQL_UPDATE);
			st.setInt(1, sale.getProductId());
			st.setInt(2, sale.getLeadId());
			st.setDate(3, new java.sql.Date(sale.getSaleDate().getTime()));
			st.setDate(4, new java.sql.Date(sale.getSaleDeliveryDate().getTime()));
			st.setString(5, sale.getSaleDeliveryAddress());
			st.setString(6, sale.getSaleObs());
			st.setString(7, sale.getSaleStatus());
			st.setDate(8, new java.sql.Date(sale.getSaleCancelDate().getTime()));
			st.setString(9, sale.getSaleCancelReason());
			st.setInt(10, sale.getSaleId());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, st);
		}
	}

	public void delete(Integer i) {
		Connection connection = null;
		PreparedStatement st = null;
		try {
			connection = datasource.getConnection();
			st = connection.prepareStatement(SQL_DELETE);
			st.setInt(1, i.intValue());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, st);
		}
	}

	private void close(Connection connection, PreparedStatement st) {
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
