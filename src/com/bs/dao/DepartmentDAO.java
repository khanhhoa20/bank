package com.bs.dao;

import java.util.*;
import com.bs.model.Department;
import com.bs.util.DBUtil;
import java.sql.PreparedStatement;
import java.sql.*;

public class DepartmentDAO {
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet; 
	
	public List<Department> getAllDepartment(){
		connection = null;
		 List<Department> departmentList = new ArrayList<Department>();
		 Department department = null;
		try {
			String sql = "SELECT * FROM department";
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				department  = new Department(resultSet.getLong(1),resultSet.getString(2));
				departmentList.add(department);
			}
		} catch (SQLException e){
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
	
	public void insertDepartment(Department department){
		connection = null;
		
		try {
			connection = DBUtil.getConnection();
			String sql = "INSERT INTO department VALUES(?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,department.getDepartmentName());
			int result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
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
	
	public void updateDepartment(Department department) {
		connection = null;

		try {
			connection = DBUtil.getConnection();
			String sql = "UPDATE department SET department_name=?  WHERE id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1,department.getDepartmentId());
			preparedStatement.setString(2,department.getDepartmentName());
			int result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
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
	
	public boolean deleteDepartment(Department department) {

		try {
			String sql ="DELETE FROM department WHERE id =?";
			connection = DBUtil.getConnection();
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate(sql);
			if (result > 0) {
				return true;
			}
		} catch (SQLException e){
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

