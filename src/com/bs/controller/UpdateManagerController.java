package com.bs.controller;

import java.util.Scanner;

import com.bs.dao.ManagerDAOHibernate;
import com.bs.model.Manager;

public class UpdateManagerController {
	public static void updateManager() {
		ManagerDAOHibernate dao = new ManagerDAOHibernate();
		System.out.println("Enter manager id");
		Scanner sc = new Scanner(System.in);
		long id = Long.parseLong(sc.nextLine());
		Manager manager = dao.findById(id);
		System.out.println("Enter name");
		String name = sc.nextLine();
		System.out.println("Enter phone number");
		String phone = sc.nextLine();
		System.out.println("Enter address");
		String address = sc.nextLine();
		System.out.println("Enter email");
		String email = sc.nextLine();
		manager.setManagerName(name);
		manager.setManagerPhone(phone);
		manager.setManagerAddress(address);
		manager.setManagerEmail(email);
		dao.update(manager);
	}
}
