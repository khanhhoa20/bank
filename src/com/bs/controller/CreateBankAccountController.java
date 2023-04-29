package com.bs.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.bs.dao.BankAccountDAO;
import com.bs.dao.CustomerDAO;
import com.bs.dao.UserDAO;
import com.bs.model.BankAccount;
import com.bs.model.Customer;
import com.bs.model.User;

/**
 * @author khánh hòa
 *
 */
public class CreateBankAccountController {
	public static void createBankAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter customer name");
		String name = sc.nextLine();
		System.out.println("Enter customer phone");
		String phone = sc.nextLine();
		System.out.println("Enter customer national id");
		Long nationalID = Long.parseLong(sc.nextLine());
		System.out.println("Enter customer date of birth(dd/mm/yyyy)");
		SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		Date dob = null;
		try {
			dob = format.parse(sc.nextLine());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("Enter customer email");
		String email = sc.nextLine();
		System.out.println("Enter customer address");
		String address = sc.nextLine();


		UserDAO userDAO = new UserDAO();
		userDAO.addUser(phone, "123", "customer");

		User user = userDAO.findUser(phone);

		Customer customer = new Customer(null, name, address, phone, email, nationalID, dob, user);
		CustomerDAO customerDAO = new CustomerDAO();
		
		int result = 0;
		if (customerDAO.addCustomer(customer) > 0) {
			BankAccountDAO bankAccountDAO = new BankAccountDAO();
			Long cusID = customerDAO.findCustomerID(phone).getCustomerId();
			BankAccount bankAccount = new BankAccount(null, 0l, "bank", cusID);
			result = bankAccountDAO.createBankAccount(bankAccount);
		}
		System.out.println(result == 0 ? "create bank account fail" : "create bank account successfully");
	}
}
