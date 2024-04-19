package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import java.sql.*;

import pojo.AddMenu;

import dao.AddMenudb;
import dao.GetMenudb;
/**
 * Servlet implementation class AddMenuSV
 */
public class AddMenuSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String item_name=request.getParameter("item_name");
		int price=Integer.parseInt(request.getParameter("price"));
		
		AddMenu am= new AddMenu(item_name,price);
		AddMenudb a = new AddMenudb();
		
		a.save(am);
		


		response.sendRedirect("AdminSV");


		
		
		
		
		

	}

}
