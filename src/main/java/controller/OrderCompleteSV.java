package controller;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pojo.UserDetails;

import java.io.IOException;
import java.sql.SQLException;

import dao.OrderTabledb;
import dao.*;
import java.util.*
;public class OrderCompleteSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int total_price=Integer.parseInt(request.getParameter("price"));
		int total_quantity=Integer.parseInt(request.getParameter("quantity"));
		
		OrderTabledb od=new OrderTabledb();
		OrderListdb ol=new OrderListdb();
		try {
			String orderid=od.save(total_price, total_quantity);
			
			HttpSession session=request.getSession(false);
			
			List<Integer> quantityList=(List<Integer>)session.getAttribute("quantityList");
			List<String> itemList=(List<String>)session.getAttribute("itemList");

			session.setAttribute("orderid", orderid);
//			System.out.println(rs);
//			while(rs.next())
//			{
//				System.out.println(rs.getString(1)+" "+rs.getInt(2));
//			}
			UserDetails user = (UserDetails)session.getAttribute("user");
			String custid=user.getUid();
			
			ol.save(orderid,quantityList,itemList,custid);
			
			System.out.println("OK");
			
			response.sendRedirect("completeOrder.jsp");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

}
