package com.bs.dao;

import java.util.*;
import java.sql.*;

public class DepartmentDAO {
	Connection connection;
	PrepareStatement preparedStatement;
	ResultSet resultSet; 
	
	public List<Department> getAllDepartment(){
		connection = null;
		 List<Department> departmentList = new ArrayList<Department>();
		 Department department = null;
		try {
			String sql = "SELECT * FROM department";
			connection = DBConnection.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				department  = new Department(resultSet.getString(1));
				departmentList.add(department);
			}
		} catch (ClassNotFoundException | SQLException e){
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(connection!=null)
			try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
					}
			}
        return departmentList;
	}
	
	public void insertDepartment(){
		connection = null;
		Department department = null;
		try {
			connection = DBConection.getConnection();
			String sql = "INSERT INTO department VALUES(?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,department.getName());
			int result = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(connection!=null)
			try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
					}
			}
	}
	
	public void updateDepartment() {
		connection = null;
		Department department = null;
		try {
			connection = DBConection.getConnection();
			String sql = "UPDATE department SET department_name=?  WHERE id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInteger(1,department.getId());
			preparedStatement.setString(2,department.getName());
			int result = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(connection!=null)
			try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
					}
			}
	}
	
	public boolean deleteDepartment() {
		Department department = null;
		try {
			String sql ="DELETE FROM department WHERE id =?";
			connection = DBConnection.getConnection();
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate(sql)
			if (result > 0) {
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

