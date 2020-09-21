package com.pizza.services;

import java.util.ArrayList;

import com.pizza.model.Admin;

public interface AdminServicesInterface {

	public ArrayList<Admin> getAdminDetails(String Email);

}
