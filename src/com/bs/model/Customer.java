package com.bs.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	private long id;
	@Column(name = "cus_phone")
	private String cusPhone;
	@Column(name = "cus_address")
	private String cusAddress;
	@Column (name = "cus_national_id")
	private Long cusNationalId;
	@Column(name = "cus_dob")
	private Date cusDayOfBirth;
	@Column(name = "cus_email")
	private String cusEmail;
	@Column(name = "customer_name")
	private String cusName;
	
	public Customer() {
	}
	
	public Customer(Long id, String cusPhone, String cusAddress, Long cusNationalId, Date cusDayOfBirth,
			String cusEmail, String cusName) {
	
		this.id = id;
		this.cusAddress = cusAddress;
		this.cusNationalId = cusNationalId;
		this.cusDayOfBirth = cusDayOfBirth;
		this.cusEmail = cusEmail;
		this.cusName = cusName;
//		this.user = user;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getCusPhone() {
		return cusPhone;
	}
	
	public void setCusPhone(String cusPhone) {
		this.cusPhone = cusPhone;
	}
	public String getCusAddress() {
		return cusAddress;
	}
	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}
	public Long getCusNationalId() {
		return cusNationalId;
	}
	public void setCusNationalId(Long cusNationalId) {
		this.cusNationalId = cusNationalId;
	}
	public Date getCusDayOfBirth() {
		return cusDayOfBirth;
	}
	public void setCusDayOfBirth(Date cusDayOfBirth) {
		this.cusDayOfBirth = cusDayOfBirth;
	}
	public String getCusEmail() {
		return cusEmail;
	}
	public void setCusEmail(String cusEmail) {
		this.cusEmail = cusEmail;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public BankAccount getAccount() {
		return account;
	}
	public void setAccount(BankAccount account) {
		this.account = account;
	}
	@OneToOne(cascade =  CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id")
	private User user;
	@OneToOne(mappedBy = "customer")
	private BankAccount account;
	
}
