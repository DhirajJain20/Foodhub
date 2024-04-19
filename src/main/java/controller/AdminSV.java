package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;

import dao.GetMenudb;

/**
 * Servlet implementation class AdminSV
 */
public class AdminSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		GetMenudb get= new GetMenudb();
		
		ResultSet menu=get.fetchMenu();
		HttpSession session = request.getSession(false);
		session.setAttribute("Menu", menu);
		
		response.sendRedirect("AddMenu.jsp");

	}

}
