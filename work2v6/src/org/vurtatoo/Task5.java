package org.vurtatoo;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
/**
 * Сформировать новый заказ, состоящий из товаров, заказанных в текущий день.
 * @author user
 *
 */
@WebServlet("/task5")
public class Task5 extends MyServlet {
	
	private static final long serialVersionUID = 21L;

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