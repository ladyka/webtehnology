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
 * Servlet implementation class Task2
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/task2" })
public class Task2 extends MyServlet {
	private static final long serialVersionUID = 11L;
	
    public Task2() {
        super();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, Statement statement) {
        int price = getValueInt(request,"price");
        int shipments = getValueInt(request,"shipments");
        try {
            List<Integer> numbers = new ArrayList<Integer>();
            ResultSet resultSet = statement.executeQuery(SQLREQUESTS.getListOrdersSQL(price, shipments));
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
