package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.controller.EmployeesController;
import com.nis.dao.DbHelper;

/**
 * Servlet implementation class DisplayAllEmployees
 */
@WebServlet("/DisplayAllEmployees")
public class DisplayAllEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllEmployees() {
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

		
		try{
			
		    ResultSet rs=EmployeesController.displayAll();
		if(rs.next())
		{
        	out.println("<html><link rel='stylesheet' href='asset/css/bootstraps.min.css' type='text/css'>");
			out.println("<body background='/Parking/images/bg.png'><center><table border=1 class='table table-hover'><h1 style='color:blue;'><b><i>List of Employees</i></b></h1>");
			 out.println("<tr class='table-primary'><th>Employee</th><th>DOB<br>Gender</th><th>Address</th><th>Contact<br>Information</th><th>Designation<br>Salary</th><th>Update</th></tr>");
			do
			{
				out.println("<tr class='table-danger'><td>"+rs.getString(2)+"<br><img src='/Parking/images/"+rs.getString(12)+"' width=100 height=100><br>"+rs.getString(1)+"</td><td>"+rs.getString(4)+"<br>"+rs.getString(3)+"</td><td>"+rs.getString(5)+"<br>"+rs.getString(14)+","+rs.getString(13)+"</td><td>"+rs.getString(10)+"<br>"+rs.getString(11)+"</td><td>"+rs.getString(8)+"<br>"+rs.getString(9)+"</td><td><a href='EditDeleteDisplayByID?eid="+rs.getString(1)+"'>Edit/Delete</td></tr>");
				rs.next();
				out.println("<tr class='table-success'><td>"+rs.getString(2)+"<br><img src='/Parking/images/"+rs.getString(12)+"' width=100 height=100><br>"+rs.getString(1)+"</td><td>"+rs.getString(4)+"<br>"+rs.getString(3)+"</td><td>"+rs.getString(5)+"<br>"+rs.getString(14)+","+rs.getString(13)+"</td><td>"+rs.getString(10)+"<br>"+rs.getString(11)+"</td><td>"+rs.getString(8)+"<br>"+rs.getString(9)+"</td><td><a href='EditDeleteDisplayByID?eid="+rs.getString(1)+"'>Edit/Delete</td></tr>");

				
			}while(rs.next());
		    out.println("</table></center>");
			
		}
		else
		{
			System.out.println("Record not found");
		}
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		out.println("</body></html>");
		
		}catch(Exception e)
		{
			response.sendRedirect("AdminLogin");
		}
		out.println("</html>");
	}

}
