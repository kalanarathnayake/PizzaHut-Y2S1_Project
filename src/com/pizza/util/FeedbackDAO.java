package com.pizza.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.pizza.model.Feedback;


public class FeedbackDAO {

	private static String url = "jdbc:mysql://localhost:3306/pizzahut?serverTimezone=UTC";
	private static String userName = "senura";
	private static String password = "senura";
	
	public void insertFeedback(Feedback msg) throws ClassNotFoundException, SQLException {
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		 
	
		
		PreparedStatement ps = con.prepareStatement("insert into feedback (email,feedback) values(?,?)");
		
		ps.setString(1, msg.getEmail() );
		ps.setString(2, msg.getFeedback() );
	
	
			
		ps.executeUpdate();
		
	}

	public ArrayList<Feedback> getFeedbackList() throws ClassNotFoundException, SQLException {
		
		ArrayList<Feedback> feedbackDetails = new ArrayList<>();
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		//create statement
		Statement stmt = con.createStatement();
		
		//execute the satement and loop over the result set
		ResultSet rs = stmt.executeQuery("select * from feedback ");
		
		
		while(rs.next()) {
			
			String feedbackID = rs.getString(1);
			String email = rs.getString(2);
			String feedback = rs.getString(3);
			String DataTime = rs.getString(4);
			
			
			
			Feedback msg = new Feedback(feedbackID,email,feedback,DataTime);
			feedbackDetails.add(msg);
		}
		
		return feedbackDetails; 
		
	}

	public void deleteFeedback(Feedback feedback) throws ClassNotFoundException, SQLException {
		
		//load the mysql Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		
		Statement statement = con.createStatement(); 
		
		statement.executeUpdate("delete from feedback where feedbackID ='"+feedback.getFeedbackID() +"' ");
		
		
	}

}
