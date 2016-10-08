package com.Register;

import java.io.IOException;
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
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }
    
   public boolean connector()
   {
	   ServletContext ctx=getServletConfig().getServletContext();
	    Connection con=null;
	   try {
		   	Class.forName(ctx.getInitParameter("driver"));
		   	con=DriverManager.getConnection(ctx.getInitParameter(("url")),ctx.getInitParameter("username"),ctx.getInitParameter("pass"));
		   	System.out.println("\n\tConnection Establised");
		   	} 
	   catch (Exception e) 
	   {
		e.printStackTrace();
	   }
	   if(con!=null)
	   	{
	   	return true;	
	   		
	   	}
	   	else
	   		return false;
	    
   
   } 

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = request.getRequestDispatcher("Login.html");
		if(connector())
		{
		view.forward(request, response);
		}
		else
		{
			System.out.println("\n\tConnection Failed");
		}
		
	}

}
