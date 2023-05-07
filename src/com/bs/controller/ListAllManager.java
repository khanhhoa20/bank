package com.bs.controller;

import com.bs.dao.ManagerDAOHibernate;

public class ListAllManager {
	public static void listManager() {
		ManagerDAOHibernate dao = new ManagerDAOHibernate();
		System.out.printf("%-5s %-15s %-10s %-10s %-10s\n", "ID", "Name", "PhoneNumber", "Address", "Email");
		dao.list().stream().forEach(manager->System.out.printf("%-5s %-15s %-10s %-10s %-10s\n",manager.getManagerID(), manager.getManagerName(), manager.getManagerPhone(), manager.getManagerAddress(), manager.getManagerEmail()));
	}
}
