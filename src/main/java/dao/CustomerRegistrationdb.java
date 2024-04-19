package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dbConfig.DbConfig;
import pojo.CustomerRegistration;



public class CustomerRegistrationdb {
	public void save(CustomerRegistration std) {
		Connection connection = DbConfig.getConnect();
		System.out.println(connection);
		PreparedStatement stmt;

		try {
			stmt = connection.prepareStatement("insert into Customer values(CONCAT('CID',LPAD(custid.NEXTVAL,4,'0')),?,?,?)");

			stmt.setString(1, std.getCname());
			stmt.setString(2, std.getEmail());
			stmt.setString(3, std.getPass());
			int i = stmt.executeUpdate();
			System.out.println(i + " records inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
