package com.bs.dao;

public interface IUserQuery {
	String SELECT_QUERY = "SELECT role FROM \"user\" WHERE user_name = ? and user_pass = ?";
}
