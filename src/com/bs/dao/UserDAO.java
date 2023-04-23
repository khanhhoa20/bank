package com.bs.dao;
////////
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bs.util.DBUtil;

public class UserDAO {
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	int result;

	public UserDAO() {
		connection = DBUtil.getConnection();
	}

	public String login(String username, String password) {
		String role = null;
		try {
			if (connection == null || connection.isClosed()) {
				connection = DBUtil.getConnection();
			}
			preparedStatement = connection
					.prepareStatement(IUserQuery.SELECT_QUERY);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				role = resultSet.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
		return role;
	}
	public String addUser(String username, String password) {
		String role = null;
		try {
			if (connection == null || connection.isClosed()) {
				connection = DBUtil.getConnection();
			}
			preparedStatement = connection
					.prepareStatement(IUserQuery.SELECT_QUERY);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				role = resultSet.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
		return role;
	}
}
