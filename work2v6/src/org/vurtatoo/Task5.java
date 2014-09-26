package org.vurtatoo;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
		try {
			ResultSet resultSet = statement.executeQuery(SQLREQUESTS.getShipmentsOrderToday());
			List<Integer> shipments = new ArrayList<Integer>();
			while (resultSet.next()) {
				shipments.add(resultSet.getInt(1));
				printWriter.append(resultSet.getString(1) + "\n");
			}
			ResultSet resultSetId = statement.executeQuery(SQLREQUESTS.createNewOrder("commnet"));
			while (resultSetId.next()) {
				int orderId = resultSetId.getInt(1);
				for (Integer shipmentId : shipments) {
					ResultSet resultSetInstert = statement.executeQuery(SQLREQUESTS.insertOrderHasShipment(orderId,shipmentId));
					resultSetInstert.close();
				}
					
			}
			
		} catch (SQLException e) {
			printWriter.write(e.getSQLState());
			printWriter.write(e.getLocalizedMessage());
		}
	}
}