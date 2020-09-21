package com.pizza.servelts;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pizza.model.Customer;
import com.pizza.util.CustomerDAO;


@WebServlet("/deleteCustomer")
public class deleteCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String email = request.getParameter("email");
		
		Customer customer = new Customer();
		customer.setEmail(email);
		
		CustomerDAO cusDAO = new CustomerDAO();
		try {
			cusDAO.deleteCustomer(customer);
			response.sendRedirect("adminCustomerPanel.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



}
