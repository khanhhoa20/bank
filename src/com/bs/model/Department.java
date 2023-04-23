package com.bs.model;

public class Department {
	long id;
	String department_name;

	public Department(long id, String department_name) {

		this.id = id;
		this.department_name = department_name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return department_name;
	}

	public void setName(String department_name) {
		this.department_name = department_name;
	}

}
