package com.bs.controller;

import java.util.Scanner;

import com.bs.dao.ManagerDAOHibernate;
import com.bs.dao.UserDAO;
import com.bs.model.Manager;

public class DeleteManagerController {
	public static void deleteManager() {
		System.out.println("Enter manager id");
		Scanner sc = new Scanner(System.in);
		long id = Long.parseLong(sc.nextLine());
		
		ManagerDAOHibernate dao = new ManagerDAOHibernate();
		UserDAO userDAO = new UserDAO();
		Manager manager = dao.findById(id);
		if (manager==null) {
			System.out.println("Cannot find manager");
		}
		else {
			dao.delete(manager);
		}
		
		System.out.println("done!");
	}
}
