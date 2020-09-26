package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
    	out.println("<html><link rel='stylesheet' href='asset/css/bootstraps.min.css' type='text/css'>");
    	out.println("<nav class='navbar navbar-expand-lg navbar-dark bg-dark'><a class='navbar-brand' href='#'><h2><font color='yellow'>Parking</font></h2></a>&nbsp;&nbsp;&nbsp;&nbsp;<button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#navbarColor01' aria-controls='navbarColor01' aria-expanded='false' aria-label='Toggle navigation'><span class='navbar-toggler-icon'></span></button>");
    	out.println("<div class='collapse navbar-collapse' id='navbarColor01'><form class='form-inline my-2 my-lg-0'>	<ul class='navbar-nav mr-auto'><li class='nav-item active'><a class='nav-link' href='HomePage'>HOMEPAGE<span class='sr-only'>(current)</span></a></li></ul>	</ul></form></div></nav>");

		out.println("<html><h1><i><b>Admin Login</b></i></h1><br><body background='/Parking/images/bg.png'><form action='CheckAdminLogin' method='post'>");
		
		out.println("<table width='300'>");
		out.println("<tr><td><i><b>Admin Id:</b></i></h1></td></tr><tr><td><input type='text' name='id' placeholder='Enter ID' required></td></tr><tr><td>&nbsp;</td></tr>");
		out.println("<tr><td><i><b>Password:</b></i></h1></td></tr><tr><td><input type='password' name='password' placeholder='Enter password' required></td></tr></table><br><br>");
		out.println("<input type='submit' name='submit'></form></table></body></html>");
		out.flush();
	}

}
