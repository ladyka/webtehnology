package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
				// ��� MSAccess
				/* return "sun.jdbc.odbc.JdbcOdbcDriver" */
				// ��� PostgreeSQL
				/* return " org.postgreesql.Driver " */
				Connection cn = null;
				try {// 3
					cn = DriverManager.getConnection("jdbc:mysql://localhost/db2", "root", "");
					// ��� MSAccess
					/* return "jdbc:odbc:db2"; */
					// ��� PostgreeSQL
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
						} finally {// ��� 5-�� ����� try
							/*
							 * ������� ResultSet, ���� �� ��� ������ � ������
							 * ��������� �� ����� ������ �� ���� ������
							 */
							// �������� ����� �� ��������� ResultSet
							if (rs != null)
								rs.close();
							else
								out.print("������ �� ����� ������ ������ �� ��");
						}
					} finally {// ��� 4-�� ����� try
						/*
						 * ������� Statement, ���� �� ��� ������ � ������
						 * ��������� �� ����� �������� ResultSet
						 */
						// �������� ����� �� ��������� Statement
						if (st != null)
							st.close();
						else
							out.print("Statement �� ������");
					}
				} finally {// ��� 3-�� ����� try
					/*
					 * ������� Connection, ���� �� ��� ������ � ������ ���������
					 * �� ����� �������� ResultSet ��� �������� � �������������
					 * Statement
					 */
					// �������� - ����� �� ��������� Connection
					if (cn != null)
						cn.close();
					else
						out.print("Connection �� ������");
				}
			} catch (ClassNotFoundException e) {// ��� 2-�� ����� try
				out.print("������ �� ����� �������� �������� �� : " + driverClassName);
			}
		}
		/* ����� ��������� � ���� SQLException � IOException � ������ finally, */
		/* ������� ��������� ����� catch ��������� ������� */
		catch (SQLException e) {
		}// ��� 1-�� ����� try
		catch (IOException e) {
		}// ��� 1-�� ����� try
		finally {// ��� 1-�� ����� try
			/*
			 * ������� PrintWriter, ���� �� ��� ��������������� � ������
			 * ��������� �� ����� ������ � ��
			 */
			// ��������, ����� �� ������������������ PrintWriter
			if (out != null)
				out.close();
			else
				System.err.println("PrintWriter �� ������������������.");
		}
	}
}
