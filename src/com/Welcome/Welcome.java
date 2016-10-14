package com.Welcome;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcome() {
        super();
        // TODO Auto-generated constructor stub
    }
    public ResultSet connector(ServletRequest request,ServletResponse response) throws ServletException, IOException
    {
 	   ServletContext ctx=getServletConfig().getServletContext();
 	    Connection con=null;
 	   ResultSet rs=null;
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
 		   
 	   		try {
 	   			String pass = request.getParameter("pass");
 	   			String username = null;

 	   			System.out.println(pass);
 				PreparedStatement st = con.prepareStatement("select username from login where password=?");
 				st.setString(1, pass);
 				rs =st.executeQuery();
 				rs.next();
 				
 				if(rs!=null){System.out.println("Login Success");} else{System.out.println("Null resultset"); return null;}
 	   			
 	   			PreparedStatement sx=con.prepareStatement("select * from users;");
 	   			rs = sx.executeQuery();
 	   			
 	   			
 	   		 	   			
 	   		}
 	   		

 	   		
 	   		
 	   		catch (SQLException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
 	   		request.getAttribute("usernm");
 	   		
 	   		
 		}
	      
 	   return rs;
    } 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		RequestDispatcher print = request.getRequestDispatcher("Welcome.html");
		print.include(request, response);
		
		

		ResultSet r=connector(request, response);
		String username=null;
		try {
		
			while(r.next())
	   			{
					username=r.getString(1);
	   				out.println("	<li class='collection-item avatar'>"+"<i class='material-icons circle green'>account_circle</i>"
					+"<span class='title'>Welcome</span>"
					+"<p>"+username+"<br></p>"
					+"<a href='#!' class='secondary-content'><i class='material-icons'>grade</i></a></li>"
					);
	 	   		}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.println("</ul></div></body></html>");
		
		
		
		
		//String password=request.getParameter("pass");
		//	String Gender = request.getParameter("radiob");
		
		
	
		
		
			
		
		
		System.out.println("\n\tWelcome"+username);
		//System.out.println("\n\tPassword"+password);
		//System.out.println("\n\tGender"+Gender);
//		for(String x:langs){System.out.println("\n\t Language"+x);}
	}

}
