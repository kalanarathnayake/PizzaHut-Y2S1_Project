package com.pizza.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.pizza.model.Pizza;

public class PizzaDAO {
	
	private static String url = "jdbc:mysql://localhost:3306/pizzahut?serverTimezone=UTC";
	private static String userName = "senura";
	private static String password = "senura";

	public void insertPizza(Pizza pizza) throws ClassNotFoundException, SQLException {
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		 
	
		
		PreparedStatement ps = con.prepareStatement("insert into pizza (name,description,price,fileName,path) values(?,?,?,?,?)");
		
		ps.setString(1, pizza.getName() );
		ps.setString(2, pizza.getDescription());
		ps.setString(3, pizza.getPrice());
		ps.setString(4, pizza.getFileName());
		ps.setString(5, pizza.getPath());
	
			
		ps.executeUpdate();
		
	}

	public ArrayList<Pizza> getPizzaList() throws ClassNotFoundException, SQLException {
		
	ArrayList<Pizza> pizza = new ArrayList<>();
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		//create statement
		Statement stmt = con.createStatement();
		
		//execute the satement and loop over the result set
		ResultSet rs = stmt.executeQuery("select * from pizza ");
		
		
		while(rs.next()) {
			String pizzaID = rs.getString(1);
			String name = rs.getString(2);
			String description = rs.getString(3);
			String price = rs.getString(4);
			String fileName = rs.getString(5);
			String path = rs.getString(6);
			
			
			Pizza food = new Pizza(pizzaID,name,description,price,fileName,path);
			pizza.add(food);
		}
		
		return pizza; 
	}

	public ArrayList<Pizza> getPizzaDetails(String PizzaID) throws ClassNotFoundException, SQLException {
		
	ArrayList<Pizza> pizza = new ArrayList<>();
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		//create statement
		Statement stmt = con.createStatement();
		
		//execute the satement and loop over the result set
		ResultSet rs = stmt.executeQuery("select * from pizza where pizzaID = '"+PizzaID+"' ");
		
		
		while(rs.next()) {
			String pizzaID = rs.getString(1);
			String name = rs.getString(2);
			String description = rs.getString(3);
			String price = rs.getString(4);
			String fileName = rs.getString(5);
			String path = rs.getString(6);
			
			
			Pizza food = new Pizza(pizzaID,name,description,price,fileName,path);
			pizza.add(food);
		}
		
		return pizza; 
	}

	public void deletePizzaByAdmin(Pizza pizza) throws ClassNotFoundException, SQLException {
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		Statement statement = con.createStatement(); 
		
		statement.executeUpdate("delete from pizza where pizzaID ='"+pizza.getPizzaID() +"' ");
		
		
		
	}

	public void updatePizzaDetails(Pizza pizza) throws ClassNotFoundException, SQLException {
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
				
		
		//sql query to insert data
		PreparedStatement ps = con.prepareStatement("update pizza set name = ?, description = ?, price = ?  where pizzaID = ? ");
		
		ps.setString(1, pizza.getName());
		ps.setString(2, pizza.getDescription());
		ps.setString(3, pizza.getPrice());
		ps.setString(4, pizza.getPizzaID());

		ps.executeUpdate();
		
		
	}

}
