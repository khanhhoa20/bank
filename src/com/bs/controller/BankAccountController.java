package com.bs.controller;

import java.sql.SQLException;
import java.util.List;

import com.bs.dao.BankAccountDAO;
import com.bs.model.BankAccount;

public class BankAccountController {
	public static void main(String []argv) throws SQLException
	{
 BankAccountDAO accountDAO=new BankAccountDAO();
 System.out.println("List of Bank");
 List<BankAccount> accounts;
 accounts=accountDAO.getAllBankAccount();
 for (BankAccount bankAccount : accounts) {
	System.out.println(bankAccount.getBankAccountId()+" "+ bankAccount.getBalance()+" "+bankAccount.getBankName()+" "+bankAccount.getCusId());
}
	}
}
