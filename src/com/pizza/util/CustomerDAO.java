package com.pizza.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.pizza.model.Customer;


public class CustomerDAO {
	
	private static String url = "jdbc:mysql://localhost:3306/pizzahut?serverTimezone=UTC";
	private static String userName = "senura";
	private static String password = "senura";

	public void insertCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		 
	
		
		PreparedStatement ps = con.prepareStatement("insert into customer(creditCartNumber,firstName,lastName,email,password,address,mobile,filename,path) values(?,?,?,?,?,?,?,?,?)");
		
		ps.setString(1, customer.getCreditCartNumber() );
		ps.setString(2, customer.getFirstName());
		ps.setString(3, customer.getLastName());
		ps.setString(4, customer.getEmail());
		ps.setString(5, customer.getPassword());
		ps.setString(6, customer.getAddress());
		ps.setString(7, customer.getMobile());
		ps.setString(8, customer.getFileName());
		ps.setString(9, customer.getPath());
			
		ps.executeUpdate();
		
		
	}

	public boolean customerLogin(Customer customer) throws ClassNotFoundException, SQLException {
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		//create statement
		Statement stmt = con.createStatement();
		
		//execute the satement and loop over the result set
		ResultSet rs = stmt.executeQuery("select * from customer where email = '"+customer.getEmail()+"' and password='"+customer.getPassword()+"' ");

		if(rs.next()) {
			
			return true;
			
		}else {
			
			return false;
		}
	}

	public ArrayList<Customer> getCustomerDetails(String Email) throws ClassNotFoundException, SQLException {
		
		ArrayList<Customer> customer = new ArrayList<>();
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		//create statement
		Statement stmt = con.createStatement();
		
		//execute the satement and loop over the result set
		ResultSet rs = stmt.executeQuery("select * from customer where email = '"+Email+"' ");
		
		
		while(rs.next()) {
			String customerID = rs.getString(1);
			String creditCartNumber = rs.getString(2);
			String firstName = rs.getString(3);
			String lastName = rs.getString(4);
			String email = rs.getString(5);
			String password = rs.getString(6);
			String address = rs.getString(7);
			String mobile = rs.getString(8);
			String fileName = rs.getString(9);
			String Path = rs.getString(10);
		
			
			Customer cus = new Customer(customerID,creditCartNumber,firstName,lastName,email,password,address,mobile,fileName,Path);
			customer.add(cus);
		}
		
		return customer; 
		
		
	}
	
	public ArrayList<Customer> getCustomerList() throws ClassNotFoundException, SQLException {
		
	ArrayList<Customer> customer = new ArrayList<>();
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		//create statement
		Statement stmt = con.createStatement();
		
		//execute the satement and loop over the result set
		ResultSet rs = stmt.executeQuery("select * from customer");
		
		
		while(rs.next()) {
			String customerID = rs.getString(1);
			String creditCartNumber = rs.getString(2);
			String firstName = rs.getString(3);
			String lastName = rs.getString(4);
			String email = rs.getString(5);
			String password = rs.getString(6);
			String address = rs.getString(7);
			String mobile = rs.getString(8);
			String fileName = rs.getString(9);
			String Path = rs.getString(10);
		
			
			Customer cus = new Customer(customerID,creditCartNumber,firstName,lastName,email,password,address,mobile,fileName,Path);
			customer.add(cus);
		}
		
		return customer; 
	}

	public void updateCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		
		
		//sql query to insert data
		PreparedStatement ps = con.prepareStatement("update customer set creditCartNumber = ?, firstName = ?, lastName = ?, password = ?, address = ?, mobile = ?  where email = ? ");
		
		ps.setString(1, customer.getCreditCartNumber());
		ps.setString(2, customer.getFirstName() );
		ps.setString(3, customer.getLastName());
		ps.setString(4, customer.getPassword());
		ps.setString(5, customer.getAddress());
		ps.setString(6, customer.getMobile());
		ps.setString(7, customer.getEmail());
		
		ps.executeUpdate();
		
		
	}

	public void deleteCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		Statement statement = con.createStatement(); 
		
		statement.executeUpdate("delete from customer where email ='"+customer.getEmail() +"' ");
		
	}



}
