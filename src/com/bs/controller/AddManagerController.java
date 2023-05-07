package com.bs.controller;

import java.util.Scanner;

import com.bs.dao.ManagerDAOHibernate;
import com.bs.dao.UserDAO;
import com.bs.model.Manager;
import com.bs.model.User;

public class AddManagerController {
	public static void addManager() {
		ManagerDAOHibernate dao = new ManagerDAOHibernate();
		UserDAO userDAO = new UserDAO();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter username");
		String username = sc.nextLine();
		
		System.out.println("Enter manager name");
		String name = sc.nextLine();
		
		System.out.println("enter password");
		String password = sc.nextLine();
		
		System.out.println("Enter role");
		String role = sc.nextLine();
		
		boolean result = userDAO.addUser(username, password, role);
		User user = new User();
		user.setUserName(username);
		user.setRole(role);
		user.setUserPass(password);
		
		
		System.out.println("Enter manager phone number");
		String phone = sc.nextLine();
		
		System.out.println("Enter address");
		String address = sc.nextLine();
		
		System.out.println("Enter email");
		String email = sc.nextLine();
		
		User user1 = userDAO.findUser(username);
		System.out.println(user1.getUserID());
		
		Manager manager = new Manager();
		manager.setManagerName(name);
		manager.setManagerPhone(phone);
		manager.setManagerAddress(address);
		manager.setManagerEmail(email);
		manager.setUserId(user1.getUserID());
		
		dao.insert(manager);
		System.out.println("done");
	}
}
