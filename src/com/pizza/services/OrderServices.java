package com.pizza.services;

import java.sql.SQLException;
import java.util.ArrayList;
import com.pizza.model.Order;
import com.pizza.util.OrderDAO;

public class OrderServices implements OrderServicesInterface {
	
	@Override
	public ArrayList<Order> getOrderDetails() {

		OrderDAO orderDAO = new OrderDAO();
		ArrayList<Order> orderDetails = null;
		try {
			orderDetails = (ArrayList<Order>) orderDAO.getOrderDetails();
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
			
		}

		return orderDetails;

	}

}
