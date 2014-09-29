package org.vurtatoo.ptv4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Task4
 */
@WebServlet("/task4")
public final class Task4 extends HttpServlet {
	private static final long serialVersionUID = 31L;

	public Task4() {
		super();
	}

	/**
	 * это говно пересылается сюда
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String browser = getValue(request, "browser"); //берётся параметр 
		PrintWriter printWriter = response.getWriter();
		switch (browser) {//вот он
		case "cube": {
			String cube_l = getValue(request, "cube_l");
			printWriter.append(String.valueOf(Calculator.getCubeVolume(cube_l)));
		}	
			break;

		case"parallelepiped": {
			String p_l = getValue(request, "p_l");
			String p_w = getValue(request, "p_w");
			String p_h = getValue(request, "p_h");
			printWriter.append(String.valueOf(Calculator.getParallelepipedVolume(p_l, p_w, p_h))); //вычісляется і в браузер піхается
		} break;
		
		case "sphere": {
			String s_R = getValue(request, "s_R");
			printWriter.append(String.valueOf(Calculator.getSphereVolume(s_R)));
		} break;
		
		case "torus": {
			String t_R1 = getValue(request, "t_R1");
			String t_R2 = getValue(request, "t_R2");
			printWriter.append(String.valueOf(Calculator.getTorusVolume(t_R1, t_R2)));
		} break;
		case "tetrahedron": {
			String a = getValue(request, "a");
			String b = getValue(request, "b");
			String c = getValue(request, "c");
			String h = getValue(request, "h");
			printWriter.append(String.valueOf(Calculator.getTetrahedronVolume(a, b, c, h)));
		} break;
		default: {
			
			printWriter.append("FAIL :( " );
			
		}
			break;
		}
		printWriter.close(); //всё
	}

	protected String getValue(HttpServletRequest request, String string) {
		return request.getParameter(string);
	}
}
