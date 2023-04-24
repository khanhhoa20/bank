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

	public User(Long id, String username, String pass, String role) {

		this.id = id;
		this.username = username;
		this.pass = pass;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

}
