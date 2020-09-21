package com.pizza.servelts;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pizza.model.Order;
import com.pizza.util.OrderDAO;


@WebServlet("/deleteOrderAdmin")
public class deleteOrderAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String orderID = request.getParameter("orderID");
		
		Order order = new Order();
		order.setOrderID(orderID);
		
		OrderDAO orderDAO = new OrderDAO();
		try {
			orderDAO.deleteOrder(order);
			response.sendRedirect("adminOrderPanel.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



}
