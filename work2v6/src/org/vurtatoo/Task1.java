package org.vurtatoo;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class OrderInfo
 */
@WebServlet("/task1")
public class Task1 extends MyServlet {
	private static final long serialVersionUID = 10L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Task1() {
        super();
    }

	@Override
	protected void doGet(PrintWriter printWriter, Statement statement) {
		int orderId = getValueInt("id");
		ResultSet resultSet;
		try {
			resultSet = statement.executeQuery(SQLREQUESTS.getOrderInfoSQL(orderId));
			while (resultSet.next()) {
				printWriter.append(resultSet.getString(1) + "<br>\n");
				printWriter.append(resultSet.getString(2) + "<br>\n");
				printWriter.append(resultSet.getString(3) + "<br>\n");
				printWriter.append("<br>\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
