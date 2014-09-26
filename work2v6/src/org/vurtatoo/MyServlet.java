package org.vurtatoo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class MyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 16L;
	
	String requestSQL;
	private HttpServletRequest request;
	//private HttpServletResponse response;
	
	public MyServlet() {
		super();
	}
	
	protected final void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.request = request;
		//this.response = response;
		response.setContentType("text/html; charset=utf-8");
		MysqlManager mysqlManager = new MysqlManager();
		PrintWriter printWriter = null;
		try {
			printWriter = response.getWriter();
			Statement statement = mysqlManager.createStatement();
			doGet(printWriter,statement);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (printWriter != null) {
					printWriter.close();
				}
			} catch (Exception e) {
			}
			try {
				mysqlManager.close();
			} catch (SQLException e) {
			}
		}
		
	}
	
	protected abstract void doGet(PrintWriter printWriter,Statement statement);
	
	protected int getValueInt(String string) {
		return Integer.valueOf(getValue(string));
	}

	protected String getValue(String string) {
		return request.getParameter(string);
	}

}
