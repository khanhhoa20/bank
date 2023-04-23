package com.bs.model;

public class User {
	private Integer id;
	private String user_name;
	private String user_pass;
	private String role;

	public User() {
		
	}

	public User(Integer id, String user_name, String user_pass, String role) {

		this.id = id;
		this.user_name = user_name;
		this.user_pass = user_pass;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

}
