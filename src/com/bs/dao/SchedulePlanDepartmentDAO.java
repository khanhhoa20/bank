package com.bs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.bs.model.SchedulePlanDepartment;
import com.bs.util.DBUtil;
import java.util.*;

public class SchedulePlanDepartmentDAO {
	public boolean insert(SchedulePlanDepartment spd) throws SQLException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		boolean result = false;
		try {
			stmt = conn.prepareStatement(
					"INSERT INTO schedule_plan_department (department_id, schedule_plan_id) VALUES (?, ?)");
			stmt.setLong(1, spd.getDepartmentID());
			stmt.setLong(2, spd.getSchedulePlanID());
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
				result = true;
			}

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.print("Err insert");
		} finally {
			DBUtil.closeConnection();
		}
		return result;
	}

	public List<SchedulePlanDepartment> find(long departmentID, long schedulePlanID) throws SQLException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<SchedulePlanDepartment> list = new ArrayList<SchedulePlanDepartment>();
		try {
			stmt = conn.prepareStatement(
					"SELECT * FROM schedule_plan_department WHERE department_id = ? AND schedule_plan_id = ?");
			stmt.setLong(1, departmentID);
			stmt.setLong(2, schedulePlanID);
			rs = stmt.executeQuery();
			while (rs.next()) {
				SchedulePlanDepartment spd = new SchedulePlanDepartment();
				spd.setDepartmentID(rs.getLong("department_id"));
				spd.setSchedulePlanID(rs.getLong("schedule_plan_id"));
				list.add(spd);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.print("Err find");
		} finally {
			DBUtil.closeConnection();
		}
		return list;
	}

	public List<SchedulePlanDepartment> findByDepartmentID(long departmentID) throws SQLException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<SchedulePlanDepartment> list = new ArrayList<SchedulePlanDepartment>();
		try {
			stmt = conn.prepareStatement("SELECT * FROM schedule_plan_department WHERE department_id = ?");
			stmt.setLong(1, departmentID);
			rs = stmt.executeQuery();
			while (rs.next()) {
				SchedulePlanDepartment spd = new SchedulePlanDepartment();
				spd.setDepartmentID(rs.getLong("department_id"));
				spd.setSchedulePlanID(rs.getLong("schedule_plan_id"));
//	                spd.setDepartmentID(rs.getLong("department_id"));
				list.add(spd);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.print("Err findByDepartmentID");
		} finally {
			DBUtil.closeConnection();
		}
		return list;
	}
	
	public List<SchedulePlanDepartment> getAll() throws SQLException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<SchedulePlanDepartment> list = new ArrayList<SchedulePlanDepartment>();
		try {
			stmt = conn.prepareStatement("SELECT * FROM schedule_plan_department");
			rs = stmt.executeQuery();
			while (rs.next()) {
				SchedulePlanDepartment spd = new SchedulePlanDepartment();
				spd.setDepartmentID(rs.getLong("department_id"));
				spd.setSchedulePlanID(rs.getLong("schedule_plan_id"));
//	                spd.setDepartmentID(rs.getLong("department_id"));
				list.add(spd);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.print("Err findByDepartmentID");
		} finally {
			DBUtil.closeConnection();
		}
		return list;
	}

	public int delete(SchedulePlanDepartment spd) throws SQLException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		int rowsDeleted = 0;
		try {
			stmt = conn.prepareStatement(
					"DELETE FROM schedule_plan_department WHERE department_id = ? AND schedule_plan_id = ?");
			stmt.setLong(1, spd.getDepartmentID());
			stmt.setLong(2, spd.getSchedulePlanID());
			rowsDeleted = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.print("Err delete");
		} finally {
			DBUtil.closeConnection();
		}
		return rowsDeleted;
	}

	public int update(SchedulePlanDepartment spd) throws SQLException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		int rowsUpdated = 0;
		try {
			stmt = conn.prepareStatement(
					"UPDATE schedule_plan_department SET schedule_plan_id = ? WHERE department_id = ?");
			stmt.setLong(1, spd.getSchedulePlanID());
			stmt.setLong(2, spd.getDepartmentID());
			rowsUpdated = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.print("Err update");
		} finally {
			DBUtil.closeConnection();
		}
		return rowsUpdated;
	}
}
