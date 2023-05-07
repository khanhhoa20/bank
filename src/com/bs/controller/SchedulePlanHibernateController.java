package com.bs.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;

import com.bs.dao.SchedulePlanDAO_Hibernate;
import com.bs.model.SchedulePlan;

public class SchedulePlanHibernateController {
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
   		
   		SchedulePlanDAO_Hibernate schedulePlanDAO_Hibernate=new SchedulePlanDAO_Hibernate();
   		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
   		do {
   			System.out.println("Menu_Hibernate:");
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
//					System.out.println("Enter create_date (dd/MM/yyyy)");
//					createDate = sdf.parse(br.readLine());
					
					SchedulePlan newS=new SchedulePlan(detail, description, name, startDate, endDate, createDate);
					schedulePlanDAO_Hibernate.insertSchedulePlan(newS);
					break;
				case 2:
					System.out.println("Enter schedule_plan id");
					id=Long.parseLong(br.readLine());
					SchedulePlan sc = schedulePlanDAO_Hibernate.findById(id);
					if(sc==null) {
						System.out.println("schedule_plan not found");
						break;
					}
					schedulePlanDAO_Hibernate.deleteSchedulePlan(sc);
					break;
				case 3:
					System.out.println("Enter schedule_plan id");
					id=Long.parseLong(br.readLine());
					SchedulePlan findSchedule = schedulePlanDAO_Hibernate.findById(id);
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
//					System.out.println("Enter create_date (dd/MM/yyyy)");
//					createDate = sdf.parse(br.readLine());
					
//					findSchedule = new SchedulePlan(detail, description, name, startDate, endDate, createDate);
					SchedulePlan sch=new SchedulePlan(id, detail, description, name, startDate, endDate, findSchedule.getCreateDate());
					schedulePlanDAO_Hibernate.updateSchedulePlan(sch);
					break;
				case 4:
					List<SchedulePlan> list = schedulePlanDAO_Hibernate.listAllSchedulePlan();
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
					SchedulePlan findS = schedulePlanDAO_Hibernate.findById(id);
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
