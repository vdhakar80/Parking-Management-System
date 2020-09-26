package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.EmployeesController;
import com.nis.model.Employees;

/**
 * Servlet implementation class EditDeleteDisplayByID
 */
@WebServlet("/EditDeleteDisplayByID")
public class EditDeleteDisplayByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDeleteDisplayByID() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		Employees E=EmployeesController.displayAllByID(Integer.parseInt(request.getParameter("eid")));
		out.println("<html>");
		String s[]=E.getState().split(",");
		String c[]=E.getCity().split(",");
		if(E!=null)
		{
        	out.println("<html><link rel='stylesheet' href='asset/css/bootstraps.min.css' type='text/css'>");

			out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
			out.println("<script src='asset/StateCity.js'></script>");
			out.println("<html><head><title>Employee Register</title></head>");
			out.println("<body background='/Parking/images/bg.png'>");
			out.println("<form action='FinalEditDeleteEmployee' method='post'  enctype='multipart/form-data'><b><i><h1 style='color:rendering;'>Employee register</h1></b></i>");
			out.println("<table><tr><td><table>");
			out.println("<tr><td><b><i>Employee ID:</i></b></td><td><input type='text' name='eid' value='"+E.getEmployeeid()+"'></td></tr>");
			out.println("<tr><td><b><i>Employee Name:</i></b></td><td><input type='text' name='en'  value='"+E.getEmployeename()+"'></td></tr>");
			if(E.getGender().equals("male"))
			out.println("<tr><td><b><i>Gender:</i></b></td><td><input type='radio' name='eg' value='male' checked>Male<input type='radio' name='eg' value='female'>Female</td></tr>");
			else
				out.println("<tr><td><b><i>Gender:</i></b></td><td><input type='radio' name='eg' value='male' >Male<input type='radio' name='eg' value='female' checked>Female</td></tr>");	
			out.println("<tr><td><b><i>BirthDate:</i></b></td><td><input type='date' name='edob' value='"+E.getDob()+"'></td></tr>");
			out.println("<tr><td><b><i>Address:</i></b></td><td><textarea name='eadd' >"+E.getAddress()+"</textarea></td></tr>");
		    out.println("<input type='hidden' name='stateid' value='"+s[0]+"'>");
			out.println("<tr><td><b><i>State:</i></b></td><td><select id='estate' name='estate' required><option>--Select--</option></select>"+s[1]+"</td></tr>");
			out.println("<input type='hidden' name='cityid' id='cityid' value='"+c[0]+"'>");
			out.println("<tr><td><b><i>City:</i></b></td><td><select id='ecity' name='ecity' required><option>--Select--</option></select>"+c[1]+"</td></tr>");
			out.println("<tr><td><b><i>Designation:</i></b></td><td><input type='text' name='edes' value='"+E.getDesignation()+"'></td></tr><br>");
			out.println("<tr><td><b><i>Salary:</i></b></td><td><input type='number' name='esal' value='"+E.getSalary()+"'></td></tr>");
			out.println("<tr><td><b><i>Email:</i></b></td><td><input type='mail' name='email' value='"+E.getEmail()+"'></td></tr>");
			out.println("<tr><td><b><i>MobileNo.:</i></b></td><td><input type='text' name='emobile' value='"+E.getMobileno()+"'></td></tr>");
			out.println("<tr><td><b><i>Password:</i></b></td><td><input type='password' name='epwd' value='"+E.getPassword()+"'></td></tr>");
			out.println("<tr><td></td></tr><tr><tr><td></td></tr><tr><tr><td></td></tr><tr><td><input type='submit' class='btn btn-success' name='btn' value='UPDATE'></td><td><input type='submit' class='btn btn-primary' name='btn' value='DELETE'></td></tr></table></form></td><td>");
		    out.println("<br><img src='/Parking/images/"+E.getPicture()+"' width=350 height=350><br>");
		    out.println("<h3>Change Image</h3>");
		    out.println("<input type='file' name='picture'>&nbsp;&nbsp;&nbsp;&nbsp;");
		    out.println("<input type='submit' class='btn btn-success' name='btn' value='SAVE'></td>");
		    out.println("<table></body></html>");
		}
		else
		{
			
		}
		out.println("</html>");
		
	}

}
