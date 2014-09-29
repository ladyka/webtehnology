package org.vurtatoo.ptv6;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Main
 */
@WebServlet("/main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        String pathString = getValue(request, "path");
	        File file = new File(pathString);
	        if (file.isDirectory() ) {
	            List<FileView> fileViews = new ArrayList<FileView>();
	            
	            for (String myFile : file.list()) {
	                try {
	                    FileView fileView = new FileView(myFile, pathString + System.getProperty("file.separator") + myFile );
	                    System.out.println(fileView);
	                    fileViews.add(fileView);
	                } catch (Exception ex) {
	                    ex.printStackTrace();
	                }
                    
                }
	            request.setAttribute("files", fileViews);
	            request.getRequestDispatcher("/folder.jsp").forward(request,response);
	        } else {
	            PrintWriter printWriter = response.getWriter();
	            Scanner scanner = new Scanner(file);
	            while (scanner.hasNext()) {
	                printWriter.append(scanner.nextLine());
	            }
	            scanner.close();
	            printWriter.close();
	        }
	    } catch (ServletException | IOException ex) {
	        ex.printStackTrace();
	        System.err.println("Что-то не так, вернитесь назад и повторите снова.");
	    }
		
	}

	protected String getValue(HttpServletRequest request,String string) {
        return request.getParameter(string);
    }
}
