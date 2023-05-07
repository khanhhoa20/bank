package com.bs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="schedule_plan_department")
public class SchedulePlanDepartment {
	@Id
	@Column(name = "department_id")
	private long departmentID;
	@Column(name="schedule_plan_id")
	private long schedulePlanID;
	public long getDepartmentID() {
		return departmentID;
	}
	public SchedulePlanDepartment(long departmentID, long schedulePlanID) {
		super();
		this.departmentID = departmentID;
		this.schedulePlanID = schedulePlanID;
	}
	
	public SchedulePlanDepartment() {
	}
	public void setDepartmentID(long departmentID) {
		this.departmentID = departmentID;
	}
	public long getSchedulePlanID() {
		return schedulePlanID;
	}
	public void setSchedulePlanID(long schedulePlanID) {
		this.schedulePlanID = schedulePlanID;
	}
}
