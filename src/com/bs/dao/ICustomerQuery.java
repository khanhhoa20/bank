package com.bs.dao;

interface ICustomerQuery {
	String INSERT_QUERY = "INSERT INTO customer VALUES(null,?,?,?,?,?,?,?)";
	String FIND_CUSTOMER = "SELECT * FROM customer WHERE cus_phone = ?";
	String GET_ALL_CUSTOMERS = "SELECT * FROM customer";
	String UPDATE_CUSTOMER = "UPDATE customer SET cus_name=?, cus_date_of_birth=?,"
			+ " cus_email=?, cus_address=? WHERE cus_phone=?";
}
