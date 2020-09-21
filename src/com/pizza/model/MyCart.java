package com.pizza.model;

public class MyCart {
	
	private String id;
	
	private String email;
	
	private String pizzaID;
	
	private String pizzaName;
	
	private String price;
	
	private String fileName;

	public MyCart(String id, String email, String pizzaID, String pizzaName, String price, String fileName) {
		super();
		this.id = id;
		this.email = email;
		this.pizzaID = pizzaID;
		this.pizzaName = pizzaName;
		this.price = price;
		this.fileName = fileName;
	}



	public MyCart() {
		super();
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPizzaID() {
		return pizzaID;
	}

	public void setPizzaID(String pizzaID) {
		this.pizzaID = pizzaID;
	}

	public String getPizzaName() {
		return pizzaName;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}



	public String getFileName() {
		return fileName;
	}



	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	

}
