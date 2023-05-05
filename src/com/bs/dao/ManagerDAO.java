package com.bs.dao;

import java.sql.Connection;
import java.util.List;
import com.bs.model.Manager;
import com.bs.util.DBUtil;
import java.util.*;
public class ManagerDAO
{
	Connection connection;
	
	public ManagerDAO()
	{
		connection = DBUtil.getConnection();
	}
	
	public List<Manager> insertManager(Manager manager)
	{
		List<Manager> listManager = new ArrayList<Manager>();
		
		return listManager;
	}
	
	public boolean UpdateManager(Manager manager)
	{
		return true;
	}
	
	public boolean deleteManager(Manager manager)
	{
		return true;
	}

}
