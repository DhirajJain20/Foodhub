package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.PendingItemsdb;

/**
 * Servlet implementation class UpdateStatus
 */
public class UpdateStatusSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String oid=request.getParameter("oid");
		
		PendingItemsdb pendingitems=new PendingItemsdb();
		
		pendingitems.updateStatus(oid);
		
		response.sendRedirect("pending_items.jsp");
	}

}
