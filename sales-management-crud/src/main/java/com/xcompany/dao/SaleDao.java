package com.xcompany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
	public static final String SQL_READBYID = "SELECT * FROM sales WHERE sale_id=?";

	public SaleDao(DataSource ds) {
		datasource = ds;
	}

	@Override
	public void create(Sale sale) {
		Connection connection = null;
		PreparedStatement st = null;
		try {
			connection = datasource.getConnection();
			st = connection.prepareStatement(SQL_CREATE);
			st.setInt(1, sale.getProductId());
			st.setInt(2, sale.getLeadId());
			st.setObject(3, new java.sql.Timestamp(sale.getSaleDate().getTime()));
			st.setObject(4, new java.sql.Timestamp(sale.getSaleDeliveryDate().getTime()));
			st.setString(5, sale.getSaleDeliveryAddress());
			st.setString(6, sale.getSaleObs());
			st.setString(7, sale.getSaleStatus());
			Date cancelDate = sale.getSaleCancelDate();
			if (cancelDate == null) {
				st.setDate(8, null);
			} else {
				st.setObject(8, new java.sql.Timestamp(sale.getSaleCancelDate().getTime()));
			}
			st.setString(9, sale.getSaleCancelReason());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, st, null);
		}
	}

	@Override
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
				Sale sale = new Sale();
				sale.setSaleId(rs.getInt(1));
				sale.setProductId(rs.getInt(2));
				sale.setLeadId(rs.getInt(3));
				Timestamp tsSaleDate = (Timestamp) rs.getObject(4);
				sale.setSaleDate(new java.util.Date(tsSaleDate.getTime()));
				Timestamp tsDeliveryDate = (Timestamp) rs.getObject(5);
				sale.setSaleDeliveryDate(new java.util.Date(tsDeliveryDate.getTime()));
				sale.setSaleDeliveryAddress(rs.getString(6));
				sale.setSaleObs(rs.getString(7));
				sale.setSaleStatus(rs.getString(8));
				Date cancelDate = rs.getDate(9);
				if (cancelDate == null) {
					sale.setSaleCancelDate(cancelDate);
				} else {
					Timestamp tsCancelDate = (Timestamp) rs.getObject(9);
					sale.setSaleCancelDate(new java.util.Date(tsCancelDate.getTime()));
				}
				sale.setSaleCancelReason(rs.getString(10));
				list.add(sale);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, st, rs);
		}
		return list;
	}

	@Override
	public void update(Sale sale) {
		Connection connection = null;
		PreparedStatement st = null;
		try {
			connection = datasource.getConnection();
			st = connection.prepareStatement(SQL_UPDATE);
			st.setInt(1, sale.getProductId());
			st.setInt(2, sale.getLeadId());
			st.setObject(3, new java.sql.Timestamp(sale.getSaleDate().getTime()));
			st.setObject(4, new java.sql.Timestamp(sale.getSaleDeliveryDate().getTime()));
			st.setString(5, sale.getSaleDeliveryAddress());
			st.setString(6, sale.getSaleObs());
			st.setString(7, sale.getSaleStatus());
			Date cancelDate = sale.getSaleCancelDate();
			if (cancelDate == null) {
				st.setDate(8, null);
			} else {
				st.setObject(8, new java.sql.Timestamp(sale.getSaleCancelDate().getTime()));
			}
			st.setString(9, sale.getSaleCancelReason());
			st.setInt(10, sale.getSaleId());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, st, null);
		}
	}

	@Override
	public void delete(String s) {
		Connection connection = null;
		PreparedStatement st = null;
		int saleId = Integer.parseInt(s);
		try {
			connection = datasource.getConnection();
			st = connection.prepareStatement(SQL_DELETE);
			st.setInt(1, saleId);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, st, null);
		}
	}

	@Override
	public Sale readById(String s) {
		Connection connection = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int saleId = 0;
		Sale sale = null;
		try {
			connection = datasource.getConnection();
			saleId = Integer.parseInt(s);
			st = connection.prepareStatement(SQL_READBYID);
			st.setInt(1, saleId);
			rs = st.executeQuery();
			if (rs.next()) {
				sale = new Sale();
				sale.setSaleId(rs.getInt(1));
				sale.setProductId(rs.getInt(2));
				sale.setLeadId(rs.getInt(3));
				Timestamp tsSaleDate = (Timestamp) rs.getObject(4);
				sale.setSaleDate(new java.util.Date(tsSaleDate.getTime()));
				Timestamp tsDeliveryDate = (Timestamp) rs.getObject(5);
				sale.setSaleDeliveryDate(new java.util.Date(tsDeliveryDate.getTime()));
				sale.setSaleDeliveryAddress(rs.getString(6));
				sale.setSaleObs(rs.getString(7));
				sale.setSaleStatus(rs.getString(8));
				Date cancelDate = rs.getDate(9);
				if (cancelDate == null) {
					sale.setSaleCancelDate(cancelDate);
				} else {
					Timestamp tsCancelDate = (Timestamp) rs.getObject(9);
					sale.setSaleCancelDate(new java.util.Date(tsCancelDate.getTime()));
				}
				sale.setSaleCancelReason(rs.getString(10));
			} else {
				throw new Exception("Id '" + saleId + "' not found.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(connection, st, rs);
		}
		return sale;
	}
	
	@Override
	public Sale authorizeLogin(String username, String password) {
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