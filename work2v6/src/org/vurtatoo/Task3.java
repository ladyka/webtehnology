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
 * Servlet implementation class Task3
 */
@WebServlet("/task3")
public class Task3 extends MyServlet {
	
	private static final long serialVersionUID = 15L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, Statement statement) {
        int shipmentId = getValueInt(request,"shipmentid");
        try {
            List<Integer> numbers = new ArrayList<Integer>();
            ResultSet resultSet = statement.executeQuery(SQLREQUESTS.getOrdersNumberSQL(shipmentId));
            while (resultSet.next()) {
                numbers.add(resultSet.getInt(1));
            }
            request.setAttribute("numbers", numbers);
            request.getRequestDispatcher("/NumberOrders.jsp").forward(request,response);
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
