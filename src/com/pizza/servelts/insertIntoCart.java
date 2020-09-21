package com.pizza.servelts;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pizza.model.MyCart;
import com.pizza.util.MyCartDAO;


@WebServlet("/insertIntoCart")
//Here define the size of a Image file
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,//2MB
					maxFileSize = 1024 * 1024 * 10, //10MB
					maxRequestSize = 1024 * 1024 * 50)

public class insertIntoCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		//include following 2 lines
		response.setContentType("text/html;charset=UTF-8");
		
		String email = request.getParameter("email");
		String pizzaID = request.getParameter("pizzaID");
		String pizzaName = request.getParameter("pizzaName");
		String price = request.getParameter("price");
		String fileName = request.getParameter("fileName");
		
		MyCart mycart = new MyCart();
		mycart.setEmail(email);
		mycart.setPizzaID(pizzaID);
		mycart.setPizzaName(pizzaName);
		mycart.setPrice(price);
		mycart.setFileName(fileName);
		
		MyCartDAO mycartDAO = new MyCartDAO();
		try {
			mycartDAO.insertIntoCart(mycart);
			response.sendRedirect("mycart.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
