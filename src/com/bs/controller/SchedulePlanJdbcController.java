package com.bs.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.bs.dao.SchedulePlanDAO_JDBC;
import com.bs.model.SchedulePlan;

public class SchedulePlanJdbcController {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException, ParseException {
		Logger log = Logger.getLogger("org.hibernate");
    	log.setLevel(Level.OFF);
    	System.setProperty("org.apache.commons.logging.Log","org.apache.commons.logging.impl.NoOpLog");
   		
   		long id;
   		String detail, description, name;
   		Date startDate, endDate;
   		
   		//get current-date
   		Date createDate = Date.from((LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
   		
   		SchedulePlanDAO_JDBC schedulePlanDAO_JDBC=new SchedulePlanDAO_JDBC();
   		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
   		do {
   			System.out.println("Menu_JDBC:");
			System.out.println("1.Add a schedule_plan");
			System.out.println("2.Delete a schedule_plan");
			System.out.println("3.Update a schedule_plan");
			System.out.println("4.List schedule_plans");
			System.out.println("5.Find a schedule by id");
			System.out.println("6.Exit");
			System.out.println("Enter choice");
			try {
			    switch (Integer.parseInt(br.readLine())) {
			    case 1:
			    	System.out.println("Enter name");
			    	name=br.readLine();
			    	System.out.println("Enter description");
			    	description=br.readLine();
			    	System.out.println("Enter detail info");
			    	detail=br.readLine();
			    	System.out.println("Enter start_date (dd/MM/yyyy)");
			    	startDate = sdf.parse(br.readLine());
			    	System.out.println("Enter end_date (dd/MM/yyyy)");
			    	endDate = sdf.parse(br.readLine());
//				System.out.println("Enter create_date (dd/MM/yyyy)");
//				createDate = sdf.parse(br.readLine());
			    	
			    	SchedulePlan newS=new SchedulePlan(detail, description, name, startDate, endDate, createDate);
			    	schedulePlanDAO_JDBC.insertSchedulePlan(newS);
			    	break;
			    case 2:
			    	System.out.println("Enter schedule_plan id");
			    	id=Long.parseLong(br.readLine());
			    	SchedulePlan sc = schedulePlanDAO_JDBC.findSchedulePlanById(id);
			    	if(sc==null) {
			    		System.out.println("schedule_plan not found");
			    		break;
			    	}
			    	schedulePlanDAO_JDBC.deleteSchedulePlanById(id);
			    	break;
			    case 3:
			    	System.out.println("Enter schedule_plan id");
			    	id=Long.parseLong(br.readLine());
			    	SchedulePlan findSchedule = schedulePlanDAO_JDBC.findSchedulePlanById(id);
			    	if(findSchedule==null) {
			    		System.out.println("schedule_plan not found");
			    		break;
			    	}
			    	System.out.println("Enter name");
			    	name=br.readLine();
			    	System.out.println("Enter description");
			    	description=br.readLine();
			    	System.out.println("Enter detail info");
			    	detail=br.readLine();
			    	System.out.println("Enter start_date (dd/MM/yyyy)");
			    	startDate = sdf.parse(br.readLine());
			    	System.out.println("Enter end_date (dd/MM/yyyy)");
			    	endDate = sdf.parse(br.readLine());
//				System.out.println("Enter create_date (dd/MM/yyyy)");
//				createDate = sdf.parse(br.readLine());
			    	
			    	SchedulePlan schedule = new SchedulePlan(id, detail, description, name, startDate, endDate, findSchedule.getCreateDate());
			    	schedulePlanDAO_JDBC.updateSchedulePlan(schedule);
			    	break;
			    case 4:
			    	List<SchedulePlan> list = schedulePlanDAO_JDBC.getAllSchedulePlans();
			    	if(list.isEmpty()) {
			    		System.out.println("No schedule_plan found");
			    		break;
			    	}
			    	System.out.printf("%-20s %-15s %-25s %-20s %-15s %-15s %s\n","SchedulePlan_id","Name","Description","Details","Start-Date", "End-Date", "Initial-Date");
			    	for(Object o : list) {
			    		SchedulePlan s=(SchedulePlan) o;
			    		System.out.printf("%-20s %-15s %-25s %-20s %-15s %-15s %s\n", s.getId(), s.getScheduleplan_name(), s.getScheduleplan_description(), s.getScheduleplandetail_info(), sdf.format(s.getStartDate()), sdf.format(s.getEndDate()), sdf.format(s.getCreateDate()));
			    	}
			    	break;
			    case 5:
			    	System.out.println("Enter schedule_plan id");
			    	id=Long.parseLong(br.readLine());
			    	SchedulePlan findS = schedulePlanDAO_JDBC.findSchedulePlanById(id);
			    	if(findS==null) {
			    		System.out.println("schedule_plan not found");
			    		break;
			    	}
			    	System.out.printf("%-20s %-15s %-25s %-20s %-15s %-15s %s\n","SchedulePlan_id","Name","Description","Details","Start-Date", "End-Date", "Initial-Date");
			    	System.out.printf("%-20s %-15s %-25s %-20s %-15s %-15s %s\n", findS.getId(), findS.getScheduleplan_name(), findS.getScheduleplan_description(), findS.getScheduleplandetail_info(), sdf.format(findS.getStartDate()), sdf.format(findS.getEndDate()), sdf.format(findS.getCreateDate()));
			    	break;
			    case 6:
			    	System.exit(0);
			    default:
			    	System.out.println("Invalid choice");
			    }
			} catch (NumberFormatException e) {
			    System.out.println("Please enter a number!");
			}
			
		} while (true);
	}

}
