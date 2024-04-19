package dao;
import java.sql.*;

import dbConfig.DbConfig;
public class GetCartDetailsdb {
	public ResultSet fetch(String custid) throws SQLException
	{
		Connection con = DbConfig.getConnect();
		System.out.println(con);
		PreparedStatement stmt;
		
		stmt=con.prepareStatement("select * from Cart where custid='"+custid+"'");
		
		ResultSet rs=stmt.executeQuery();
		if(rs !=null)
		{
			return rs;
		}
		return null;
	}
}
