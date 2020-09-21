package com.pizza.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.pizza.model.Admin;


public class AdminDAO {
	
	private static String url = "jdbc:mysql://localhost:3306/pizzahut?serverTimezone=UTC";
	private static String userName = "senura";
	private static String password = "senura";

	public boolean adminLogin(Admin admin) throws ClassNotFoundException, SQLException {
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		//create statement
		Statement stmt = con.createStatement();
		
		//execute the satement and loop over the result set
		ResultSet rs = stmt.executeQuery("select * from admin where email = '"+admin.getEmail()+"' and password='"+admin.getPassword()+"' ");

		if(rs.next()) {
			
			return true;
			
		}else {
			
			return false;
		}
		
		
	}

	public ArrayList<Admin> getAdminDetails(String Email) throws ClassNotFoundException, SQLException {
		
		ArrayList<Admin> admin = new ArrayList<>();
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		//create statement
		Statement stmt = con.createStatement();
		
		//execute the satement and loop over the result set
		ResultSet rs = stmt.executeQuery("select * from admin where email = '"+Email+"' ");
		
		
		while(rs.next()) {
			String adminID = rs.getString(1);
			String firstName = rs.getString(2);
			String lastName = rs.getString(3);
			String email = rs.getString(4);
			String password = rs.getString(5);
			String address = rs.getString(6);
			String mobile = rs.getString(7);
			String fileName = rs.getString(8);
			String Path = rs.getString(9);
		
			
			Admin tmpAdmin = new Admin(adminID,firstName,lastName,email,password,address,mobile,fileName,Path);
			admin.add(tmpAdmin);
			
		}
		
		return admin; 
		
		
	}

	public void updateAdmin(Admin admin) throws ClassNotFoundException, SQLException {
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		
		
		//sql query to insert data
		PreparedStatement ps = con.prepareStatement("update admin set  firstName = ?, lastName = ?, password = ?, address = ?, mobile = ?  where email = ? ");
		
		ps.setString(1, admin.getFirstName() );
		ps.setString(2, admin.getLastName());
		ps.setString(3, admin.getPassword());
		ps.setString(4, admin.getAddress());
		ps.setString(5, admin.getMobile());
		ps.setString(6, admin.getEmail());
		
		ps.executeUpdate();
		
	}

}
