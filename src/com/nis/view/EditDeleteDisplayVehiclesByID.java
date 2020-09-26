package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.VehiclesController;
import com.nis.model.Vehicle;

/**
 * Servlet implementation class EditDeleteDisplayVehiclesByID
 */
@WebServlet("/EditDeleteDisplayVehiclesByID")
public class EditDeleteDisplayVehiclesByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDeleteDisplayVehiclesByID() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		Vehicle V=new Vehicle();
		V=VehiclesController.displayAllVehiclesByID(Integer.parseInt(request.getParameter("vid")));
		out.println("<html>");
		out.println("<link rel='stylesheet' href='asset/css/bootstraps.min.css' type='text/css'>");
		out.println("<body background='/Parking/images/bg.png'><form action='FinalEditDeleteVehiclesByID'><b><i><h1>Edit Vehicle Information</h1></i></b><table>");
		out.println("<tr><td><i><b>Employee ID:</b></i></td><td><input type='number' name='eid' id='eid' value='"+V.getEmployeeid()+"'></td></tr>");	
		out.println("<tr><td><i><b>Vehicle ID:</b></i></td><td><input type='text' name='vid' id='vid'' value='"+V.getVehicleno()+"'></td></tr>");
		out.println("<tr><td><i><b>RFID No.:</b></i></td><td><input type='text' name='rfid' id='rfid'' value='"+V.getRFIDno()+"'></td></tr>");
		out.println("<tr><td><i><b>Registration No.:</b></i></td><td><input type='text' name='regno' id='regno'' value='"+V.getRegistrationno()+"'></td></tr>");
		out.println("<tr><td><i><b>Mobile NO.:</b></i></td><td><input type='text' name='mobileno' id='mobileno'' value='"+V.getMobileno()+"'></td></tr>");
		out.println("<tr><td><i><b>Current Date:</b></i></td><td><input type='date' name='cdate' id='cdate'' value='"+V.getCurrentdate()+"'></td></tr>");
		out.println("<tr><td><i><b>Current Time:</b></i></td><td><input type='Time' name='ctime' id='ctime'' value='"+V.getCurrenttime()+"'></td></tr>");
		out.println("<tr><td><i><b>Amount:</b></i></td><td><input type='text' name='amount' id='amount'' value='"+V.getAmount()+"'></td></tr>");
		out.println("<input type='hidden' name='hduration' value='"+V.getDuration()+"'>");
		out.println("<tr><td><i><b>Duration:</b></i></td><td><select name='duration' id='duration'><option>-select-</option><option>1</option><option>2</option><option>3</option><option>4</option><option>5</option></select>"+V.getDuration()+"</td></tr>");
		out.println("<input type='hidden' name='hstatus' value='"+V.getStatus()+"'>");
		out.println("<tr><td><i><b>Status:</b></i></td><td><select name='status' id='status'><option>-select-</option><option>IN</option><option>OUT</option></select>"+V.getStatus()+"</td></tr>");
		out.println("<tr><td><i><b>Floor No.:</b></i></td><td><input type='number' name='floorno' id='floorno'' value='"+V.getFloorno()+"'></td></tr>");
		out.println("</table><br><input type='submit' name='submit' class='btn btn-success' value='Update'>&nbsp;&nbsp;<input type='submit' name='submit' class='btn btn-primary' value='Delete'></form></body></html>");
	}

}
