package com.bs.controller;

import java.util.Scanner;

import com.bs.dao.UserDAO;

/**
 * @author khánh hòa
 *
 */
public class LoginController {
	public static void login() {
		UserDAO userDAO = new UserDAO();
		System.out.println("Enter name");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.println("Enter password");
		String pass = sc.nextLine();
		String role = userDAO.login(name, pass);
		if (role != null) {
			System.out.println("Login success. Welcome " + name + ", role: " + role);
		} else {
			System.out.println("Login failed");
		}
	}
}
