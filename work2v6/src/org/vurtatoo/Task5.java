package org.vurtatoo;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Сформировать новый заказ, состоящий из товаров, заказанных в текущий день.
 * @author user
 *
 */
@WebServlet("/task5")
public class Task5 extends MyServlet {
	
	private static final long serialVersionUID = 21L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, Statement statement) {
        try {
            ResultSet resultSet = statement.executeQuery(SQLREQUESTS.getShipmentsOrderToday());
            List<Integer> shipments = new ArrayList<Integer>();
            while (resultSet.next()) {
                shipments.add(resultSet.getInt(1));
            }
            statement.executeUpdate(SQLREQUESTS.createNewOrder("comment"));
            ResultSet resultSetId = statement.executeQuery(SQLREQUESTS.getMaxOrderId());
            List<Integer> numbers = new ArrayList<Integer>();
            while (resultSetId.next()) {                
                int orderId = resultSetId.getInt(1);
                numbers.add(orderId);
                for (Integer shipmentId : shipments) {
                    MysqlManager mysqlManager = new MysqlManager();
                    mysqlManager.createStatement().executeUpdate(SQLREQUESTS.insertOrderHasShipment(orderId,shipmentId));
                    mysqlManager.close();
                }   
            }
            request.setAttribute("numbers", numbers);
            request.getRequestDispatcher("/NumberOrders.jsp").forward(request,response);
        } catch (SQLException | ServletException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}