package com.pizza.services;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pizza.model.Customer;
import com.pizza.util.CustomerDAO;


public class CustomerServices implements CustomerServicesInterface {
	
	
	@Override
	public ArrayList<Customer> getCustomerDetails(String Email) {

		CustomerDAO customerDAO = new CustomerDAO();
		ArrayList<Customer> customerDetails = null;
		try {
			customerDetails = (ArrayList<Customer>) customerDAO.getCustomerDetails(Email);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return customerDetails;

	}
	
	@Override
	public ArrayList<Customer> getCustomerList() {

		CustomerDAO customerDAO = new CustomerDAO();
		ArrayList<Customer> customerDetails = null;
		try {
			customerDetails = (ArrayList<Customer>) customerDAO.getCustomerList();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return customerDetails;

	}

}
