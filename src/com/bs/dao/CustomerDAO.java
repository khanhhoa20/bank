package com.bs.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bs.model.Customer;
import com.bs.model.User;
import com.bs.util.DBUtil;

public class CustomerDAO {
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	int result;

	public CustomerDAO() {
		connection = DBUtil.getConnection();
	}

	public int addCustomer(Customer customer) {
		try {
			if (connection == null || connection.isClosed()) {
				connection = DBUtil.getConnection();
			}

			preparedStatement = connection.prepareStatement(ICustomerQuery.INSERT_QUERY);

			preparedStatement.setString(1, customer.getCustomerName());
			preparedStatement.setString(2, customer.getCustomerPhone());
			preparedStatement.setLong(3, customer.getCustomerNationalId());
			preparedStatement.setDate(4, new java.sql.Date(customer.getCustomerDob().getTime()));
			preparedStatement.setString(5, customer.getCustomerEmail());
			preparedStatement.setString(6, customer.getCustomerAddress());
			preparedStatement.setLong(7, customer.getUser().getUserID());
			
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	public Customer findCustomerID(String phone) {
		Customer customer = null;
		try {
			if (connection == null || connection.isClosed()) {
				connection = DBUtil.getConnection();
			}

			preparedStatement = connection.prepareStatement(ICustomerQuery.FIND_CUSTOMER);
			preparedStatement.setString(1, phone);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				customer = new Customer();
				customer.setCustomerId(resultSet.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
		return customer;
	}
}
