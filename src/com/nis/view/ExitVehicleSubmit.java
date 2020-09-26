package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.controller.ExitVehicleController;
import com.nis.controller.VehiclesController;
import com.nis.model.ExitVehicle;

/**
 * Servlet implementation class ExitVehicleSubmit
 */
@WebServlet("/ExitVehicleSubmit")
public class ExitVehicleSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExitVehicleSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<html>");
		HttpSession ses=request.getSession();
		try{
		ExitVehicle V=new ExitVehicle();
		V.setEmployeeid(Integer.parseInt(ses.getValue("ID").toString()));
		V.setVehicleid(Integer.parseInt(request.getParameter("vid")));
		V.setExitdate(request.getParameter("exitdate"));
		V.setExittime(request.getParameter("exittime"));
		boolean st=ExitVehicleController.addNewRecord(V);
		if(st)
		{  st=VehiclesController.updateStatus(V.getVehicleid());
		VehiclesController.RemoveRFID();

			response.sendRedirect("SearchVehicleByRFID");
		}
		else
		{
			out.println("Fail to Exit vehicle....");
		}
		}catch(Exception e)
		{
		response.sendRedirect("EmployeeLogin");	
		}
		
		
	}

}
