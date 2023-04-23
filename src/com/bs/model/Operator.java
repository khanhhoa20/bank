package com.bs.model;

public class Operator extends User {
	private int id;
	private String oper_phone;
	private String oper_address;
	private String oper_name;
	private String user_id;
	private int department_id;
	
	public Operator() {
		
	}
	
	public Operator(int id, String oper_phone, String oper_address, String oper_name, String user_id,
			int department_id) {
		super();
		this.id = id;
		this.oper_phone = oper_phone;
		this.oper_address = oper_address;
		this.oper_name = oper_name;
		this.user_id = user_id;
		this.department_id = department_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOper_phone() {
		return oper_phone;
	}
	public void setOper_phone(String oper_phone) {
		this.oper_phone = oper_phone;
	}
	public String getOper_address() {
		return oper_address;
	}
	public void setOper_address(String oper_address) {
		this.oper_address = oper_address;
	}
	public String getOper_name() {
		return oper_name;
	}
	public void setOper_name(String oper_name) {
		this.oper_name = oper_name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
}
