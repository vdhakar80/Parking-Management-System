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
 * Servlet implementation class EmployeeView
 */
@WebServlet("/EmployeeView")
public class EmployeeView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	PrintWriter out=response.getWriter();
	HttpSession ses=request.getSession();
	try{
		String nv="Admin Id:"+ses.getValue("ADMINID").toString()+"&nbsp;&nbsp;&nbsp;"+ses.getValue("ADMINNAME").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LTIME")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src='/Parking/images/"+ses.getValue("ADMINPICTURE")+"' width=50 height=50>";

	
	out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
	out.println("<script src='asset/StateCity.js'></script>");
	out.println("<html><head><title>Employee Register</title></head>");
	
	out.println("<link rel='stylesheet' href='asset/css/bootstraps.min.css' type='text/css'>");
	out.println("<body background='/Parking/images/bg.png'>");
	out.println("<br><b><i><h1><font color='blue'>Employee register</font></h1></b></i><form action='EmployeeSubmit' method='post'  enctype='multipart/form-data'>");
	out.println("<br><table>");
	out.println("<tr><td><b><i>Employee Name:</i></b></td><td><input type='text' class='form-control' name='en' required></td></tr><tr><td></td></tr>");
	out.println("<tr><td><b><i>Gender:</i></b></td><td><input type='radio' name='eg' value='male' checked>Male<input type='radio' name='eg' value='female'>Female</td></tr><tr><td></td></tr>");
	out.println("<tr><td><b><i>BirthDate:</i></b></td><td><input type='date' name='edob' required></td></tr><tr><td></td></tr>");
	out.println("<tr><td><b><i>Address:</i></b></td><td><textarea name='eadd' class='form-control' required></textarea></td></tr><tr><td></td></tr>");
	out.println("<tr><td><b><i>State:</i></b></td><td><select id='estate' name='estate' required><option>--Select--</option></select></td></tr><tr><td></td></tr>");
	out.println("<tr><td><b><i>City:</i></b></td><td><select id='ecity' name='ecity' required><option>--Select--</option></td></select></tr><tr><td></td></tr>");
	out.println("<tr><td><b><i>Designation:</i></b></td><td><input type='text' class='form-control' name='edes' required></td></tr><tr><td></td></tr>");
	out.println("<tr><td><b><i>Salary:</i></b></td><td><input type='number' class='form-control' name='esal' required></td></tr><tr><td></td></tr>");
	out.println("<tr><td><b><i>Email:</i></b></td><td><input type='mail' class='form-control' name='email' required></td></tr><tr><td></td></tr>");
	out.println("<tr><td><b><i>MobileNo.:</i></b></td><td><input type='text' class='form-control' name='emobile' required></td></tr><tr><td></td></tr>");
    out.println("<tr><td><b><i>Picture:</i></b></td><td><input type='file'  name='epic' required></td></tr><tr><td></td></tr>");
	out.println("<tr><td><b><i>Password:</i></b></td><td><input type='password' class='form-control' name='epwd' required></td></tr><tr><td>&nbsp;</td></tr>");
	out.println("<tr><td><input type='submit' class='btn btn-success' name='submit' value='SUBMIT'></td><td><input type='reset' class='btn btn-primary' name='reset' value='RESET'></td></tr></table></form></body></html>");
	}catch(Exception e)
	{
		response.sendRedirect("AdminLogin");
		
	}
	}
}
