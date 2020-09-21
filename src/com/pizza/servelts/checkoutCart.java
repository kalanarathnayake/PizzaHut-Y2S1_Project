package com.pizza.servelts;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pizza.model.MyCart;
import com.pizza.util.MyCartDAO;

/**
 * Servlet implementation class checkoutCart
 */
@WebServlet("/checkoutCart")
public class checkoutCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		
		MyCart mycart = new MyCart();
		mycart.setEmail(email);
		
		MyCartDAO mycartDAO = new MyCartDAO();
		try {
			
			mycartDAO.checkoutMyCart(mycart);
			response.sendRedirect("orderConfirmation.jsp");
			
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
			
		}
		
	}


}
