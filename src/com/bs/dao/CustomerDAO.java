package com.bs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.bs.model.Customer;
import com.bs.util.DBUtil;

public class CustomerDAO {
	Connection connection;

	public CustomerDAO() {
		connection = DBUtil.getConnection();
	}

	public List<Customer> getAllCustomer() throws SQLException {
		List<Customer> customers = new ArrayList<Customer>();
		Customer customer = null;
		if (connection == null) {
			connection = DBUtil.getConnection();
		}
		String sql = "SELECT * FROM  customer";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				customer = new Customer(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getLong(4), resultSet.getTimestamp(5), resultSet.getString(6), resultSet.getString(7));
				customers.add(customer);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		return customers;
	}

	public boolean UpdateCustomer(Customer customer) throws SQLException {
		boolean a = false;
		if (connection == null) {
			connection = DBUtil.getConnection();
		}
		String sql = "UPDATE  customer c SET c.cusAddress =?, c.cusNationalId, c.cusDayOfBirth =?, c.cusEmail =?, c.cusName =? WHERE c.id=?";
		PreparedStatement preparedStatement = null;
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(sql);
			int n = preparedStatement.executeUpdate(sql);
			preparedStatement.setString(1, customer.getCusAddress());
			preparedStatement.setString(2, customer.getCusPhone());
			preparedStatement.setLong(3, customer.getCusNationalId());
			preparedStatement.setTimestamp(4, new Timestamp(customer.getCusDayOfBirth().getTime()));
			preparedStatement.setString(5, customer.getCusEmail());
			preparedStatement.setString(6, customer.getCusName());
			if (n > 0) {
				connection.commit();
				a = true;

			} else {
				connection.rollback();
				a = false;
			}

		} catch (Exception e) {
			connection.rollback();
			e.printStackTrace();
		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}

		}

		return a;
	}

	public boolean InsertCustomer(Customer customer) throws SQLException {
		boolean a = false;
		if (connection == null) {
			connection = DBUtil.getConnection();
		}
		String sql = "INSERT INTO customer c VALUES(?,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(sql);
			int n = preparedStatement.executeUpdate(sql);
			preparedStatement.setString(1, customer.getCusPhone());
			preparedStatement.setString(1, customer.getCusAddress());
			preparedStatement.setLong(2, customer.getCusNationalId());
			preparedStatement.setTimestamp(3, new Timestamp(customer.getCusDayOfBirth().getTime()));
			preparedStatement.setString(4, customer.getCusEmail());
			preparedStatement.setString(4, customer.getCusName());

			if (n > 0) {
				connection.commit();
				a = true;

			} else {
				connection.rollback();
				a = false;
			}

		} catch (Exception e) {
			connection.rollback();
			e.printStackTrace();
		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}

		}
		return a;
	}
	public Customer findById(long id) throws SQLException
	{
		Customer customer = null;
		if (connection == null) {
			connection = DBUtil.getConnection();
		}
		String sql = "SELECT * FROM  customer c where c.id=?";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				customer = new Customer(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getLong(4), resultSet.getTimestamp(5),resultSet.getString(6),resultSet.getString(7));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		return customer;
	}
}
