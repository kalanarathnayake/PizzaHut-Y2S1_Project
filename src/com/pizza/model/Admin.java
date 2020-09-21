package com.pizza.model;

public class Admin extends Person{
	
	private String adminID;

	public Admin() {
		super();
	}

	public Admin(String adminID, String firstName, String lastName, String email, String password, String address, String mobile,
			String fileName, String path) {
		super(firstName, lastName, email, password, address, mobile, fileName, path);
		this.adminID = adminID;
	}

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	
	
	

}
