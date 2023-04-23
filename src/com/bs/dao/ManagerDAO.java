package com.bs.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bs.model.Manager;

public class ManagerDAO implements IManagerDAO{
	UserDAO ud = new UserDAO();
	DepartmentDAO dp = new DepartmentDAO();

	@Override
	public Manager getManagerbyId(long id) {
		Manager manager = null;
		try {
			PreparedStatement stm = connection.prepareStatement("select * from manager where id = "+id);
			ResultSet rs = stm.executeQuery();
			if(rs.next())
				manager = new Manager(id, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), ud.findUserByID(rs.getLong(6)), dp.getDepartmentByID(rs.getLong(7)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manager;
	}

	@Override
	public boolean addManager(Manager manager) {
		for (Manager managerInlst : getAllManager()) {
			if(manager.getId() == managerInlst.getId())
				return false;
		}
		try {
			PreparedStatement stm = connection.prepareStatement("insert into manager(man_address, man_email, man_name, man_phone, user_id, department_id) values(?,?,?,?,?,?)");
			stm.setString(1, manager.getMan_address());
			stm.setString(2, manager.getMan_email());
			stm.setString(3, manager.getMan_name());
			stm.setString(4, manager.getMan_phone());
			stm.setLong(5, manager.getUser().getId());
			stm.setLong(6, manager.getDepartment().getId());
			int res = stm.executeUpdate();
			if(res>0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateManager(Manager manager) {
		try {
			PreparedStatement stm = connection.prepareStatement("update manager set man_address = ?, man_email = ?, man_name = ?, man_phone = ?, user_id = ?, department_id = ? where id = "+manager.getId());
			stm.setString(1, manager.getMan_address());
			stm.setString(2, manager.getMan_email());
			stm.setString(3, manager.getMan_name());
			stm.setString(4, manager.getMan_phone());
			stm.setLong(5, manager.getUser().getId());
			stm.setLong(6, manager.getDepartment().getId());
			int res = stm.executeUpdate();
			if(res>0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteManager(Manager manager) {
		try {
			PreparedStatement stm = connection.prepareStatement("delete from manager where id = "+manager.getId());
			int res = stm.executeUpdate();
			if(res>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Manager> getAllManager() {
		ArrayList<Manager> mnglst = new ArrayList<Manager>();
		try {
			PreparedStatement stm = connection.prepareStatement("select * from manager");
			ResultSet rs = stm.executeQuery();
			while(rs.next())
				mnglst.add(new Manager(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), ud.findUserByID(rs.getLong(6)), dp.getDepartmentByID(rs.getLong(7))));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mnglst;
	}

}
