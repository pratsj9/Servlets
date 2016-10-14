package com.Register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.apache.catalina.startup.ContextConfig;


/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends GenericServlet {
	RequestDispatcher view;
	RequestDispatcher fw;
	PrintWriter out;
	
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }
    
  

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		 view = request.getRequestDispatcher("Login.html");
		fw = request.getRequestDispatcher("Welcome.html");
		out= response.getWriter();
		view.include(request, response);
		
		if(request.getAttribute("usernm")!=null)
		{	
		fw.forward(request, response);}
		
		else
		{
			
		}

		 
			
		
		
		
		
		
		
	}

}
