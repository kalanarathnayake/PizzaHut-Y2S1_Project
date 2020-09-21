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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.pizza.model.Customer;
import com.pizza.util.CustomerDAO;


@WebServlet("/insertCustomer")
//Here define the size of a Image file
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,//2MB
					maxFileSize = 1024 * 1024 * 10, //10MB
					maxRequestSize = 1024 * 1024 * 50)


public class insertCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		//include following 2 lines
		response.setContentType("text/html;charset=UTF-8");
		
		Customer customer = new Customer();
		
		
		Part part = request.getPart("file");
		String fileName = extractFileName(part);
		String savePath = "C:\\Users\\Senura\\eclipse-workspace\\PizzaHut\\WebContent\\Storage" + File.separator + fileName;
		part.write(savePath + File.separator); 
		
		String creditCartNumber = request.getParameter("creditCartNumber");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");	
		String address = request.getParameter("address");
		String mobile = request.getParameter("mobile");
		
		
		customer.setCreditCartNumber(creditCartNumber);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		customer.setPassword(password);
		customer.setAddress(address);
		customer.setMobile(mobile);
		customer.setFileName(fileName);
		customer.setPath(savePath);
		
		
		CustomerDAO customerDatabase = new CustomerDAO();
		
		try {
			
			HttpSession session = request.getSession();
			session.setAttribute("email", request.getParameter("email"));
			session.setAttribute("password", request.getParameter("password"));
			
			customerDatabase.insertCustomer(customer);
			
			response.sendRedirect("user.jsp");
			
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
