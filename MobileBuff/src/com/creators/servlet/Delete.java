package com.creators.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Delete
 */
@WebServlet(
		urlPatterns = { "/Delete" }, 
		initParams = { 
				@WebInitParam(name = "mobileName", value = "default"), 
				@WebInitParam(name = "modelName", value = "default"), 
				@WebInitParam(name = "modelId", value = "default"), 
				@WebInitParam(name = "reviews", value = "default"), 
				@WebInitParam(name = "ratings", value = "default")
		})
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mobileName = request.getParameter("mobileName");
		String modelName = request.getParameter("modelName");
		String modelId = request.getParameter("modelId");
		String reviews = request.getParameter("reviews");
		double ratings = Double.parseDouble(request.getParameter("ratings"));
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobuf","root","");
			Statement st = con.createStatement();
			st.executeUpdate("delete from mobReviews where mobileName = '"+mobileName+"'and modelName = '"+modelName+"' and modelId = '"+modelId+"' and reviews = '"+reviews+"' and ratings = '"+ratings+"' ");		
			response.sendRedirect("index.html");
		} catch(Exception e) {
			
		}
	}

}
