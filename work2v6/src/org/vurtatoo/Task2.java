package org.vurtatoo;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;

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
	protected void doGet(PrintWriter printWriter, Statement statement) {
		int price = getValueInt("price");
		int shipments = getValueInt("shipments");
		try {
			ResultSet resultSet = statement.executeQuery(SQLREQUESTS.getListOrdersSQL(price, shipments));
			while (resultSet.next()) {
				printWriter.append(resultSet.getString(1) + "\n");
			}
		} catch (SQLException e) {
			printWriter.write(e.getSQLState());
			printWriter.write(e.getLocalizedMessage());
		}
		
	}




}
