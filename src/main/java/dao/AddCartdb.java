package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dbConfig.DbConfig;

public class AddCartdb {
	public Boolean save(String item_id,int quantity,int totalPrice,String custid)
	{
		Connection con = DbConfig.getConnect();
		System.out.println(con);
		PreparedStatement stmt;
		
		try {
			stmt = con.prepareStatement("insert into Cart values('"+item_id+"','"+quantity+"','"+totalPrice+"','"+custid+"')");

			int i = stmt.executeUpdate();
			System.out.println(i + " item added");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
}
