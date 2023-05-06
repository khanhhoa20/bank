package com.bs.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author quang tuan
 *
 */
@Entity
@Table(name = "schedule_plan")
public class SchedulePlan_Hibernate {
	@Id
	private long id;
	
	@Column(name = "scheduleplandetail_info")
	private String scheduleplandetail_info;
	
	@Column(name = "scheduleplan_description")
	private String scheduleplan_description;
	
	@Column(name = "scheduleplan_name")
	private String scheduleplan_name;
	
	@Column(name = "startDate")
	private Date startDate;
	
	@Column(name = "endDate")
	private Date endDate;
	
	@Column(name = "createDate")
	private Date createDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getScheduleplandetail_info() {
		return scheduleplandetail_info;
	}

	public void setScheduleplandetail_info(String scheduleplandetail_info) {
		this.scheduleplandetail_info = scheduleplandetail_info;
	}

	public String getScheduleplan_description() {
		return scheduleplan_description;
	}

	public void setScheduleplan_description(String scheduleplan_description) {
		this.scheduleplan_description = scheduleplan_description;
	}

	public String getScheduleplan_name() {
		return scheduleplan_name;
	}

	public void setScheduleplan_name(String scheduleplan_name) {
		this.scheduleplan_name = scheduleplan_name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public SchedulePlan_Hibernate(long id, String scheduleplandetail_info, String scheduleplan_description,
			String scheduleplan_name, Date startDate, Date endDate, Date createDate) {
		super();
		this.id = id;
		this.scheduleplandetail_info = scheduleplandetail_info;
		this.scheduleplan_description = scheduleplan_description;
		this.scheduleplan_name = scheduleplan_name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createDate = createDate;
	}

	public SchedulePlan_Hibernate(String scheduleplandetail_info, String scheduleplan_description,
			String scheduleplan_name, Date startDate, Date endDate, Date createDate) {
		super();
		this.scheduleplandetail_info = scheduleplandetail_info;
		this.scheduleplan_description = scheduleplan_description;
		this.scheduleplan_name = scheduleplan_name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createDate = createDate;
	}

	public SchedulePlan_Hibernate() {
		super();
	}
	
}
