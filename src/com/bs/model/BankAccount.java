package com.bs.model;

public class BankAccount {
	private Long bankAccountId;
	private Long balance;
	private String bankName;
	private String cusId;

	public BankAccount() {

	}

	public BankAccount(Long bankAccountId, Long balance, String bankName, String cusId) {

		this.bankAccountId = bankAccountId;
		this.balance = balance;
		this.bankName = bankName;
		this.cusId = cusId;
	}

	public Long getBankAccountId() {
		return bankAccountId;
	}

	public void setBankAccountId(Long bankAccountId) {
		this.bankAccountId = bankAccountId;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCusId() {
		return cusId;
	}

	public void setCusId(String cusId) {
		this.cusId = cusId;
	}

}
