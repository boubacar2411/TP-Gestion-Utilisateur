package dao;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.System;

/**
 * Servlet implementation class ConnectionDB
 */
@WebServlet("/ConnectionDB")
public class ConnectionDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectionDB() {

        super();
    	
        // TODO Auto-generated constructor stub
    }
	public  static Connection getCon() {
		Connection myCon=null;
		 try {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	            myCon= DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionsusers","root","");
          //  System.out.println("ok");
	        } catch (Exception e) {
            System.out.println("err");
	            e.printStackTrace();
	        }
		 return myCon;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("TEST CONNECTION");
		//ConnectionDB c = new ConnectionDB();
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}