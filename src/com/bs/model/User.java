package com.bs.model;


/**
 * @author khanh hoa
 *
 */
public class User {
	private Long userID;
	private String userName;
	private String userPass;
	private String role;

	public User() {
		
	}

	public User(Long id, String username, String pass, String role) {

		this.userID = id;
		this.userName = username;
		this.userPass = pass;
		this.role = role;
	}

	public Long getId() {
		return userID;
	}

	public void setId(Long id) {
		this.userID = id;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}

	public String getPass() {
		return userPass;
	}

	public void setPass(String pass) {
		this.userPass = pass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

}
