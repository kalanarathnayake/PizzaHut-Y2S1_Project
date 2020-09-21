package com.pizza.servelts;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.pizza.model.Pizza;
import com.pizza.util.PizzaDAO;


@WebServlet("/insertPizza")
//Here define the size of a Image file
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,//2MB
					maxFileSize = 1024 * 1024 * 10, //10MB
					maxRequestSize = 1024 * 1024 * 50)


public class insertPizza extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		//include following 2 lines
		response.setContentType("text/html;charset=UTF-8");
		
		
		Part part = request.getPart("file");
		String fileName = extractFileName(part);
		String savePath = "C:\\Users\\Senura\\eclipse-workspace\\PizzaHut\\WebContent\\Storage" + File.separator + fileName;
		part.write(savePath + File.separator); 
		
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String price = request.getParameter("price");
	
		Pizza pizza = new Pizza();
		
		pizza.setName(name);
		pizza.setDescription(description);
		pizza.setPrice(price);
		pizza.setFileName(fileName);
		pizza.setPath(savePath);
		
		PizzaDAO pizzaDAO = new PizzaDAO();
		
		try {
			
			pizzaDAO.insertPizza(pizza);
			
			response.sendRedirect("adminPizzaPanel.jsp");
			
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
			
		}
		
		
	}
	
	
	private String extractFileName(Part part) {

		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if(s.trim().startsWith("filename")) {
				
				return s.substring(s.indexOf("=") + 2,s.length() - 1);
				
			}
		}
		return "";
	}

}



