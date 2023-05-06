package com.bs.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bs.model.*;
import com.bs.util.DBUtil;

public class ManagerDAO_JDBC {
	
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	
	public List<Manager> getAllManager() {
		connection = null;
		List<Manager> managerList = new ArrayList<Manager>();
        Manager manager = null;
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM manager");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				manager  = new Manager(	resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), 
												resultSet.getString(5), resultSet.getLong(6), resultSet.getLong(7));
				managerList.add(manager);
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
        return managerList;
	}
	
	public Manager getManager(long id) {
		Manager manager = null;
		try {
			connection = DBUtil.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM manager WHERE id = "+id);
			if (rs.next()) {
				manager  = new Manager(	resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), 
						resultSet.getString(5), resultSet.getLong(6), resultSet.getLong(7));
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
		return manager;
	}
	
	public void insertManager(Manager manager) {
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO manager VALUES (DEFAULT, ?, ?, ?, ?, ?, ?)");

			preparedStatement.setString(1, manager.getManagerPhone());
			preparedStatement.setString(2, manager.getManagerAddress());
			preparedStatement.setString(3, manager.getManagerEmail());
			preparedStatement.setString(4, manager.getManagerName());
			preparedStatement.setLong(5, manager.getUserId());
			preparedStatement.setLong(6, manager.getDepartmentId());
			
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
	
	public void updateManager(Manager manager){

		try {		
			connection = DBUtil.getConnection();
			Statement statement=connection.createStatement();	
			
			int rs = statement.executeUpdate(	"UPDATE manager SET man_phone = "+manager.getManagerPhone()+
												", man_address = "+manager.getManagerAddress()+
												", man_email = "+manager.getManagerEmail()+
												", man_name = "+manager.getManagerName()+
												" where id = "+manager.getManagerID());
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
	
	public Boolean deleteManager(Long id) {

		try {
			connection = DBUtil.getConnection();
			Statement statement = connection.createStatement();
			int rs = statement.executeUpdate("DELETE FROM manager WHERE id = "+id);
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
