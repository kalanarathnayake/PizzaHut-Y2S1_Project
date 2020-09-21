package com.pizza.servelts;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pizza.model.Admin;
import com.pizza.util.AdminDAO;



@WebServlet("/updateAdmin")
//Here define the size of a Image file
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,//2MB
					maxFileSize = 1024 * 1024 * 10, //10MB
					maxRequestSize = 1024 * 1024 * 50)

public class updateAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		//include following 2 lines
		response.setContentType("text/html;charset=UTF-8");
		
		Admin admin = new Admin();

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");	
		String address = request.getParameter("address");
		String mobile = request.getParameter("mobile");
		
		

		admin.setFirstName(firstName);
		admin.setLastName(lastName);
		admin.setEmail(email);
		admin.setPassword(password);
		admin.setAddress(address);
		admin.setMobile(mobile);
		
		
		
		AdminDAO adminDatabase = new AdminDAO();
		
		try {
			adminDatabase.updateAdmin(admin);
			
			response.sendRedirect("admin.jsp");
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			
		}
		
		
	}

}
