package com.bs.model;

import java.util.*;

public class Transaction{
	private long id;
	private String transaction_type;
	private double transaction_amount;
	private Date transaction_date;
	private double before_transaction;
	private double after_transaction;
	private long bank_account_id;
	
	public Transaction() {
		
	}
	
	public Transaction(String transaction_type, double transaction_amount, Date transaction_date,
			double before_transaction, double after_transaction, long bank_account_id) {
		this.transaction_type = transaction_type;
		this.transaction_amount = transaction_amount;
		this.transaction_date = transaction_date;
		this.before_transaction = before_transaction;
		this.after_transaction = after_transaction;
		this.bank_account_id = bank_account_id;
	}

	public Transaction(long id, String transaction_type, double transaction_amount, Date transaction_date,
			double before_transaction, double after_transaction, long bank_account_id) {
		this.id = id;
		this.transaction_type = transaction_type;
		this.transaction_amount = transaction_amount;
		this.transaction_date = transaction_date;
		this.before_transaction = before_transaction;
		this.after_transaction = after_transaction;
		this.bank_account_id = bank_account_id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	public double getTransaction_amount() {
		return transaction_amount;
	}

	public void setTransaction_amount(double transaction_amount) {
		this.transaction_amount = transaction_amount;
	}

	public Date getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}

	public double getBefore_transaction() {
		return before_transaction;
	}

	public void setBefore_transaction(double before_transaction) {
		this.before_transaction = before_transaction;
	}

	public double getAfter_transaction() {
		return after_transaction;
	}

	public void setAfter_transaction(double after_transaction) {
		this.after_transaction = after_transaction;
	}

	public long getBank_account_id() {
		return bank_account_id;
	}

	public void setBank_account_id(long bank_account_id) {
		this.bank_account_id = bank_account_id;
	}
	
	
}
