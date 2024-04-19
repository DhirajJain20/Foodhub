package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbConfig.DbConfig;
import java.util.*;
public class OrderListdb {
    public void save(String oid,List<Integer> quantityList,List<String>itemList,String custid) throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs1 = null;
        
        try {
            con = DbConfig.getConnect();
            System.out.println(con);

            // Fetch item_name from MENU based on mid
            for (int i = 0; i < itemList.size(); i++) {
                stmt = con.prepareStatement("SELECT item_name FROM MENU WHERE mid = ?");
                stmt.setString(1, itemList.get(i));  // Assuming 1st column is mid
                rs1 = stmt.executeQuery();

                String item_name = "";
                if (rs1.next()) {
                    item_name = rs1.getString(1);  // Assuming item_name is the 1st column
                }

                // Insert data into OrderList
                stmt = con.prepareStatement("INSERT INTO OrderList (item, quantity, id) VALUES (?, ?, ?)");
                stmt.setString(1, item_name);
                stmt.setInt(2, quantityList.get(i));  // Assuming 2nd column is quantity
                stmt.setString(3, oid);
                
                stmt.executeUpdate();   
                
                stmt = con.prepareStatement("delete from cart where custid='"+custid+"'");
                
                stmt.executeUpdate();

            }

            
            System.out.println("Data inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources in the finally block
            if (rs1 != null) rs1.close();
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        }
    }
}
