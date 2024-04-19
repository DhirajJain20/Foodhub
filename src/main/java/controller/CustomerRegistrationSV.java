package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.CustomerRegistration;
import dao.CustomerRegistrationdb;
import java.io.IOException;


public class CustomerRegistrationSV extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String cname = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		
		CustomerRegistration cr = new CustomerRegistration(cname, email, pass);
		CustomerRegistrationdb c = new CustomerRegistrationdb();
		c.save(cr);
//		System.out.print(true);
		
		response.sendRedirect("login.html");
	}

}
