package org.vurtatoo;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class Task3
 */
@WebServlet("/task3")
public class Task3 extends MyServlet {
	
	private static final long serialVersionUID = 15L;

	@Override
	protected void doGet(PrintWriter printWriter, Statement statement) {
		int shipmentId = getValueInt("shipmentid");
		try {
			ResultSet resultSet = statement.executeQuery(SQLREQUESTS.getOrdersNumberSQL(shipmentId));
			while (resultSet.next()) {
				printWriter.append(resultSet.getString(1) + "\n");
			}
		} catch (SQLException e) {
			printWriter.write(e.getSQLState());
			printWriter.write(e.getLocalizedMessage());
		}
	}
}
