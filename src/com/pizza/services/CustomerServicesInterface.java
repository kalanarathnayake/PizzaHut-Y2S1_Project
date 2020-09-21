package com.pizza.services;

import java.util.ArrayList;

import com.pizza.model.Customer;

public interface CustomerServicesInterface {

	public ArrayList<Customer> getCustomerDetails(String Email);

	public ArrayList<Customer> getCustomerList();

}
