package com.pizza.model;

public class Customer extends Person{

	private String customerID;
	
	private String creditCartNumber;

	public Customer() {
		super();
	}

	

	public Customer(String customerID, String creditCartNumber, String firstName, String lastName, String email, String password, String address, String mobile,
			String fileName, String path) {
		super(firstName, lastName, email, password, address, mobile, fileName, path);
		this.customerID = customerID; 
		this.creditCartNumber = creditCartNumber;
	}



	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}



	public String getCreditCartNumber() {
		return creditCartNumber;
	}



	public void setCreditCartNumber(String creditCartNumber) {
		this.creditCartNumber = creditCartNumber;
	}
	
	
	
	
}
