package org.vurtatoo;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class MyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 16L;
	
	String requestSQL;
	
	public MyServlet() {
		super();
	}
	
	protected final void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html; charset=utf-8");
		MysqlManager mysqlManager = new MysqlManager();
		try {
			Statement statement = mysqlManager.createStatement();
			doGet(request,response,statement);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				mysqlManager.close();
			} catch (SQLException e) {
			}
		}
		
	}
	
	protected abstract void doGet(HttpServletRequest request, HttpServletResponse response,Statement statement);
	
	protected int getValueInt(HttpServletRequest request,String string) {
		return Integer.valueOf(getValue(request,string));
	}

	protected String getValue(HttpServletRequest request,String string) {
	    return request.getParameter(string);
	}

}
