package com.pizza.servelts;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pizza.model.Pizza;
import com.pizza.util.PizzaDAO;


@WebServlet("/updatePizzaDetails")
//Here define the size of a Image file
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,//2MB
					maxFileSize = 1024 * 1024 * 10, //10MB
					maxRequestSize = 1024 * 1024 * 50)

public class updatePizzaDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		//include following 2 lines
		response.setContentType("text/html;charset=UTF-8");
	
		String pizzaID = request.getParameter("pizzaID");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String price = request.getParameter("price");
		
		
		Pizza pizza = new Pizza();
		
		pizza.setPizzaID(pizzaID);
		pizza.setName(name);
		pizza.setDescription(description);
		pizza.setPrice(price);
		
		
		PizzaDAO pizzaDAO = new PizzaDAO();
		try {
			
			pizzaDAO.updatePizzaDetails(pizza);
			response.sendRedirect("adminPizzaPanel.jsp");
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			
		}
		
	}

}
