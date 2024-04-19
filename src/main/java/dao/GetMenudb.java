package dao;

import java.sql.*;

import dbConfig.DbConfig;
public class GetMenudb {
	public ResultSet fetchMenu()
	{
		Connection con = DbConfig.getConnect();
		System.out.println(con);
		PreparedStatement psmt;
		
		try {
			psmt= con.prepareStatement("select * from Menu");
			
			ResultSet rs = psmt.executeQuery();
			
			if(rs !=null)
			{
				return rs;
			}
			return null;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
