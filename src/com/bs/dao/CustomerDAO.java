package com.bs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bs.model.Customer;
import com.bs.util.DBUtil;

public class CustomerDAO {
	Connection connection = null;
	PreparedStatement st;
	ResultSet rs;
	
	public ArrayList<Customer> getAllCustomer(){
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		if (connection==null) {
			connection = DBUtil.getConnection();
		}
		try {
			st = connection.prepareStatement("SELECT * FROM customer");
			rs = st.executeQuery();
			while(rs.next()) {
				customerList.add(new Customer(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getLong(6), rs.getTimestamp(7)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (connection!=null) {
			try {
				rs.close();
				st.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return customerList;
	}
	
	public void createCustomer(Customer customer) {
		if (connection == null) {
			connection = DBUtil.getConnection();
		}
		try {
			st = connection.prepareStatement("INSERT INTO customer(cus_name, cus_phone, cus_national_id, cus_date_of_birth, cus_email, cus_address, user_id) VALUES(?,?,?,?,?,?,?)");
			st.setString(1, customer.getCustomerName());
			st.setString(2, customer.getPhoneNumber());
			st.setLong(3, customer.getCustomerId());
			st.setTimestamp(4, new java.sql.Timestamp(customer.getDateOfBirth().getTime()));
			st.setString(5, customer.getEmail());
			st.setString(6, customer.getAddress());
			st.setLong(7, customer.getUser().getId());
			int result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (connection!=null) {
			try {
				st.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void updateCustomerById(Customer customer) {
		if (connection == null) {
			connection = DBUtil.getConnection();
		}
		try {
			st = connection.prepareStatement("UPDATE customer SET cus_name=?, cus_phone=?, cus_national_id=?, cus_date_of_birth=?, cus_email=?, cus_address=? WHERE id = ?");
			st.setString(1, customer.getCustomerName());
			st.setString(2, customer.getPhoneNumber());
			st.setLong(3, customer.getNationalId());
			st.setTime(4, new java.sql.Time(customer.getDateOfBirth().getTime()));
			st.setString(5, customer.getEmail());
			st.setString(6, customer.getAddress());
			st.setLong(7, customer.getId());
			int result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (connection!=null) {
			try {
				st.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
