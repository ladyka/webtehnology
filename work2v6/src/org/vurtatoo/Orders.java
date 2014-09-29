package org.vurtatoo;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "List all orders", urlPatterns = { "/orders" })
public final class Orders extends MyServlet {
	private static final long serialVersionUID = 21L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Orders() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response, Statement statement) {
		ResultSet resultSet;
		try {
			resultSet = statement.executeQuery(SQLREQUESTS.getOrdersSQL());
			List<ShipmentOrderView> orderViews = new ArrayList<ShipmentOrderView>();
			int priceTotal = 0;
			while (resultSet.next()) {
				ShipmentOrderView orderView = new ShipmentOrderView(
						resultSet.getInt(1),
						resultSet.getString(2), 
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getInt(5),
						resultSet.getInt(6));
				orderViews.add(orderView);
				priceTotal += orderView.getCount()*orderView.getShipmentPrice();
			}
			request.setAttribute("priceTotal", priceTotal);
			request.setAttribute("orderViews", orderViews);
            request.getRequestDispatcher("/orders.jsp").forward(request,response);
		} catch (SQLException | ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}

}
