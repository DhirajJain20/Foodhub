package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import pojo.UserDetails;

import dao.AddCartdb;
/**
 * Servlet implementation class CartSV
 */
public class CartSV extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String item_id=request.getParameter("item_id");
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		int price=Integer.parseInt(request.getParameter("totalPrice"));
		
		HttpSession session = request.getSession(false);
		
		UserDetails user = (UserDetails)session.getAttribute("user");
		String custid=user.getUid();
		System.out.println(item_id+" "+quantity+" "+price+" "+custid);
		
		AddCartdb add=new AddCartdb();
		
		add.save(item_id, quantity, price, custid);
		response.sendRedirect("cart.jsp");
	}

}
