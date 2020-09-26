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
 * Servlet implementation class SubmitVehicle
 */
@WebServlet("/SubmitVehicle")
public class SubmitVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitVehicle() {
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
		V.setEmployeeid(Integer.parseInt(request.getParameter("eid")));
		V.setVehicleno(Integer.parseInt(request.getParameter("vid")));
		V.setRFIDno(request.getParameter("rfid"));
		V.setRegistrationno(request.getParameter("regno"));
		V.setMobileno(request.getParameter("mobileno"));
		V.setCurrentdate(request.getParameter("cdate"));
		V.setCurrenttime(request.getParameter("ctime"));
		V.setAmount(Integer.parseInt(request.getParameter("amount")));
		V.setDuration(Integer.parseInt(request.getParameter("duration")));
		V.setStatus(request.getParameter("status"));
		V.setFloorno(Integer.parseInt(request.getParameter("floorno")));
		boolean status=VehiclesController.addVehicle(V);
		VehiclesController.RemoveRFID();
		if(status)
		{
			out.println("<html>");
			out.println("<h1>record submmited</h1>");
			out.println("</html>");
		}
		else
		{
			out.println("<html>");
			out.println("<h1>Record not submmited</h1>");
			out.println("</html>");
		}
		

	}

}
