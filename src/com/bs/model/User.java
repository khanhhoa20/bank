package com.bs.model;


/**
 * @author khanh hoa
 *
 */
public class User {
	private Long id;
	private String username;
	private String pass;
	private String role;

	public User() {
		
	}

	public User(Long id, String user_name, String user_pass, String role) {

		this.id = id;
		this.username = user_name;
		this.pass = user_pass;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser_name() {
		return username;
	}

	public void setUser_name(String user_name) {
		this.username = user_name;
	}

	public String getUser_pass() {
		return pass;
	}

	public void setUser_pass(String user_pass) {
		this.pass = user_pass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

}
