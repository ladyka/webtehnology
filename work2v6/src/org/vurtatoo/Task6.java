package org.vurtatoo;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
/**
 * Удалить все заказы, в которых присутствует заданное количество заданного товара.
 * @author user
 *
 */
@WebServlet("/task6")
public class Task6 extends MyServlet {
	
	private static final long serialVersionUID = 22L;

	@Override
	protected void doGet(PrintWriter printWriter, Statement statement) {
		int shipmentId = getValueInt("shipmentid");
		int count = getValueInt("count");
		try {
			ResultSet resultSet = statement.executeQuery(SQLREQUESTS.getOrdersSQL(shipmentId, count));
			while (resultSet.next()) {
				int orderId = Integer.valueOf(resultSet.getString(1));
				printWriter.append(resultSet.getString(1) + "\n");
				statement.executeQuery(SQLREQUESTS.delOrdersSQL(orderId));
			}
		} catch (SQLException e) {
			printWriter.write(e.getSQLState());
			printWriter.write(e.getLocalizedMessage());
		}
	}
}