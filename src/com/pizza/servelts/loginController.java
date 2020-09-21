package com.pizza.servelts;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pizza.model.Admin;
import com.pizza.model.Customer;
import com.pizza.util.AdminDAO;
import com.pizza.util.CustomerDAO;


@WebServlet("/loginController")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		Customer customer = new Customer();
		Admin admin = new Admin();
			
		customer.setEmail(request.getParameter("email"));
		customer.setPassword(request.getParameter("password"));
		
		admin.setEmail(request.getParameter("email"));
		admin.setPassword(request.getParameter("password"));
		
		CustomerDAO customerDAO = new CustomerDAO();
		AdminDAO adminDAO = new AdminDAO();
		
		try {
			boolean validateCustomer = customerDAO.customerLogin(customer);
			boolean validateAdmin = adminDAO.adminLogin(admin);
			
			if(validateCustomer == true) {
			
				HttpSession session = request.getSession();
				session.setAttribute("email", request.getParameter("email"));
				session.setAttribute("password", request.getParameter("password"));
				
				response.sendRedirect("user.jsp");
				
			}
			else if(validateAdmin == true) {
				
				HttpSession session = request.getSession();
				session.setAttribute("email", request.getParameter("email"));
				session.setAttribute("password", request.getParameter("password"));
				
				response.sendRedirect("admin.jsp");
				
			}
			
			else if( validateCustomer != true && validateAdmin != true  ){			
				
				response.sendRedirect("login.jsp");
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
		
			
			e.printStackTrace();
		}
		
		
	}

}
