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

import com.nis.controller.VehiclesController;

/**
 * Servlet implementation class DisplayAllVehicles
 */
@WebServlet("/DisplayAllVehicles")
public class DisplayAllVehicles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllVehicles() {
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
			String nv="Employee Id:"+ses.getValue("ID").toString()+"&nbsp;&nbsp;&nbsp;"+ses.getValue("NAME").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LTIME")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src='/Parking/images/"+ses.getValue("PICTURE")+"' width=50 height=50>";
		
			ResultSet rs=VehiclesController.displayAll();
		
		try{
			if(rs.next())
			{
	        	out.println("<html><link rel='stylesheet' href='asset/css/bootstraps.min.css' type='text/css'>");
				out.println("<body background='/Parking/images/bg.png'><center><h1 style=color:blue;>Vehicles Information</h1>");
				out.println("<table border='1' bgcolor='pink' class='table table-hover'>");
				out.println("<tr class='table-primary'><th>&nbsp;Employee ID&nbsp;</th><th>&nbsp;Vehicle No.&nbsp;</th><th>&nbsp;RFID No.&nbsp;</th><th>&nbsp;Registration No.&nbsp;</th><th>&nbsp;Mobile number&nbsp;</th><th>&nbsp;Date&nbsp;</th><th>&nbsp;Time&nbsp;</th><th>&nbsp;Amount&nbsp;</th><th>&nbsp;Duration&nbsp;</th><th>&nbsp;Status&nbsp;</th><th>&nbsp;Floor NO.&nbsp;</th><th>&nbsp;Update&nbsp;</th></tr>");
				do{
					
					out.println("<tr class='table-active'><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getShort(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td><td>"+rs.getString(10)+"</td><td>"+rs.getString(11)+"</td><td><a href='EditDeleteDisplayVehiclesByID?vid="+rs.getString(2)+"'>Edit/Delete</td></tr>");
					rs.next();
					out.println("<tr class='table-danger'><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getShort(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td><td>"+rs.getString(10)+"</td><td>"+rs.getString(11)+"</td><td><a href='EditDeleteDisplayVehiclesByID?vid="+rs.getString(2)+"'>Edit/Delete</td></tr>");

					
					
				}while(rs.next());
				out.println("</table></center></body>");
			}
			else
			{
				out.println("<h1>Record Not Found</h1>");
			}
			out.println("</html>");
			
		}catch(Exception e)
		{
			System.out.println("Error:DisplayAllVehicles"+e);
		}
		 }catch(Exception e)
		{
			response.sendRedirect("EmployeeLogin");

		}
		
	}

}
