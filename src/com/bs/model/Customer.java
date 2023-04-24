package com.bs.model;

import java.util.Date;

public class Customer extends User {
	private long customerId;
	private String customerName;
	private String address;
	private String phoneNumber;
	private String email;
	private long nationalId;
	private Date dateOfBirth;
	private User user;
	
	public long getCustomerId() {
		return customerId;
	}
	public void setId(long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getNationalId() {
		return nationalId;
	}
	public void setNationalId(long nationalId) {
		this.nationalId = nationalId;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Customer() {}
	
	public Customer(long customerId, String customerName, String address, String phoneNumber, String email, long nationalId, Date dateOfBirth, User user) {
		super(user.getId(), user.getUser_name(), user.getUser_pass(), user.getRole());
		this.customerId = customerId;
		this.customerName = customerName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.nationalId = nationalId;
		this.dateOfBirth = dateOfBirth;
		this.user = user;
	}
	
	public Customer(long customerId, String customerName, String address, String phoneNumber, String email, long nationalId, Date dateOfBirth) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.nationalId = nationalId;
		this.dateOfBirth = dateOfBirth;
	}
	
}
