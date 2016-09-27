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
 * Servlet implementation class Updation
 */
@WebServlet(
		urlPatterns = { "/Updation" }, 
		initParams = { 
				@WebInitParam(name = "id", value = "default")
		})
public class Updation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mobileName = request.getParameter("mobileName");
		String modelName = request.getParameter("modelName");
		String modelId = request.getParameter("modelId");
		String reviews = request.getParameter("reviews");
		double ratings = Double.parseDouble(request.getParameter("ratings"));
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/mobuf","root","");
			Statement st = con.createStatement();
			st.executeUpdate("update mobReviews set mobileName ='"+mobileName+"',modelName ='"+modelName+"' ,modelId ='"+modelId+"' ,reviews ='"+reviews+"' ,ratings ='"+ratings+"' where id = "+id+" ");
			response.sendRedirect("index.html");
		} catch(Exception e) {
			System.out.println(e);
		}
	}

}
