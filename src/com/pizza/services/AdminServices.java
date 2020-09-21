package com.pizza.services;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pizza.model.Admin;
import com.pizza.util.AdminDAO;


public class AdminServices implements AdminServicesInterface {
	
	
	@Override
	public ArrayList<Admin> getAdminDetails(String Email) {

		AdminDAO adminDAO = new AdminDAO();
		ArrayList<Admin> adminDetails = null;
		try {
			adminDetails = (ArrayList<Admin>) adminDAO.getAdminDetails(Email);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return adminDetails;

	}

}
