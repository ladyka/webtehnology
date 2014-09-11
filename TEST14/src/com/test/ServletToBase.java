package com.test;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.mysql.jdbc.Driver;

@WebServlet(
		asyncSupported = true, 
		urlPatterns = { 
				"/ServletToBase"
		})
public class ServletToBase extends HttpServlet {
	
    private static final long serialVersionUID = 3L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		performTask(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		performTask(req, resp);
	}

	public void showInfo(PrintWriter out, ResultSet rs) throws SQLException {
		out.print("From DataBase:");
		while (rs.next()) {
			out.print("<br>Name:-> " + rs.getString(1) + " Phone:-> " + rs.getInt(2));
		}
	}

	public void performTask(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		try {// 1
			out = resp.getWriter();
			Class<?> myClass = null;
			//com.mysql.jdbc.Driver driver = new Driver();
			String driverClassName = "com.mysql.jdbc.Driver";
			//String driverClassName = "sun.jdbc.odbc.JdbcOdbcDriver";
			try {// 2

				//Class.forName("org.gjt.mm.mysql.Driver");
				myClass = Class.forName(driverClassName);
				// дл€ MSAccess
				/* return "sun.jdbc.odbc.JdbcOdbcDriver" */
				// дл€ PostgreeSQL
				/* return " org.postgreesql.Driver " */
				Connection cn = null;
				try {// 3
					cn = DriverManager.getConnection("jdbc:mysql://localhost/db2", "root", "");
					// дл€ MSAccess
					/* return "jdbc:odbc:db2"; */
					// дл€ PostgreeSQL
					/* return "jdbc:postgreesql://localhost/db2"; */

					Statement st = null;
					try {// 4
						st = cn.createStatement();
						ResultSet rs = null;
						try {// 5
							rs = st.executeQuery("SELECT * FROM users");
							out.print("From DataBase:");
							while (rs.next()) {
								out.print("<br>Name:-> " + rs.getString(1) + " Phone:-> " + rs.getInt(2));
							}
						} finally {// дл€ 5-го блока try
							/*
							 * закрыть ResultSet, если он был открыт и ошибка
							 * произошла во врем€ чтени€ из него данных
							 */
							// проверка успел ли создатьс€ ResultSet
							if (rs != null)
								rs.close();
							else
								out.print("ошибка во врем€ чтени€ данных из Ѕƒ");
						}
					} finally {// дл€ 4-го блока try
						/*
						 * закрыть Statement, если он был открыт и ошибка
						 * произошла во врем€ создани€ ResultSet
						 */
						// проверка успел ли создатьс€ Statement
						if (st != null)
							st.close();
						else
							out.print("Statement не создан");
					}
				} finally {// дл€ 3-го блока try
					/*
					 * закрыть Connection, если он был открыт и ошибка произошла
					 * во врем€ создани€ ResultSet или создани€ и использовани€
					 * Statement
					 */
					// проверка - успел ли создатьс€ Connection
					if (cn != null)
						cn.close();
					else
						out.print("Connection не создан");
				}
			} catch (ClassNotFoundException e) {// дл€ 2-го блока try
				out.print("ошибка во врем€ загрузки драйвера Ѕƒ : " + driverClassName);
			}
		}
		/* вывод сообщени€ о всех SQLException и IOException в блоках finally, */
		/* поэтому следующие блоки catch оставлены пустыми */
		catch (SQLException e) {
		}// дл€ 1-го блока try
		catch (IOException e) {
		}// дл€ 1-го блока try
		finally {// дл€ 1-го блока try
			/*
			 * закрыть PrintWriter, если он был инициализирован и ошибка
			 * произошла во врем€ работы с Ѕƒ
			 */
			// проверка, успел ли инициализироватьс€ PrintWriter
			if (out != null)
				out.close();
			else
				System.err.println("PrintWriter не проинициализирован.");
		}
	}
}
