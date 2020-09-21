package com.pizza.services;

import java.util.ArrayList;

import com.pizza.model.Pizza;

public interface PizzaServicesInterface {

	public ArrayList<Pizza> getPizzaList();

	public ArrayList<Pizza> getPizzaDetails(String PizzaID);

}
