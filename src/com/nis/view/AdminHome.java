package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminHome
 */
@WebServlet("/AdminHome")
public class AdminHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<html>");
		HttpSession ses=request.getSession();
		try{
			
			String nv="Admin Id:"+ses.getValue("ADMINID").toString()+"&nbsp;&nbsp;&nbsp;"+ses.getValue("ADMINNAME").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LTIME")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src='/Parking/images/"+ses.getValue("ADMINPICTURE")+"' width=50 height=50>";
        	out.println("<html><link rel='stylesheet' href='asset/css/bootstraps.min.css' type='text/css'>");
            out.println("<html><body background='/Parking/images/bg.png'>");
        	out.println("<nav class='navbar navbar-expand-lg navbar-dark bg-dark'><a class='navbar-brand' href='#'><h2><font color='yellow'>Parking</font></h2></a>&nbsp;&nbsp;&nbsp;&nbsp;<button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#navbarColor01' aria-controls='navbarColor01' aria-expanded='false' aria-label='Toggle navigation'><span class='navbar-toggler-icon'></span></button>");
        	out.println("<div class='collapse navbar-collapse' id='navbarColor01'><ul class='navbar-nav mr-auto'><h2><font color='blue'>"+nv+"</font></h2></ul><form class='form-inline my-2 my-lg-0'>		<ul class='navbar-nav mr-auto'><li class='nav-item active'><a class='nav-link' href='AdminLogout'>Logout<span class='sr-only'>(current)</span></a></li></ul></form></div></nav>");
            out.println("<table><tr><td valign='top'>");
            out.println("<br><br><a href='EmployeeView' target='mw'>Add Employee</a><br>");
            out.println("<a href='DisplayAllEmployees' target='mw'> Display All</a><br>");
            out.println("<a href='SearchEmployeeById' target='mw'> Search</a><br>");
            out.println("<a href='FloorView' target='mw'>Add Floor</a><br></td>");
            out.println("<td valign='top'>&nbsp;&nbsp;&nbsp;&nbsp;<iframe frameborder='0' width='1200' height='1200' name='mw'></iframe></td></tr>");
			
		}catch(Exception e)
		{
			response.sendRedirect("AdminLogin");
		}
		out.println("</html>");
	}

}
