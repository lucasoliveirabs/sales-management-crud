package com.xcompany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.xcompany.model.Lead;

public class LeadDao implements Dao<Lead> {

	private DataSource datasource;
	public static final String SQL_CREATE = "INSERT INTO leads (lead_first_name, "
			+ "lead_last_name, lead_main_channel, lead_whatsapp, lead_facebook, "
			+ "lead_instagram, lead_email) VALUES (?, ?, ?, ?, ?, ?, ?)";
	public static final String SQL_READALL = "SELECT * FROM leads ORDER BY lead_first_name";
	public static final String SQL_UPDATE = "UPDATE leads SET lead_first_name=?, "
			+ "lead_last_name=?, lead_main_channel=?, lead_whatsapp=?, lead_facebook=?, "
			+ "lead_instagram=?, lead_email=? WHERE lead_id=?";
	public static final String SQL_READBYID = "SELECT * FROM leads WHERE lead_id=?";

	public LeadDao(DataSource ds) {
		datasource = ds;
	}
	
	@Override
	public void create(Lead lead) {
		Connection connection = null;
		PreparedStatement st = null;
		try {
			connection = datasource.getConnection();
			st = connection.prepareStatement(SQL_CREATE);
			st.setString(1, lead.getLeadFirstName());
			st.setString(2, lead.getLeadLastName());
			st.setString(3, lead.getLeadMainChannel());
			st.setString(4, lead.getLeadWhatsapp());
			st.setString(5, lead.getLeadFacebook());
			st.setString(6, lead.getLeadInstagram());
			st.setString(7, lead.getLeadEmail());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, st, null);
		}
	}

	@Override
	public List<Lead> readAll() {
		Connection connection = null;
		PreparedStatement st = null;
		List<Lead> list = new ArrayList<Lead>();
		ResultSet rs = null;
		try {
			connection = datasource.getConnection();
			st = connection.prepareStatement(SQL_READALL);
			rs = st.executeQuery();
			while (rs.next()) {
				Lead lead = new Lead();
				lead.setLeadId(rs.getInt(1));
				lead.setLeadFirstName(rs.getString(2));
				lead.setLeadLastName(rs.getString(3));
				lead.setLeadMainChannel(rs.getString(4));
				lead.setLeadWhatsapp(rs.getString(5));
				lead.setLeadFacebook(rs.getString(6));
				lead.setLeadInstagram(rs.getString(7));
				lead.setLeadEmail(rs.getString(8));
				list.add(lead);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, st, rs);
		}
		return list;
	}

	@Override
	public void update(Lead lead) {
		Connection connection = null;
		PreparedStatement st = null;
		try {
			connection = datasource.getConnection();
			st = connection.prepareStatement(SQL_UPDATE);
			st.setString(1, lead.getLeadFirstName());
			st.setString(2, lead.getLeadLastName());
			st.setString(3, lead.getLeadMainChannel());
			st.setString(4, lead.getLeadWhatsapp());
			st.setString(5, lead.getLeadFacebook());
			st.setString(6, lead.getLeadInstagram());
			st.setString(7, lead.getLeadEmail());
			st.setInt(8, lead.getLeadId());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, st, null);
		}
	}	
	
	@Override
	public Lead readById(String s) {
		Connection connection = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int leadId = Integer.parseInt(s);
		Lead lead = null;
		try {
			connection = datasource.getConnection();
			st = connection.prepareStatement(SQL_READBYID);
			st.setInt(1, leadId);
			rs = st.executeQuery();
			if (rs.next()) {
				lead = new Lead();
				lead.setLeadId(rs.getInt(1));
				lead.setLeadFirstName(rs.getString(2));
				lead.setLeadLastName(rs.getString(3));
				lead.setLeadMainChannel(rs.getString(4));
				lead.setLeadWhatsapp(rs.getString(5));
				lead.setLeadFacebook(rs.getString(6));
				lead.setLeadInstagram(rs.getString(7));
				lead.setLeadEmail(rs.getString(8));
			} else {
				throw new Exception("Id '" + leadId + "' not found.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(connection, st, rs);
		}
		return lead;
	}
	
	@Override
	public void delete(String s) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public Lead authorizeLogin(String username, String password) {
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
