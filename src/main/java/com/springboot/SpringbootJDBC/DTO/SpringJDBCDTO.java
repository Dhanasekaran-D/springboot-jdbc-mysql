package com.springboot.SpringbootJDBC.DTO;

public class SpringJDBCDTO {
	private Integer userid;
	private String username;
	private String email;
	private String phone;

	public SpringJDBCDTO(Integer userid, String username, String email, String phone) {
		super();
		this.userid = userid;
		this.username = username;
		this.email = email;
		this.phone = phone;
	}

	
	public SpringJDBCDTO() {
		super();
	}



	public Integer getUserid() {
		return userid;
	}



	public void setUserid(Integer userid) {
		this.userid = userid;
	}



	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
