package com.creators.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Create
 */
@WebServlet("/Create")
public class Create extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Create() {
	    super();
	    // TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			//ResultSet rs = st.executeQuery("select * from mobReviews");
			st.executeUpdate("insert into mobReviews (mobileName,modelName,modelId,reviews,ratings) values('"+mobileName+"','"+modelName+"','"+modelId+"','"+reviews+"',"+ratings+")");
			response.sendRedirect("index.html");
		} catch (Exception e) {
			// TODO Auto-generated catch block
						e.printStackTrace();
		}								
	}
}
