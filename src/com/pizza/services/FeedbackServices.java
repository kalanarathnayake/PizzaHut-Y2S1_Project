package com.pizza.services;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pizza.model.Feedback;
import com.pizza.util.FeedbackDAO;

public class FeedbackServices implements FeedbackServicesinterface {
	
	@Override
	public ArrayList<Feedback> getFeedbackList() {

		FeedbackDAO feedbackDAO = new FeedbackDAO();
		ArrayList<Feedback> feedbackDetails = null;
		try {
			
			feedbackDetails = (ArrayList<Feedback>) feedbackDAO.getFeedbackList();
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			
		}

		return feedbackDetails;

	}

}
