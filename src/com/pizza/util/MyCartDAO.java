package com.pizza.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.pizza.model.MyCart;


public class MyCartDAO {

	private static String url = "jdbc:mysql://localhost:3306/pizzahut?serverTimezone=UTC";
	private static String userName = "senura";
	private static String password = "senura";
	
	public void insertIntoCart(MyCart mycart) throws ClassNotFoundException, SQLException {
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		 
	
		
		PreparedStatement ps = con.prepareStatement("insert into mycart(email,pizzaID,pizzaName,price,fileName) values(?,?,?,?,?)");
		
		ps.setString(1, mycart.getEmail() );
		ps.setString(2, mycart.getPizzaID() );
		ps.setString(3, mycart.getPizzaName() );
		ps.setString(4, mycart.getPrice() );
		ps.setString(5, mycart.getFileName() );
			
		ps.executeUpdate();
		
		
	}

	public ArrayList<MyCart> getPizzaDetails(String Email) throws ClassNotFoundException, SQLException {
		
		ArrayList<MyCart> mycart = new ArrayList<>();
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		//create statement
		Statement stmt = con.createStatement();
		
		//execute the satement and loop over the result set
		ResultSet rs = stmt.executeQuery("select * from mycart where email = '"+Email+"' ");
		
		
		while(rs.next()) {
			String id = rs.getString(1);
			String email = rs.getString(2);
			String pizzaID = rs.getString(3);
			String pizzaName = rs.getString(4);
			String price = rs.getString(5);
			String fileName = rs.getString(6);
			
			
			MyCart cart = new MyCart(id,email,pizzaID,pizzaName,price,fileName);
			mycart.add(cart);
		}
		
		return mycart; 
		
	}

	public void deleteCartItem(MyCart mycart) throws ClassNotFoundException, SQLException {
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		Statement statement = con.createStatement(); 
		
		statement.executeUpdate("delete from mycart where id ='"+mycart.getId() +"' ");
		
	}

	public void checkoutMyCart(MyCart mycart) throws ClassNotFoundException, SQLException {
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		Statement statement = con.createStatement(); 
		
		statement.executeUpdate("delete from mycart where email ='"+mycart.getEmail() +"' ");
		
		
	}

}
