package com.bs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bs.model.BankAccount;
import com.bs.util.DBUtil;

public class BankAccountDAO {
	Connection connection;

	public BankAccountDAO() {
		connection = DBUtil.getConnection();
	}

	public List<BankAccount> getAllBankAccount() throws SQLException {
		List<BankAccount> accounts = new ArrayList<BankAccount>();
		BankAccount account = null;
		if (connection == null) {
			connection = DBUtil.getConnection();
		}
		String sql = "SELECT * FROM  bank_account";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				account = new BankAccount(resultSet.getLong(1), resultSet.getLong(2), resultSet.getString(3),
						resultSet.getLong(4));
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

	public boolean UpdateBankAccount(BankAccount account) throws SQLException {
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
			preparedStatement.setLong(3, account.getBankAccountId());
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

	public boolean InsertBankAccount(BankAccount account) throws SQLException {
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
			preparedStatement.setLong(1, account.getBankAccountId());
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
	public BankAccount findById(long id) throws SQLException
	{
		BankAccount account = null;
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
				account = new BankAccount(resultSet.getLong(1), resultSet.getLong(2), resultSet.getString(3),
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
