package DB;
import java.sql.*;

public class DBConnection {
	public static Connection CreateConn() {
		Connection conn=null;
		String name = "root";
		String pass = "1234";
		String url ="jdbc:mysql://localhost:3306/finalweb?useUnicode=true&amp;characterEncoding=utf8";
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,name,pass);
			
		}
		catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		
		return conn;
	}
}
