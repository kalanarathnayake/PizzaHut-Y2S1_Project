package com.pizza.servelts;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pizza.model.Feedback;
import com.pizza.util.FeedbackDAO;


@WebServlet("/insertFeedback")
//Here define the size of a Image file
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,//2MB
					maxFileSize = 1024 * 1024 * 10, //10MB
					maxRequestSize = 1024 * 1024 * 50)

public class insertFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		//include following 2 lines
		response.setContentType("text/html;charset=UTF-8");
		
		String email = request.getParameter("email");
		String feedback = request.getParameter("feedback");
		
		Feedback msg = new Feedback();
		msg.setEmail(email);
		msg.setFeedback(feedback);
		
		FeedbackDAO feedbackDAO = new FeedbackDAO();
		try {
			
			feedbackDAO.insertFeedback(msg);
			response.sendRedirect("user.jsp");
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			
		}
		
	}

}
