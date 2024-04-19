package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dbConfig.DbConfig;
import pojo.AddMenu;

public class AddMenudb {
	public void save(AddMenu am)
	{
		Connection con = DbConfig.getConnect();
		System.out.println(con);
		PreparedStatement stmt;

		try {
			stmt = con.prepareStatement("insert into Menu values(CONCAT('ITEM',LPAD(itemid .NEXTVAL,4,'0')),?,?)");

			stmt.setString(1, am.getItemName());
			stmt.setInt(2, am.getPrice());
			int i = stmt.executeUpdate();
			System.out.println(i + " item added");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
