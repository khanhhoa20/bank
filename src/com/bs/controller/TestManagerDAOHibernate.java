package com.bs.controller;

import java.util.Scanner;

import com.bs.dao.ManagerDAOHibernate;
import com.bs.model.Manager;

public class TestManagerDAOHibernate {
	public static void main(String[] args) {
		ManagerDAOHibernate dao = new ManagerDAOHibernate();
		Scanner sc = new Scanner(System.in);
//		ManagerDAO_JDBC jdbc = new ManagerDAO_JDBC();
		while(true) {
			System.out.println("1. insert \n 2. update \n 3. find \n 4. delete \n 5.getALL \n 6. exit");
			int choose = Integer.parseInt(sc.nextLine());
			
			switch (choose) {
			case 1:
				AddManagerController.addManager();
				break;
			case 2:
				UpdateManagerController.updateManager();
				break;
			case 3:
				System.out.println("Enter manager id");
				Manager manager = dao.findById(sc.nextLong());
				if (manager==null) {
					System.out.println("Cannot find manager");
					continue;
				}
				else {
					System.out.printf("%-5s %-15s %-10s %-10s %-10s\n", "ID", "Name", "PhoneNumber", "Address", "Email");
					System.out.printf("%-5s %-15s %-10s %-10s %-10s\n",manager.getManagerID(), manager.getManagerName(), manager.getManagerPhone(), manager.getManagerAddress(), manager.getManagerEmail());
				}
				break;
			case 4:
				DeleteManagerController.deleteManager();
				break;
			case 5:
				ListAllManager.listManager();
				break;
			case 6:
				System.exit(0);
			default:
				break;
			}
		}
		
	}
}
