package com.creators.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update
 */
@WebServlet(
		urlPatterns = { "/Update" }, 
		initParams = { 
				@WebInitParam(name = "mobileName", value = "default"), 
				@WebInitParam(name = "modelName", value = "default"), 
				@WebInitParam(name = "modelId", value = "default"), 
				@WebInitParam(name = "reviews", value = "default"), 
				@WebInitParam(name = "ratings", value = "default"), 
				@WebInitParam(name = "id", value = "default")
		})
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mobileName = request.getParameter("mobileName");
		String modelName = request.getParameter("modelName");
		String modelId = request.getParameter("modelId");
		String reviews = request.getParameter("reviews");
		double ratings = Double.parseDouble(request.getParameter("ratings"));
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(mobileName+modelName+modelId+reviews+ratings+id);
		try(PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
				out.println("<head>");
					out.println("<title>Update Reviews | Mobile Buff</title>");
					out.println("<link type = \"text/css\" rel=\"stylesheet\" href=\"mobileBuffStyling.css\">");
				out.println("</head>");
				out.println("<body>");
					request.getRequestDispatcher("nav.html").include(request,response);
					out.println("<form action = \"Updation?id="+id+"\" method = \"post\">");
						out.println("<table>");
							out.println("<table>");
								out.println("<tr><td>Mobile Name</td><td><input type = \"text\" name = \"mobileName\" value = '"+mobileName+"'></td></tr>");
								out.println("<tr><td>Model Name</td><td><input type = \"text\" name = \"modelName\" value = '"+modelName+"'></td></tr>");
								out.println("<tr><td>Model ID</td><td><input type = \"text\" name = \"modelId\" value = '"+modelId+"'></td></tr>");
								out.println("<tr><td>Reviews</td><td><input type = \"text\" name = \"reviews\" value = '"+reviews+"'></td></tr>");
								out.println("<tr><td>Ratings</td><td><input type = \"text\" name = \"ratings\" value = '"+ratings+"'></td></tr>");
								out.println("<tr><td><input type = \"submit\" name = \"submit\" value=\"update\"></td></tr>");
						out.println("</table>");
					out.println("</form>");
				out.println("</body>");
			out.println("</html>");
		}
	}

}

