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
 * Servlet implementation class FloorView
 */
@WebServlet("/FloorView")
public class FloorView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FloorView() {
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

		out.println("<html>");
		out.println("<link rel='stylesheet' href='asset/css/bootstraps.min.css' type='text/css'>");
		out.println("<head><title>floors</title></head><body background='/Parking/images/bg.png'><form method='get' action='FloorSubmit'>");
		out.println("<br><i><b><h1><font color='blue'>FLOORS</font></h1></b></i><table>");
		out.println("<tr><td><i><b>Floor No.</b></i></td><td><input type='text' class='form-control' name='floorno' id='floorno' required></td></tr><tr><td>&nbsp;</td></tr>");
		out.println("<tr><td><i><b>Floor Name</b></i></td><td><input type='text' class='form-control' name='floorname' id='floorname' required></td></tr><tr><td>&nbsp;</td></tr>");
		out.println("<tr><td><i><b>Total Space</b></i></td><td><input type='text' class='form-control' name='totalspace' id='totalspace' required></td></tr><tr><td>&nbsp;</div></td></tr>");
		out.println("</table><input type='submit' class='btn btn-success' name='floorsubmit value='Submit'></form></body>");
		out.println("</html>");
		}catch(Exception e)
		{
			response.sendRedirect("AdminLogin");
		}
		

	}

}
