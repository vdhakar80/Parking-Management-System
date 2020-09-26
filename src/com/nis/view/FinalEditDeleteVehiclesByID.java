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
 * Servlet implementation class FinalEditDeleteVehiclesByID
 */
@WebServlet("/FinalEditDeleteVehiclesByID")
public class FinalEditDeleteVehiclesByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalEditDeleteVehiclesByID() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		int vid=Integer.parseInt(request.getParameter("vid"));
		Vehicle V=new Vehicle();
		if(request.getParameter("submit").equals("Delete"))
		{
			try{
				boolean st=VehiclesController.deleteRecord(vid);
				response.sendRedirect("DisplayAllVehicles");
				
			}catch(Exception e)
			{
				System.out.println("Error:"+e);
			}
		}
		else if(request.getParameter("submit").equals("Update"))
		{
			try{
				V.setEmployeeid(Integer.parseInt(request.getParameter("eid")));
				V.setVehicleno(Integer.parseInt(request.getParameter("vid")));
				V.setRFIDno(request.getParameter("rfid"));
				V.setRegistrationno(request.getParameter("regno"));
				V.setMobileno(request.getParameter("mobileno"));
				V.setCurrentdate(request.getParameter("cdate"));
				V.setCurrenttime(request.getParameter("ctime"));
				V.setAmount(Integer.parseInt(request.getParameter("amount")));
				if(request.getParameter("duration").equals("-select-"))
				{
					V.setDuration(Integer.parseInt(request.getParameter("hduration")));
					
				}
				else
				{
					V.setDuration(Integer.parseInt(request.getParameter("duration")));

				}
				if(request.getParameter("status").equals("-select-"))
				{
					V.setStatus(request.getParameter("hstatus"));
				}
				else
				{
					V.setStatus(request.getParameter("status"));


				}
				V.setFloorno(Integer.parseInt(request.getParameter("floorno")));
				boolean st=VehiclesController.updateRecord(V);
				response.sendRedirect("DisplayAllVehicles");
				
			}catch(Exception e)
			{
				System.out.println("Error:in update function of FinalEditDeleteVehiclesByID"+e);
			}
		}

	}

}
