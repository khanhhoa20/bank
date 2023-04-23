package com.bs.model;

public class Department {
	Integer id;
	String department_name;

	public Department(Integer id, String department_name) {

		this.id = id;
		this.department_name = department_name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return department_name;
	}

	public void setName(String department_name) {
		this.department_name = department_name;
	}

}
