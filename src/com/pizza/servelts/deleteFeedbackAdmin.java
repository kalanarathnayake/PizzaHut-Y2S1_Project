package com.pizza.servelts;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pizza.model.Feedback;
import com.pizza.util.FeedbackDAO;

@WebServlet("/deleteFeedbackAdmin")
public class deleteFeedbackAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String feedbackID = request.getParameter("feedbackID");
		
		Feedback feedback = new Feedback();
		feedback.setFeedbackID(feedbackID);
		
		FeedbackDAO feedbackDAO = new FeedbackDAO();
		try {
			feedbackDAO.deleteFeedback(feedback);
			response.sendRedirect("adminFeedbackPanel.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	
		
	}



}
