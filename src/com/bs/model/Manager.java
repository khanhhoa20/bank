package com.bs.model;

public class Manager {
	private long id;
	private String man_phone, man_address, man_name, man_email;
	private long user_id;
	private long department_id;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 * @throws Exception 
	 */
	public void setId(long id) throws Exception {
		if(id==0)
			throw new Exception("Manager Id is left empty!");
		this.id = id;
	}
	/**
	 * @return the man_phone
	 */
	public String getMan_phone() {
		return man_phone;
	}
	/**
	 * @param man_phone the man_phone to set
	 * @throws Exception 
	 */
	public void setMan_phone(String man_phone) throws Exception {
		if(man_phone.isBlank())
			throw new Exception("Manager phone is left empty!");
		this.man_phone = man_phone;
	}
	/**
	 * @return the man_address
	 */
	public String getMan_address() {
		return man_address;
	}
	/**
	 * @param man_address the man_address to set
	 * @throws Exception 
	 */
	public void setMan_address(String man_address) throws Exception {
		if(man_address.isBlank())
			throw new Exception("Manager Address is left empty");
		this.man_address = man_address;
	}
	/**
	 * @return the man_name
	 */
	public String getMan_name() {
		return man_name;
	}
	/**
	 * @param man_name the man_name to set
	 * @throws Exception 
	 */
	public void setMan_name(String man_name) throws Exception {
		if(man_name.isBlank())
			throw new Exception("Manager name is left empty");
		this.man_name = man_name;
	}
	/**
	 * @return the man_email
	 */
	public String getMan_email() {
		return man_email;
	}
	/**
	 * @param man_email the man_email to set
	 * @throws Exception 
	 */
	public void setMan_email(String man_email) throws Exception {
		if(man_email.isBlank())
			throw new Exception("Manager email address is left empty");
		this.man_email = man_email;
	}
	/**
	 * @return the user
	 */
	public long getUser_id() {
		return user_id;
	}
	/**
	 * @param user the user to set
	 * @throws Exception 
	 */
	public void setUser_id(long user_id) throws Exception {
		if(user_id==0)
			throw new Exception("User is not found!");
		this.user_id = user_id;
	}
	/**
	 * @return the department
	 */
	public long getDepartment_id() {
		return department_id;
	}
	/**
	 * @param department the department to set
	 * @throws Exception 
	 */
	public void setDepartment_id(long department_id) throws Exception {
		if(department_id==0)
			throw new Exception("Department not found!");
		this.department_id = department_id;
	}
	public Manager(long id, String man_phone, String man_address, String man_name, String man_email, long user_id,
			long department_id) throws Exception {
		setId(id);
		setMan_address(man_address);
		setMan_email(man_email);
		setMan_name(man_name);
		setMan_phone(man_phone);
		setDepartment_id(department_id);
		setUser_id(user_id);
	}
	
	
}
