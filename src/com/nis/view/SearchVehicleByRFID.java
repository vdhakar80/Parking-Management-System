package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.controller.VehiclesController;

/**
 * Servlet implementation class SearchVehicleByRFID
 */
@WebServlet("/SearchVehicleByRFID")
public class SearchVehicleByRFID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchVehicleByRFID() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		HttpSession ses=request.getSession();
		try{
			String nv="Employee Id:"+ses.getValue("ID").toString()+"&nbsp;&nbsp;&nbsp;"+ses.getValue("NAME").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LTIME")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src='/Parking/images/"+ses.getValue("PICTURE")+"' width=50 height=50>";
		
		out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
		out.println("<script src='asset/vehicle.js'></script>");
		out.println("<link rel='stylesheet' href='asset/css/bootstraps.min.css' type='text/css'><html>");
		String rfidno=VehiclesController.ReadRFID(); 
		
		out.println("<body background='/Parking/images/bg.png'>");

        out.println("<center><h2 style='color:blue;'>Search Vehicle By RFID No.</h2><br><input type='text' id='rfidno' value='"+rfidno+"' name='rfidno' required><br><br>");
        out.println("<input type='button' id='btn' name='btn' value='submit' class='btn btn-success'><div id='fdiv' name='fdiv'></div></center></html>");
        out.println("<div id='div1'></div>");
		}catch(Exception e)
		{
			response.sendRedirect("EmployeeLogin");

		}
        

	}

}
