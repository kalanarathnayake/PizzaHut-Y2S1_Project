package com.pizza.services;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pizza.model.Pizza;
import com.pizza.util.PizzaDAO;



public class PizzaServices implements PizzaServicesInterface{
	
	@Override
	public ArrayList<Pizza> getPizzaList() {

		PizzaDAO pizzaDAO = new PizzaDAO();
		ArrayList<Pizza> pizzaList = null;
		try {
			pizzaList = (ArrayList<Pizza>) pizzaDAO.getPizzaList();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pizzaList;

	}
	
	
	@Override
	public ArrayList<Pizza> getPizzaDetails(String PizzaID) {

		PizzaDAO pizzaDAO = new PizzaDAO();
		ArrayList<Pizza> pizzaDetails = null;
		try {
			pizzaDetails = (ArrayList<Pizza>) pizzaDAO.getPizzaDetails(PizzaID);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pizzaDetails;

	}

}
