package com.bs.model;

public class Operator extends User {
	private Integer id;
	private String operPhone;
	private String operAddress;
	private String operName;
	private String userId;
	private Integer departmentId;
	
	public Operator() {
		
	}

	
	
	public Operator(Integer id, String operPhone, String operAddress, String operName, String userId,
			Integer departmentId) {
		super();
		this.id = id;
		this.operPhone = operPhone;
		this.operAddress = operAddress;
		this.operName = operName;
		this.userId = userId;
		this.departmentId = departmentId;
	}



	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOperPhone() {
		return operPhone;
	}

	public void setOperPhone(String operPhone) {
		this.operPhone = operPhone;
	}

	public String getOperAddress() {
		return operAddress;
	}

	public void setOperAddress(String operAddress) {
		this.operAddress = operAddress;
	}

	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	
	
}
