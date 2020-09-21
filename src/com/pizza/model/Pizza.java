package com.pizza.model;

public class Pizza {
	
	private String pizzaID;
	
	private String name;
	
	private String description;
	
	private String price;
	
	protected String fileName;
	
	protected String Path;

	public Pizza() {
		super();
	}

	public Pizza(String pizzaID, String name, String description, String price, String fileName, String path) {
		super();
		this.pizzaID = pizzaID;
		this.name = name;
		this.description = description;
		this.price = price;
		this.fileName = fileName;
		Path = path;
	}

	public String getPizzaID() {
		return pizzaID;
	}

	public void setPizzaID(String pizzaID) {
		this.pizzaID = pizzaID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getPath() {
		return Path;
	}

	public void setPath(String path) {
		Path = path;
	}
	
	

}
