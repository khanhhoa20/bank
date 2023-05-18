package com.bs.dao;

/**
 * @author khánh hòa
 *
 */
public interface IUserQuery {
	String SELECT_QUERY = "SELECT role FROM \"user\" WHERE user_name = ? and user_pass = ?";
	String INSERT_QUERY = "INSERT INTO \"user\" VALUES (null,?,?,?)";
	String FIND_USER = "SELECT * from \"user\" WHERE user_name=?";
}
