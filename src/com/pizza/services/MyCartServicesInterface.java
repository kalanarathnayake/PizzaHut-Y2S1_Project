package com.pizza.services;

import java.util.ArrayList;

import com.pizza.model.MyCart;

public interface MyCartServicesInterface {

	public ArrayList<MyCart> getCartDetails(String Email);

}
