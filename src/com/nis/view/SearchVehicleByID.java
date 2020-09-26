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
 * Servlet implementation class SearchVehicleByID
 */
@WebServlet("/SearchVehicleByID")
public class SearchVehicleByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchVehicleByID() {
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
		
		out.println("<html>");
    	out.println("<form action='EditDeleteDisplayVehiclesByID'>");
    	out.println("<center><br><br><br><br><table><caption><b>Search Vehicle By Id..</b></caption>");
    	out.println("<tr><td><b><i>Vehicle Id:</i></b></td><td><input type=text name=vid size=30 required></td><td><input type=submit></td></tr>");
    	
    	out.println("</table><center></form></html>");
    	
    	out.flush();	
		}catch(Exception e)
		{
			response.sendRedirect("EmployeeLogin");

		}}

}
