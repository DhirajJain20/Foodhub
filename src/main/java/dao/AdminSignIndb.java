package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbConfig.DbConfig;
import pojo.CustomerSignIn;
import pojo.UserDetails;

public class AdminSignIndb {
	public UserDetails save(CustomerSignIn si) throws SQLException {
		Connection con = DbConfig.getConnect();
		System.out.println(con);
		
		
		PreparedStatement ps = con.prepareStatement("select * from AdminCafeteria where email = ?");
		String emailEntered = si.getEmail();
		String passEntered = si.getPass();
		ps.setString(1, emailEntered);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			String cid = rs.getString(1);
			String email = rs.getString(2);
			String password = rs.getString(3);
			if(password.equals(passEntered)) {
				System.out.println("pass verified");
				
				UserDetails user = new UserDetails();
				user.setUid(cid);
				user.setUname("admin");
				user.setEmail(email);
				
				return user;
			}
			else
				System.out.println("not");
			
		}
		return null;
	}
}
