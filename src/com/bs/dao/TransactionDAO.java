package com.bs.dao;

import com.bs.util.DBUtil;
import java.util.*;
import java.sql.*;

public class TransactionDAO {
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	
	public List<Transaction> getAllTransaction() {
		connection = null;
		 List<Transaction> transactionList = new ArrayList<Transaction>();
        Transaction transaction = null;
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM transaction");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				transaction  = new Transaction(	resultSet.getLong(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getDate(4), 
												resultSet.getDouble(5), resultSet.getDouble(6), resultSet.getLong(7));
				transactionList.add(transaction);
			}
		} catch (Exception e){
			System.out.println(e);
		} finally {
			if(connection!=null)
			try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
					}
			}
        return transactionList;
	}
	
	public Transaction getTransaction(long id) {
		Transaction transaction = null;
		try {
			connection = DBUtil.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM transaction WHERE id = "+id);
			if (rs.next()) {
				transaction  = new Transaction(	resultSet.getLong(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getDate(4), 
												resultSet.getDouble(5), resultSet.getDouble(6), resultSet.getLong(7));
			}
			return transaction;
		} catch (ClassNotFoundException | SQLException e){
			System.out.println(e);
		} finally {
			if(connection!=null)
			try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
					}
			}
			return transaction;
	}
	
	public void InsertTransaction(Transaction transaction) {
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO transaction values (default, ?, ?, ?, ?, ?, ?)");

			preparedStatement.setString(1, transaction.getTransaction_type());
			preparedStatement.setDouble(2, transaction.getTransaction_amount());
			preparedStatement.setDate(3, transaction.getTransaction_date());
			preparedStatement.setDouble(4, transaction.getBefore_transaction());
			preparedStatement.setDouble(5, transaction.getAfter_transaction());
			preparedStatement.setLong(6, transaction.getBank_account_id());
			
			int res = preparedStatement.executeUpdate();
			connection.commit();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			if(connection!=null)
			try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
					}
		}
	}
	
	public Boolean deleteTransaction(Long id) {
		//write your code here
		Transaction transaction = null;
		try {
			connection = DBUtil.getConnection();
			Statement statement = connection.createStatement();
			int rs = statement.executeUpdate("DELETE FROM transaction WHERE id = "+id);
			if (rs > 0) {
				return true;
			}
		} catch (ClassNotFoundException | SQLException e){
			System.out.println(e);
		} finally {
			if(connection!=null)
			try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
					}
			}
		return false;
	
	}
	
	
	
}
