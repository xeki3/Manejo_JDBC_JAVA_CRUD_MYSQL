package datos;

import java.sql.*;

public class Conexion {

	private static final String URL_JDBC	= "jdbc:mysql://localhost:3306/test";
	private static final String USER_JDBC 	= "root";
	private static final String PASS_JDBC 	=	"";
	
	public static Connection getConnection() throws SQLException {
		 return DriverManager.getConnection(URL_JDBC,USER_JDBC,PASS_JDBC);
		
	}
	
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
