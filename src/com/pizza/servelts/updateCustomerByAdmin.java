package com.pizza.servelts;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pizza.model.Customer;
import com.pizza.util.CustomerDAO;

/**
 * Servlet implementation class updateCustomerByAdmin
 */
@WebServlet("/updateCustomerByAdmin")
//Here define the size of a Image file
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,//2MB
					maxFileSize = 1024 * 1024 * 10, //10MB
					maxRequestSize = 1024 * 1024 * 50)

public class updateCustomerByAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		//include following 2 lines
		response.setContentType("text/html;charset=UTF-8");
		
		Customer customer = new Customer();

		String creditCartNumber = request.getParameter("creditCartNumber");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");	
		String address = request.getParameter("address");
		String mobile = request.getParameter("mobile");
		
		
		customer.setCreditCartNumber(creditCartNumber);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		customer.setPassword(password);
		customer.setAddress(address);
		customer.setMobile(mobile);
		
		
		
		CustomerDAO customerDatabase = new CustomerDAO();
		
		try {
			customerDatabase.updateCustomer(customer);
			
			response.sendRedirect("adminCustomerPanel.jsp");
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			
		}
	}

}
