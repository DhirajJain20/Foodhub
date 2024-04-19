package dao;

import java.sql.*;
import dbConfig.DbConfig;

public class OrderTabledb {
    public String save(int total_price, int total_quantity) throws SQLException {
        Connection con = DbConfig.getConnect();
        System.out.println(con);
        PreparedStatement stmt;
        
        
        	String id="CONCAT('ORDER', LPAD(orderid.NEXTVAL, 4, '0'))";
        	
            stmt = con.prepareStatement("INSERT INTO orderTable (oid, price, net_quantity, status) VALUES (CONCAT('ORDER', LPAD(orderid.NEXTVAL, 4, '0')), ?, ?, ?)");
            
            stmt.setInt(1, total_price);
            stmt.setInt(2, total_quantity);
            stmt.setString(3, "Pending");
            
            
            int affectedRows = stmt.executeUpdate(); // Use executeUpdate
            
            stmt=con.prepareStatement("Select * from orderTable order by oid desc");
            
            ResultSet rs=stmt.executeQuery();
            String oid="";
            while(rs.next())
            {
            	oid=rs.getString(1);
            	break;
            }
            
            return oid;
            

    }
}
