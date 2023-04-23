package com.bs.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.bs.util.DBUtil;
public class BankAccountDAO {
	Connection connection;
public BankAccountDAO() {
	connection = DBUtil.getConnection();
}
}
