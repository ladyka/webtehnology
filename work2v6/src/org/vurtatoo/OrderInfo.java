package org.vurtatoo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderInfo
 */
@WebServlet("/order")
public class OrderInfo extends HttpServlet {
	private static final long serialVersionUID = 10L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer orderId = null;
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			pw.append("hello");
			orderId = Integer.parseInt(request.getParameter("id"));
			if (orderId !=null) {
				
			}
		} catch (Exception ex) {
			
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}

}
