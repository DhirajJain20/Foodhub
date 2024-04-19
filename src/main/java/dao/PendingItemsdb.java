package dao;
import java.sql.*;

import dbConfig.DbConfig;
public class PendingItemsdb {
	public ResultSet fetchItemList() {
		
		Connection con = DbConfig.getConnect();
		System.out.println(con);
		PreparedStatement stmt;
		
		try {
			String query="SELECT ol.item, ol.quantity, ot.oid " +
                    "FROM OrderList ol " +
                    "JOIN OrderTable ot ON ol.id = ot.oid " +
                    "WHERE ot.status='Pending'";
			stmt=con.prepareStatement(query);
			ResultSet rs=stmt.executeQuery();
			
			return rs;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
		
	}
	public ResultSet fetchStatus(String oid)
	{
		Connection con = DbConfig.getConnect();
		System.out.println(con);
		PreparedStatement stmt;
		
		try
		{
			String query="select status from orderTable where oid='"+oid+"'";
			
			stmt=con.prepareStatement(query);
			
			ResultSet rs= stmt.executeQuery();
			
			return rs;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public void updateStatus(String oid)
	{
		Connection con = DbConfig.getConnect();
		System.out.println(con);
		PreparedStatement stmt;
		
		try {
			
			String query="update orderTable set status='Completed' where oid='"+oid+"'";
			
			stmt=con.prepareStatement(query);
			
			stmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}
