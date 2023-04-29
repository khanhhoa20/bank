package com.bs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bs.model.BankAccount;
import com.bs.util.DBUtil;

public class BankAccountDAO {
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	int result;

	public BankAccountDAO() {
		connection = DBUtil.getConnection();
	}

	public int createBankAccount(BankAccount bankAccount) {
		try {
			if (connection == null || connection.isClosed()) {
				connection = DBUtil.getConnection();
			}

			preparedStatement = connection.prepareStatement(IBankAccountQuery.INSERT_BANK_ACCOUNT);

			preparedStatement.setLong(1, bankAccount.getBalance());
			preparedStatement.setString(2, bankAccount.getBankName());
			preparedStatement.setLong(3, bankAccount.getCusId());
			

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
}
