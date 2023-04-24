package com.bs.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bs.model.SchedulePlan;
import com.bs.util.DBUtil;

public class SchedulePlanDAO {
	Connection connection;
	PreparedStatement ps;
	ResultSet rs;
	
	public List<SchedulePlan> getAllSchedulePlans() {
		List<SchedulePlan> list=new ArrayList<>();
		connection=DBUtil.getConnection();
		try {
			ps=connection.prepareStatement("select * from schedule_plan");
			rs=ps.executeQuery();
			while (rs.next()) {
				list.add(new SchedulePlan(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getTimestamp(5), rs.getTimestamp(6), rs.getTimestamp(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public SchedulePlan findSchedulePlanById(long id) {
		SchedulePlan schedulePlan=null;
		connection=DBUtil.getConnection();
		try {
			ps=connection.prepareStatement("select * from schedule_plan where id=" +id);
			rs=ps.executeQuery();
			if(rs.next()) {
				schedulePlan=new SchedulePlan(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getTimestamp(5), rs.getTimestamp(6), rs.getTimestamp(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return schedulePlan;
	}
	
	public void insertSchedulePlan(SchedulePlan s) {
		connection=DBUtil.getConnection();
		try {
			ps=connection.prepareStatement("insert into schedule_plan values (?,?,?,?,?,?)");
			ps.setString(1, s.getScheduleplandetail_info());
			ps.setString(2, s.getScheduleplan_description());
			ps.setString(3, s.getScheduleplan_name());
			ps.setDate(4, (Date) s.getStartDate());
			ps.setDate(5, (Date) s.getEndDate());
			ps.setDate(6, (Date) s.getCreateDate());
			
			int res = ps.executeUpdate();
			if(res>0)
				connection.commit();
			else System.out.println("insert scheduleplan failed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean deleteSchedulePlanById(long id) {
		int status=0;	
		connection = DBUtil.getConnection();
		try {
			ps = connection.prepareStatement("delete from schedule_plan where id=" +id);
			status = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status == 0 ? false : true;
	}
	
	public void updateSchedulePlan(long id, String scheduleplandetail_info, String scheduleplan_description, String scheduleplan_name, Date startDate, Date endDate) {
		connection=DBUtil.getConnection();
		try {
			ps=connection.prepareStatement("update schedule_plan set scheduleplandetail_info=?, scheduleplan_description=?, scheduleplan_name=?, startDate=?, endDate=? where id=" +id);
			ps.setString(1, scheduleplandetail_info);
			ps.setString(2, scheduleplan_description);
			ps.setString(3, scheduleplan_name);
			ps.setDate(4, startDate);
			ps.setDate(5, endDate);
			
			ps.executeQuery();
			System.out.println("updated successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
