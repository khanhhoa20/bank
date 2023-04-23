package com.bs.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.bs.model.Manager;
import com.bs.util.DBUtil;

public interface IManagerDAO {
	static Connection connection = DBUtil.getConnection();
	abstract Manager getManagerbyId(long id);
	abstract boolean addManager(Manager manager);
	abstract boolean updateManager(Manager manager);
	abstract boolean deleteManager(Manager manager);
	abstract ArrayList<Manager> getAllManager();
}
