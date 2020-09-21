package com.pizza.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.pizza.model.Order;

public class OrderDAO {

	private static String url = "jdbc:mysql://localhost:3306/pizzahut?serverTimezone=UTC";
	private static String userName = "senura";
	private static String password = "senura";
			
	public void confirmOrder(Order order) throws ClassNotFoundException, SQLException {
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		 
	
		
		PreparedStatement ps = con.prepareStatement("insert into orderdetails(email,phoneNumber,address,paymentMethod) values(?,?,?,?)");
		
		ps.setString(1, order.getEmail());
		ps.setString(2, order.getPhoneNumber());
		ps.setString(3, order.getAddress());
		ps.setString(4, order.getPaymentMethod());


			
		ps.executeUpdate();
		
	}

	public ArrayList<Order> getOrderDetails() throws ClassNotFoundException, SQLException {
		
		ArrayList<Order> order = new ArrayList<>();
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		//create statement
		Statement stmt = con.createStatement();
		
		//execute the satement and loop over the result set
		ResultSet rs = stmt.executeQuery("select * from orderdetails ");
		
		
		while(rs.next()) {
			String orderID = rs.getString(1);
			String email = rs.getString(2);
			String phoneNumber = rs.getString(3);
			String address = rs.getString(4);
			String paymentMethod = rs.getString(5);
			String checkoutTime = rs.getString(6);
			
		
			
			Order temporder = new Order(orderID,email,phoneNumber,address,paymentMethod,checkoutTime);
			order.add(temporder);
		}
		
		return order; 
	}

	public void deleteOrder(Order order) throws ClassNotFoundException, SQLException {
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		Statement statement = con.createStatement(); 
		
		statement.executeUpdate("delete from orderdetails where orderID ='"+order.getOrderID() +"' ");
		
		
		
		
	}

}
