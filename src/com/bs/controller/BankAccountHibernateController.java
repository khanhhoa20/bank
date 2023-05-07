package com.bs.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.bs.dao.BankAccountDaoHibernate;
import com.bs.model.*;

public class BankAccountHibernateController {
	public static void main(String[] argv) {
		Customer  customerHibernate =new Customer();
		User user = new User();
		user.setRole("aaaa");
		user.setUserID(1L);
		user.setUserName("aaa");
		user.setUserPass("2222");
		customerHibernate.setCustomerAddress("123");
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy-hh:mm:ss");
		customerHibernate.setCustomerDob(date);	
		customerHibernate.setCustomerEmail("aaaa");
		customerHibernate.setCustomerName("ccccc");
		customerHibernate.setCustomerId(1L);
		customerHibernate.setCustomerNationalId(1234567L);
		customerHibernate.setCustomerPhone("123456");
		customerHibernate.setUser(user);
		BankAccountHibernateModel accountHibernate = new BankAccountHibernateModel();
		accountHibernate.setBalance(123L);
		accountHibernate.setBankName("bbbb");
		accountHibernate.setId(1L);
		BankAccountDaoHibernate accountDaoHibernate = new BankAccountDaoHibernate();
		accountDaoHibernate.insertBankAccount(accountHibernate);
		
	}
}
