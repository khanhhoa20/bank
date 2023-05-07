package com.bs.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.bs.model.SchedulePlan;
import com.bs.util.DBUtil;

public class SchedulePlanDAO_JDBC {
	Connection connection;
	PreparedStatement ps;
	ResultSet rs;
	
	//list all schedules
	public List<SchedulePlan> getAllSchedulePlans() {
		List<SchedulePlan> list=new ArrayList<>();
		connection=DBUtil.getConnection();
		try {
			ps=connection.prepareStatement("select * from schedule_plan order by id ASC");
			rs=ps.executeQuery();
			while (rs.next()) {
				list.add(new SchedulePlan(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getTimestamp(5), rs.getTimestamp(6), rs.getTimestamp(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//insert
	public void insertSchedulePlan(SchedulePlan s) {
		connection=DBUtil.getConnection();
		try {
			ps=connection.prepareStatement("insert into schedule_plan (scheduleplandetail_info, scheduleplan_description, scheduleplan_name, stardate, enddate, createdate) values (?,?,?,?,?,?)");
			ps.setString(1, s.getScheduleplandetail_info());
			ps.setString(2, s.getScheduleplan_description());
			ps.setString(3, s.getScheduleplan_name());
			ps.setTimestamp(4, new Timestamp(s.getStartDate().getTime()));
			ps.setTimestamp(5, new Timestamp(s.getEndDate().getTime()));
			ps.setTimestamp(6, new Timestamp(s.getCreateDate().getTime()));
			
			int res = ps.executeUpdate();
			if(res>0)
				connection.commit();
			else System.out.println("insert scheduleplan failed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//del
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
	
	//update
	public void updateSchedulePlan(SchedulePlan s) {
		connection=DBUtil.getConnection();
		try {
			ps=connection.prepareStatement("update schedule_plan set scheduleplandetail_info=?, scheduleplan_description=?, scheduleplan_name=?, stardate=?, enddate=? where id=" +s.getId());
			ps.setString(1, s.getScheduleplandetail_info());
			ps.setString(2, s.getScheduleplan_description());
			ps.setString(3, s.getScheduleplan_name());
			ps.setTimestamp(4, new Timestamp(s.getStartDate().getTime()));
			ps.setTimestamp(5, new Timestamp(s.getEndDate().getTime()));
//			ps.setTimestamp(6, new Timestamp(s.getCreateDate().getTime()));
			
			ps.executeQuery();
//			System.out.println("updated successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//find by id
	public SchedulePlan findSchedulePlanById(long id) {
		SchedulePlan schedulePlan = null;
		connection = DBUtil.getConnection();
		try {
			ps = connection.prepareStatement("select * from schedule_plan where id=" + id);
			rs = ps.executeQuery();
			if (rs.next())
				schedulePlan = new SchedulePlan(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getTimestamp(5), rs.getTimestamp(6), rs.getTimestamp(7));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return schedulePlan;
	}
}
