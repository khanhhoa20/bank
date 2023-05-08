package com.bs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		List<Customer> accounts = new ArrayList<Customer>();
		Customer account = null;
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
				account = new Customer(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5), resultSet.getLong(5), resultSet.getDate(5), user);
				accounts.add(account);
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
		return accounts;
	}

	public boolean UpdateCustomer(Customer account) throws SQLException {
		boolean a = false;
		if (connection == null) {
			connection = DBUtil.getConnection();
		}
		String sql = "UPDATE  bank_account b SET b.bank_name =?, b.balance=? WHERE b.id=?";
		PreparedStatement preparedStatement = null;
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(sql);
			int n = preparedStatement.executeUpdate(sql);
			preparedStatement.setString(1, account.getBankName());
			preparedStatement.setLong(2, account.getBalance());
			preparedStatement.setLong(3, account.getCustomerId());
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

	public boolean InsertCustomer(Customer account) throws SQLException {
		boolean a = false;
		if (connection == null) {
			connection = DBUtil.getConnection();
		}
		String sql = "INSERT INTO bank_account b VALUES(?,?,?,?)";
		PreparedStatement preparedStatement = null;
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(sql);
			int n = preparedStatement.executeUpdate(sql);
			preparedStatement.setLong(1, account.getCustomerId());
			preparedStatement.setLong(2, account.getBalance());
			preparedStatement.setString(3, account.getBankName());
			preparedStatement.setLong(4, account.getCusId());

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
		Customer account = null;
		if (connection == null) {
			connection = DBUtil.getConnection();
		}
		String sql = "SELECT * FROM  bank_account b where b.id=?";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				account = new Customer(resultSet.getLong(1), resultSet.getLong(2), resultSet.getString(3),
						resultSet.getLong(4));
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
		return account;
	}
}
