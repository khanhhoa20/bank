//created by Sang
public class manager {
	private Integer id;
	private String man_phone;
	private String man_address;
	private String man_email;
	private String man_name;
	private Integer user_id;
	private Integer department_id;
	
	public manager()
	{
		
	}
	public manager(Integer id, String phone, String address, String email, String name, Integer user_id, Integer department_id)
	{
		this.id = id;
		this.man_phone = phone;
		this.man_address = address;
		this.man_email = email;
		this.man_name = name;
		this.user_id = user_id;
		this.department_id = department_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMan_phone() {
		return man_phone;
	}
	public void setMan_phone(String man_phone) {
		this.man_phone = man_phone;
	}
	public String getMan_address() {
		return man_address;
	}
	public void setMan_address(String man_address) {
		this.man_address = man_address;
	}
	public String getMan_email() {
		return man_email;
	}
	public void setMan_email(String man_email) {
		this.man_email = man_email;
	}
	public String getMan_name() {
		return man_name;
	}
	public void setMan_name(String man_name) {
		this.man_name = man_name;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}
	
	
	
}
