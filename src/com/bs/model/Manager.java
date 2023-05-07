package com.bs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="manager")
public class Manager {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long managerID;
	@Column(name="man_phone")
	private String managerPhone;
	@Column(name="man_address")
	private String managerAddress;
	@Column(name="man_email")
	private String managerEmail;
	@Column(name="man_name")
	private String managerName;
//	@OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
	@Column(name="user_id")
	private Long userId;
//	@OneToOne(targetEntity = Department.class, cascade = CascadeType.ALL)
	@Column(name="department_id")
	private Long departmentId;

	public Manager() {

	}

	public Manager(Long managerID, String managerPhone, String managerAddress, String managerEmail, String managerName,
			Long userId, Long departmentId) {

		this.managerID = managerID;
		this.managerPhone = managerPhone;
		this.managerAddress = managerAddress;
		this.managerEmail = managerEmail;
		this.managerName = managerName;
		this.userId = userId;
		this.departmentId = departmentId;
	}

	public Long getManagerID() {
		return managerID;
	}

	public void setManagerID(Long managerID) {
		this.managerID = managerID;
	}

	public String getManagerPhone() {
		return managerPhone;
	}

	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}

	public String getManagerAddress() {
		return managerAddress;
	}

	public void setManagerAddress(String managerAddress) {
		this.managerAddress = managerAddress;
	}

	public String getManagerEmail() {
		return managerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

}
