package dbConfig;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConfig {
	public static Connection getConnect() {
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "21bcee45");
//			System.out.println("Hello");

		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return con;
	}
}
