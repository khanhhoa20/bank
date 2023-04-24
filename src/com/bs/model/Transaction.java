package com.bs.model;

import java.util.*;

public class Transaction{
	private long id;
	private String transactionType;
	private double transactionAmount;
	private Date transactionDate;
	private double beforeTransaction;
	private double afterTransaction;
	private long bankAccountId;
	
	public Transaction() {
		
	}

	public Transaction(long id, String transactionType, double transactionAmount, Date transactionDate,
			double beforeTransaction, double afterTransaction, long bankAccountId) {
		super();
		this.id = id;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
		this.beforeTransaction = beforeTransaction;
		this.afterTransaction = afterTransaction;
		this.bankAccountId = bankAccountId;
	}

	public Transaction(String transactionType, double transactionAmount, Date transactionDate, double beforeTransaction,
			double afterTransaction, long bankAccountId) {
		super();
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
		this.beforeTransaction = beforeTransaction;
		this.afterTransaction = afterTransaction;
		this.bankAccountId = bankAccountId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getBeforeTransaction() {
		return beforeTransaction;
	}

	public void setBeforeTransaction(double beforeTransaction) {
		this.beforeTransaction = beforeTransaction;
	}

	public double getAfterTransaction() {
		return afterTransaction;
	}

	public void setAfterTransaction(double afterTransaction) {
		this.afterTransaction = afterTransaction;
	}

	public long getBankAccountId() {
		return bankAccountId;
	}

	public void setBankAccountId(long bankAccountId) {
		this.bankAccountId = bankAccountId;
	}
	
	
}
