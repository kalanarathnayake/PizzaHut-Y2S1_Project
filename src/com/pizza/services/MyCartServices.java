package com.pizza.services;

import java.sql.SQLException;
import java.util.ArrayList;
import com.pizza.model.MyCart;
import com.pizza.util.MyCartDAO;


public class MyCartServices implements MyCartServicesInterface {
	
	@Override
	public ArrayList<MyCart> getCartDetails(String Email) {

		MyCartDAO cartDAO = new MyCartDAO();
		ArrayList<MyCart> cartDetails = null;
		try {
			cartDetails = (ArrayList<MyCart>) cartDAO.getPizzaDetails(Email);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cartDetails;

	}


}
