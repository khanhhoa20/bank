package com.bs.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.bs.dao.BankAccountDaoHibernate;
import com.bs.model.*;

public class BankAccountHibernateController {
	public static void update() {
		BankAccountDaoHibernate accountDaoHibernate = new BankAccountDaoHibernate();
		BankAccountHibernateModel accountHibernateModel = new BankAccountHibernateModel();
		int check = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Bank id to Update");
		long a = Long.parseLong(scanner.nextLine());
		accountHibernateModel = accountDaoHibernate.findAccount(a);
		if(accountHibernateModel.getBankStatus().equals("Locked"))
		{
			System.out.println("Bank Account Already Locked");	
		}
		else
		{
		System.out.println("Enter Bank Balance");
		accountHibernateModel.setBalance(Long.parseLong(scanner.nextLine()));
		System.out.println("Enter Bank Name");
		accountHibernateModel.setBankName(scanner.nextLine());
		check =  accountDaoHibernate.updateBankAccount(accountHibernateModel);
		if (check==1)
		{
			System.out.println("Update Susscess");
		}
		else if(check==2)
		{
			System.out.println("Can't find BankAccount or Bank Account doesn't exist");
		} 
		}
	}
	public static void lockAccount()
	{
		BankAccountDaoHibernate accountDaoHibernate = new BankAccountDaoHibernate();
		BankAccountHibernateModel bankAccount = new BankAccountHibernateModel();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Bank id to Lock");
		long a = Long.parseLong(scanner.nextLine());
		bankAccount = accountDaoHibernate.findAccount(a);
		if(bankAccount != null)
		{
			System.out.println("Do you want to lock "+bankAccount.getId()+" account");
			String confirm = scanner.nextLine();
			if (confirm.equals("Yes")) {
				bankAccount.setBankStatus("Locked");
				System.out.println("Lock Succsess");
				accountDaoHibernate.updateBankAccount(bankAccount);
			}
			else if (confirm.equals("No")) {
			}
			else
			{
				System.out.println("Please try again");
			}
		}
		else
		{
			System.out.println("Can't find BankAccount or Bank Account doesn't exist");
		}
		
	}
	public static void insertAccount () {
		BankAccountDaoHibernate accountDaoHibernate = new BankAccountDaoHibernate();
		BankAccountHibernateModel bankAccount = new BankAccountHibernateModel();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Bank Balance");
		bankAccount.setBalance(Long.parseLong(scanner.nextLine()));
		System.out.println("Enter Bank Name");
		bankAccount.setBankName(scanner.nextLine());
		bankAccount.setBankStatus("Not Lock");
		accountDaoHibernate.insertBankAccount(bankAccount);
	}
	
	
	public static void main(String[] argv) {
		while(true)
		{
		System.out.println("1. Insert Bank Account");
		System.out.println("2. Update Bank Account");
		System.out.println("3. Lock Bank Account");
		System.out.println("4. delete BankAccount");
		System.out.println("Enter Choice ");
		Scanner scanner = new Scanner(System.in);
		int a = Integer.parseInt(scanner.nextLine());
		switch (a) {
		case 1: 
			insertAccount();
			break;
		case 2: 
			update();
			break;
		case 3: 
			lockAccount();
			break;
		default:
			break;
		}
		}
		
	}
}
