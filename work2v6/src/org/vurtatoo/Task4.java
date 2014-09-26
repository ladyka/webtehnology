package org.vurtatoo;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;

/**
 * Вывести номера заказов, не содержащих заданный товар и поступивших в течение текущего дня.
 * @author user
 *
 */
@WebServlet("/task4")
public class Task4 extends MyServlet {
	
	private static final long serialVersionUID = 20L;

	@Override
	protected void doGet(PrintWriter printWriter, Statement statement) {
		int shipmentId = getValueInt("shipmentid");
		try {
			ResultSet resultSet = statement.executeQuery(SQLREQUESTS.getOrdersNotToday(shipmentId));
			while (resultSet.next()) {
				printWriter.append(resultSet.getString(1) + "\n");
			}
		} catch (SQLException e) {
			printWriter.write(e.getSQLState());
			printWriter.write(e.getLocalizedMessage());
		}
	}
}