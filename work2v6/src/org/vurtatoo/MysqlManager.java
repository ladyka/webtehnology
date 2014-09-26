package org.vurtatoo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlManager {
	
	private  Connection connection;
	private  Statement statement;
	
	private  Connection getConnetcion() throws SQLException, ClassNotFoundException {
		String driverClassName = "com.mysql.jdbc.Driver";
		Class.forName(driverClassName);
		connection = null;
		connection = DriverManager.getConnection("jdbc:mysql://localhost/work2v6", "work2v6", "work2v6");
		return connection;
	}
	
	public  Statement createStatement() throws ClassNotFoundException, SQLException {
		return getConnetcion().createStatement();
	}
	
	public  void close() throws SQLException {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (Exception e) {
		}

		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
		}
		
	}
}
