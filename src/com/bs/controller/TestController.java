package com.bs.controller;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;

import com.bs.dao.*;
import com.bs.model.*;
public class TestController {
	public static void main(String[] args) {
//		LoginController.login();

		SchedulePlanDepartmentDAO schedulePlanDepartmentDAO = new SchedulePlanDepartmentDAO();
		Scanner scanner = new Scanner(System.in);
		SchedulePlanDepartment schedulePlanDepartment = new SchedulePlanDepartment(7, 4);
		while(true) {
			
			System.out.println("1. insert \n 2. update \n 3. find \n 4. delete \n 5.getALL \n 6. exit");
			
			int choose = Integer.parseInt(scanner.nextLine());
			
			if(choose == 6 ) {
				return;
			}
			
			switch (choose) {
			case 1: {
				System.out.println("enter departID");
				long departID = Long.parseLong(scanner.nextLine());
				System.out.println("enter planID");
				long planID = Long.parseLong(scanner.nextLine());
				try {
					SchedulePlanDepartment item = new SchedulePlanDepartment(departID, planID);
					schedulePlanDepartmentDAO.insert(item);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			}
			case 2: {
				System.out.println("enter departID");
				long departID = Long.parseLong(scanner.nextLine());
				System.out.println("enter planID");
				long planID = Long.parseLong(scanner.nextLine());
				SchedulePlanDepartment item = new SchedulePlanDepartment(departID, planID);
				try {
					schedulePlanDepartmentDAO.update(item);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case 3: {
				System.out.println("enter departID");
				long departID = Long.parseLong(scanner.nextLine());
				System.out.println("enter planID");
				long planID = Long.parseLong(scanner.nextLine());
				SchedulePlanDepartment item = new SchedulePlanDepartment(departID, planID);

				try {
					List<SchedulePlanDepartment> list = null;
					
					list = schedulePlanDepartmentDAO.find(item.getDepartmentID(), item.getSchedulePlanID());
					
					for(SchedulePlanDepartment i: list) {
						System.out.println(i.getDepartmentID()+"----"+ i.getSchedulePlanID());
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			}
			case 4: {
				System.out.println("enter departID");
				long departID = Long.parseLong(scanner.nextLine());
				System.out.println("enter planID");
				long planID = Long.parseLong(scanner.nextLine());
				SchedulePlanDepartment item = new SchedulePlanDepartment(departID, planID);
				try {
					schedulePlanDepartmentDAO.delete(item);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			
			case 5: {
				try {
					List<SchedulePlanDepartment> lists = null;
					
					lists = schedulePlanDepartmentDAO.getAll();
					for(SchedulePlanDepartment item: lists) {
						System.out.println(item.getDepartmentID()+"----"+ item.getSchedulePlanID());
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			default:
//				throw new IllegalArgumentException("Unexpected value: " + choose);
				return;
			}
			

		}

	}
}
