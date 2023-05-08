package com.bs.dao;

/**
 * @author khánh hòa
 *
 */
interface IBankAccountQuery {
	String INSERT_BANK_ACCOUNT = "INSERT INTO bank_account VALUES(null,?,?,?)";
	String WITHDRAW_MONEY = "UPDATE bank_account SET balance=? WHERE cus_id ="
			+ " (SELECT id FROM customer WHERE cus_phone=?)";
	String GET_BALANCE = "SELECT balance FROM bank_account WHERE cus_id ="
			+ "	(SELECT id FROM customer WHERE cus_phone=?)";
}
