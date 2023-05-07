package com.bs.controller;

import java.util.Scanner;

import com.bs.dao.UserDAO;

/**
 * @author khánh hòa
 *
 */
public class TestController {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int choice = 0;
		System.out.println("Login");
		String login = LoginController.login();
		if (login.equals("operator")) {
			do {
//				System.out.println("1.Login");
//				System.out.println("2.Add user");
				System.out.println("Select your chooice:");
				System.out.println("1.Create bank account");
				System.out.println("2.View customer list");
				System.out.println("3.Update customer information");
				System.out.println("4.Lock bank account");
				System.out.println("9.Test sth");
				System.out.println("10.Exit");

				choice = Integer.parseInt(sc.nextLine());

				switch (choice) {
//				case 1: {
//					LoginController.login();
//					break;
//				}
//				case 2: {
//					AddUserController.addUser();
//					break;
//				}
				case 1: {
					CreateBankAccountController.createBankAccount();
					break;
				}
				case 2: {
					ViewCustomerListController.viewCusList();
					break;
				}
				case 3: {
					UpdateCustomerController.updateCustomer();
					break;
				}
				case 4: {
					LockBankAccountController.lockBankAccount();
					break;
				}
				case 9: {
					UserDAO userDAO = new UserDAO();
					System.out.println(userDAO.findUser("hoa"));
					break;
				}
				case 10: {
					System.out.println("Exit successfully :))");
					break;
				}
				default:
					System.out.println("Wrong choice");
					break;
				}
			} while (choice != 10);
		}
	}
}
