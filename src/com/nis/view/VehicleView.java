package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.controller.VehiclesController;

/**
 * Servlet implementation class VehicleView
 */
@WebServlet("/VehicleView")
public class VehicleView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleView() {
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
		out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
		out.println("<script src='asset/floor.js'></script>");
		out.println("<html>");
		 String rfidno=VehiclesController.ReadRFID(); 
		 
		out.println("<link rel='stylesheet' href='asset/css/bootstraps.min.css' type='text/css'>");
		out.println("<body background='/Parking/images/bg.png'><form action='SubmitVehicle'>");
		out.println("<b><i><h1><font color='blue'>Vehicle Information</font></h1></i></b><table><tr><td><i><b>Employee ID:</b></i></td><td><input type='number' name='eid' id='eid' required></td></tr>");
		out.println("<tr><td><i><b>Vehicle ID:</b></i></td><td><input type='text' class='form-control' name='vid' id='vid' required></td></tr>");
		out.println("<tr><td><i><b>RFID No.:</b></i></td><td><input type='text' class='form-control' name='rfid' id='rfid' value='"+rfidno+"'></td></tr>");
		out.println("<tr><td><i><b>Registration No.:</b></i></td><td><input type='text' class='form-control' name='regno' id='regno' required></td></tr>");
		out.println("<tr><td><i><b>Mobile NO.:</b></i></td><td><input type='text' class='form-control' name='mobileno' id='mobileno' required></td></tr>");
		Calendar C=Calendar.getInstance();
		String cd=C.get(Calendar.YEAR)+"/"+(C.get(Calendar.MONTH)+1)+"/"+C.get(Calendar.DATE);
	    String ct=C.get(Calendar.HOUR)+":"+(C.get(Calendar.MINUTE))+":"+C.get(Calendar.SECOND);
		out.println("<tr><td><i><b>Current Date:</b></i></td><td><input type='text' name='cdate' id='cdate' value='"+cd+"' required></td></tr>");
		out.println("<tr><td><i><b>Current Time:</b></i></td><td><input type='text'  name='ctime' id='ctime' value='"+ct+"' required></td></tr>");
		out.println("<tr><td><i><b>Amount:</b></i></td><td><input type='text' class='form-control' name='amount' id='amount' required></td></tr>");
		out.println("<tr><td><i><b>Duration:</b></i></td><td><select name='duration' id='duration'><option>-select-</option><option>1</option><option>2</option><option>3</option><option>4</option><option>5</option></select></td></tr>");
		out.println("<tr><td><i><b>Status:</b></i></td><td><select name='status' id='status'><option>-select-</option><option>IN</option><option>OUT</option></td></tr>");
		out.println("<tr><td valign='top'><i><b>Floor No.:</b></i></td><td><select name='floorno' id='floorno'></select><div id='fdiv'></div></td></tr>");
		out.println("</table><br><input type='submit' name='submit' value='Submit' class='btn btn-success'></form></body></html>");
        }catch(Exception e)
		{
			response.sendRedirect("EmployeeLogin");

		}
        }

}
