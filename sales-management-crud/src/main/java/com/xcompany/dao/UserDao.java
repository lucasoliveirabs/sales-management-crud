package com.xcompany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.xcompany.model.User;

public class UserDao implements Dao<User> {

	private DataSource datasource;
	public static final String SQL_CREATE = "INSERT INTO users (user_username, user_password, user_first_name, user_last_name) VALUES (?, ?, ?, ?)";
	public static final String SQL_UPDATE = "UPDATE users SET user_username=?, user_password=?, user_first_name=?, user_last_name=? WHERE user_id=?";
	public static final String SQL_AUTHORIZELOGIN = "SELECT * FROM users WHERE user_username=? AND user_password=?";

	public UserDao(DataSource ds) {
		datasource = ds;
	}

	@Override
	public User authorizeLogin(String username, String password) {
		Connection connection = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		User user = null;
		try {
			connection = datasource.getConnection();
			st = connection.prepareStatement(SQL_AUTHORIZELOGIN);
			st.setString(1, username);
			st.setString(2, password);
			rs = st.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt(1));
				user.setUserUsername(rs.getString(2));
				user.setUserPassword(rs.getString(3));
				user.setUserFirstName(rs.getString(4));
				user.setUserLastName(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(connection, st, rs);
		}
		return user;
	}

	@Override
	public void create(User user) {
		Connection connection = null;
		PreparedStatement st = null;
		try {
			connection = datasource.getConnection();
			st = connection.prepareStatement(SQL_CREATE);
			st.setString(1, user.getUserUsername());
			st.setString(2, user.getUserPassword());
			st.setString(3, user.getUserFirstName());
			st.setString(4, user.getUserLastName());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, st, null);
		}
	}

	@Override
	public void update(User user) {
		Connection connection = null;
		PreparedStatement st = null;
		try {
			connection = datasource.getConnection();
			st = connection.prepareStatement(SQL_UPDATE);
			st.setString(1, user.getUserUsername());
			st.setString(2, user.getUserPassword());
			st.setString(3, user.getUserFirstName());
			st.setString(4, user.getUserLastName());
			st.setInt(5, user.getUserId());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, st, null);
		}
	}

	@Override
	public void delete(Integer i) {
	}

	@Override
	public User readById(String s) {
		return null;
	}

	@Override
	public List<User> readAll() {
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
