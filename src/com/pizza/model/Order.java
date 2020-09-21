package com.pizza.model;

public class Order {
	
	private String orderID;
	
	private String email;
	
	private String phoneNumber;
	
	private String address;
	
	private String paymentMethod;
	
	private String checkoutTime;
	
	

	public Order() {
		super();
	}



	public Order(String orderID, String email, String phoneNumber, String address, 
			String paymentMethod, String checkoutTime) {
		super();
		this.orderID = orderID;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.paymentMethod = paymentMethod;
		this.checkoutTime = checkoutTime;
	}


	

	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getOrderID() {
		return orderID;
	}



	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPaymentMethod() {
		return paymentMethod;
	}



	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}



	public String getCheckoutTime() {
		return checkoutTime;
	}



	public void setCheckoutTime(String checkoutTime) {
		this.checkoutTime = checkoutTime;
	}
	
	

}
