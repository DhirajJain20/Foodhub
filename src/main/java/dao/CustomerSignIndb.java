package dao;
import java.sql.*;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.apache.tomcat.jakartaee.bcel.classfile.StackMapEntry;

import dbConfig.DbConfig;
import pojo.CustomerSignIn;
import pojo.UserDetails;

public class CustomerSignIndb {
	public UserDetails save(CustomerSignIn si) throws SQLException {
		Connection con = DbConfig.getConnect();
		System.out.println(con);
		
		
		PreparedStatement ps = con.prepareStatement("select * from Customer where email = ?");
		String emailEntered = si.getEmail();
		String passEntered = si.getPass();
		ps.setString(1, emailEntered);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			String cid = rs.getString(1);
			String cname = rs.getString(2);
			String email = rs.getString(3);
			String password = rs.getString(4);
			
			if(password.equals(passEntered)) {
				System.out.println("pass verified");
				
				UserDetails user = new UserDetails();
				user.setUid(cid);
				user.setUname(cname);
				user.setEmail(email);
				
//				System.out.println(user.getUname());
				return user;
			}
			else
				System.out.println("not");
			
		}
		return null;
	}
}
