package com.bs.controller;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;

import com.bs.dao.*;
import com.bs.model.*;
public class TestController {
	public static void main(String[] args) {
//		LoginController.login();
		SchedulePlanDepartmentDAO schedulePlanDepartmentDAO = new SchedulePlanDepartmentDAO();
		Scanner scanner = new Scanner(System.in);
		SchedulePlanDepartment schedulePlanDepartment = new SchedulePlanDepartment(1, 2);
		while(true) {
			
			System.out.println("1. insert \n 2. update \n 3. find \n 4. delete \n 5.getALL \n 6. exit");
			
			int choose = Integer.parseInt(scanner.nextLine());
			
			if(choose == 5 ) {
				return;
			}
			
			switch (choose) {
			case 1: {
				try {
					schedulePlanDepartmentDAO.insert(schedulePlanDepartment);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			case 2: {
				try {
					schedulePlanDepartmentDAO.update(schedulePlanDepartment);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			case 3: {
				try {
					schedulePlanDepartmentDAO.find(schedulePlanDepartment.getDepartmentID(), schedulePlanDepartment.getSchedulePlanID());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			case 4: {
				try {
					schedulePlanDepartmentDAO.delete(schedulePlanDepartment);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			case 5: {
				try {
					schedulePlanDepartmentDAO.getAll();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choose);
			}
			

		}
	}
}
