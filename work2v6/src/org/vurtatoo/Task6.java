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
 * Удалить все заказы, в которых присутствует заданное количество заданного товара.
 * @author user
 *
 */
@WebServlet("/task6")
public class Task6 extends MyServlet {
	
	private static final long serialVersionUID = 22L;

	

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, Statement statement) {
        int shipmentId = getValueInt(request,"shipmentid");
        int count = getValueInt(request,"count");
        try {
            List<Integer> numbers = new ArrayList<Integer>();
            ResultSet resultSet = statement.executeQuery(SQLREQUESTS.getOrdersSQL(shipmentId, count));
            while (resultSet.next()) {
                numbers.add(resultSet.getInt(1));
                int orderId = Integer.valueOf(resultSet.getString(1));
                
                MysqlManager mysqlManagerdelOrder = new MysqlManager();
                mysqlManagerdelOrder.createStatement().executeUpdate(SQLREQUESTS.delShipmentinOrder(orderId));
                mysqlManagerdelOrder.close();
                
                MysqlManager mysqlManager = new MysqlManager();
                mysqlManager.createStatement().executeUpdate(SQLREQUESTS.delOrderSQL(orderId));
                mysqlManager.close();
                
            }
            request.setAttribute("numbers", numbers);
            request.getRequestDispatcher("/NumberOrders.jsp").forward(request,response);
        } catch (SQLException | ServletException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}