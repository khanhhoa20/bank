package com.bs.dao;

interface ICustomerQuery {
	String INSERT_QUERY = "INSERT INTO customer VALUES(null,?,?,?,?,?,?,?)";
	String FIND_CUSTOMER = "SELECT * FROM customer WHERE cus_phone = ?";
}
