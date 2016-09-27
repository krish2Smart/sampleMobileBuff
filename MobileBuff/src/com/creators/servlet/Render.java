package com.creators.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Render
 */
@WebServlet(
		urlPatterns = { "/Render" }, 
		initParams = { 
				@WebInitParam(name = "option", value = "View")
		})
public class Render extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Render() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String option = request.getParameter("option");
		try(PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
				out.println("<head>");
					if(option.equals("Create"))
						out.println("<title>Create Reviews | Mobile Buff</title>");
					else
						out.println("<title>View Reviews | Mobile Buff</title>");
					out.println("<link type = \"text/css\" rel=\"stylesheet\" href=\"mobileBuffStyling.css\">");
				out.println("</head>");
				out.println("<body>");
					request.getRequestDispatcher("nav.html").include(request,response);
					if(option.equals("create")) {
						request.getRequestDispatcher(option+".html").include(request,response);
					}
					else if(option.equals("view")) {
						out.println("<table class=\"view-Mobiles\">");
							try {
								Class.forName("com.mysql.jdbc.Driver");
								Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/mobuf","root","");
								Statement st = con.createStatement();
								ResultSet rs = st.executeQuery("select * from mobReviews");
								out.println("<tr><th>Mobile Name</th><th>Model Name</th><th>Model ID</th><th>Reviews</th><th>Ratings</th><th>Update</th><th>Delete</th></tr>");
								while(rs.next()) {
									out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getDouble(5)+"</td><td><a href=\"Update?mobileName="+rs.getString(1)+"&modelName="+rs.getString(2)+"&modelId="+rs.getString(3)+"&reviews="+rs.getString(4)+"&ratings="+rs.getDouble(5)+"&id="+rs.getInt(6)+"\"><input type=\"button\" class=\"updtBtn\"></a></td><td><a href=\"Delete?mobileName="+rs.getString(1)+"&modelName="+rs.getString(2)+"&modelId="+rs.getString(3)+"&reviews="+rs.getString(4)+"&ratings="+rs.getDouble(5)+"\"><input type=\"button\"  class=\"dltBtn\" /></a></td></tr>");
								}
							} catch(Exception e) {
								out.println(e);
							}
					}
					
				out.println("</body>");
			out.println("</html>");
		}
	}
}
