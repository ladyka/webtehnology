package org.vurtatoo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlManager {

	private static Connection getConnetcion() throws SQLException, ClassNotFoundException {
		String driverClassName = "com.mysql.jdbc.Driver";
		Class.forName(driverClassName);
		Connection cn = null;
		cn = DriverManager.getConnection("jdbc:mysql://localhost/work2v6", "work2v6", "work2v6");
		return cn;
	}
	
	public static ResultSet getRezult(String requestSQL) throws ClassNotFoundException, SQLException {
		Connection connection = getConnetcion();
		Statement st = connection.createStatement();
		return st.executeQuery(requestSQL);
	}
}
