package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pojo.CustomerSignIn;
import pojo.UserDetails;

import java.io.IOException;
import java.sql.SQLException;

import dao.CustomerSignIndb;

/**
 * Servlet implementation class CustomerSignInSV
 */
public class CustomerSignInSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		
		CustomerSignIn si = new CustomerSignIn(email, pass);
		CustomerSignIndb s = new CustomerSignIndb();
		try {
			UserDetails user = s.save(si);
			HttpSession session = request.getSession(true);
				
//			System.out.println(user.getUname());
			session.setAttribute("user", user);
			session.setAttribute("logged_in", true);
			System.out.println("Login succesfully!");
			response.sendRedirect("menu.jsp");
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
