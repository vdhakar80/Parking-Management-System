package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomePage
 */
@WebServlet("/HomePage")
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomePage() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	PrintWriter out=response.getWriter();
	out.println("<html><link rel='stylesheet' href='asset/css/bootstraps.min.css' type='text/css'>");
	out.println("<nav class='navbar navbar-expand-lg navbar-dark bg-dark'><a class='navbar-brand' href='#'><h2><font color='yellow'>Parking Management System</font></h2></a>&nbsp;&nbsp;&nbsp;&nbsp;<button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#navbarColor01' aria-controls='navbarColor01' aria-expanded='false' aria-label='Toggle navigation'><span class='navbar-toggler-icon'></span></button>");
	out.println("<div class='collapse navbar-collapse' id='navbarColor01'><ul class='navbar-nav mr-auto'><h2><font color='blue'></font></h2></ul><form class='form-inline my-2 my-lg-0'>		</ul></form></div></nav>");
    out.println("<html><body background='/Parking/images/as.JPG'><table>");
	out.println("<br><br><br><br><br><br><br> <br><br><br>  <tr><td><a href='AdminLogin'><font color='blue'><h1> Admin Login </h1></font></a></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td></tr>");
	out.println("<tr><td><a href='EmployeeLogin'><font color='blue'><h1>Employee Login</h1></font></a></td></tr>");
	out.println("</table></html>");

	}

}
