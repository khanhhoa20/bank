package com.bs.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "bank_account ")
public class BankAccountHibernateModel {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "bank_account_seq")
	private long id;
	private long balance;
	@Column(name = "lock_status")
	private String bankStatus;
	public String getBankStatus() {
		return bankStatus;
	}
	public void setBankStatus(String bankStatus) {
		this.bankStatus = bankStatus;
	}
	@Column(name = "bank_name")
	private String bankName;
//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "id")
//	private CustomerHibernate customer;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
//	public CustomerHibernate getCustomer() {
//		return customer;
//	}
//	public void setCustomer(CustomerHibernate customer) {
//		this.customer = customer;
//	}
	
}