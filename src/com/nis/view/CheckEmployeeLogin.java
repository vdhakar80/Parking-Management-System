package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.controller.AdminController;
import com.nis.controller.EmployeesController;
import com.nis.model.Admin;
import com.nis.model.Employees;

/**
 * Servlet implementation class CheckEmployeeLogin
 */
@WebServlet("/CheckEmployeeLogin")
public class CheckEmployeeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckEmployeeLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
		String btn=request.getParameter("submit");
		if(btn.equals("Login"))
		{
		out.println("<html>");
		try{
		int eid=Integer.parseInt(request.getParameter("id"));
		String password=request.getParameter("password");
		Employees E=EmployeesController.checkEmployees(eid, password);
		if(E!=null)
		{
			HttpSession ses=request.getSession();
			ses.putValue("ID", E.getEmployeeid());
			ses.putValue("NAME", E.getEmployeename());
			ses.putValue("PICTURE", E.getPicture());
			ses.putValue("LTIME", new Date());
			response.sendRedirect("EmployeesHome");
			
		}else
		{
			out.println("<font color='red'>Invalid id or password</font>");
		}
		}catch(Exception e)
		{
			out.println("<font color='red'>Invalid id or password</font>");

			System.out.println("Error:EmployeeLogin"+e);
		}
		out.println("</html>");
		}
		else if(btn.equals("Login With Otp"))
	 	{
		  Employees E=EmployeesController.displayAllByID(Integer.parseInt(request.getParameter("id")));	
		 if(E==null)
		 {}
		 else
		 { String name=E.getEmployeename();
		   String mob=E.getMobileno();
		   out.println("<html><link rel='stylesheet' href='asset/css/bootstraps.min.css' type='text/css'>");
	    	out.println("<nav class='navbar navbar-expand-lg navbar-dark bg-dark'><a class='navbar-brand' href='#'><h2><font color='yellow'>Parking</font></h2></a>&nbsp;&nbsp;&nbsp;&nbsp;<button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#navbarColor01' aria-controls='navbarColor01' aria-expanded='false' aria-label='Toggle navigation'><span class='navbar-toggler-icon'></span></button>");
	    	out.println("<div class='collapse navbar-collapse' id='navbarColor01'><form class='form-inline my-2 my-lg-0'>	<ul class='navbar-nav mr-auto'><li class='nav-item active'><a class='nav-link' href='HomePage'>HOMEPAGE<span class='sr-only'>(current)</span></a></li></ul>	</ul></form></div></nav>");

		   out.println("<html><body background='/Parking/images/bg.png' >");
		   out.println("<form action='CheckOtp' method=post>");

		   int otp=(int)((Math.random()*8999)+1000);
		   out.println("<input type='hidden' name='otp' value='"+otp+"'>");
		   out.println("<input type='hidden' name='id' value='"+request.getParameter("id")+"'>");
		   out.println("<center><table>");
		   out.println("<tr><td><b><i>Name:</i><b></td><td>"+name+"</td></tr>");
		   String em="xxxxxx"+mob.substring(8);
		   out.println("<tr><td><b><i>Mobile:</i><b></td><td>"+em+"</td></tr>");
		   out.println("<tr><td><b><i>Otp:</i><b></td><td><input type=password name='uotp'></td></tr>");
		   out.println("</table>");
		   out.println("<input type='submit'></center></body></html>");
	   
		   SmsServlet S=new SmsServlet();

		   S.SendSms("COM5", mob,otp+"");

			 
		 }
			
			
			
	 	}
		
		
	}

}
