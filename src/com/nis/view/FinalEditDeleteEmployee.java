package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import com.nis.controller.EmployeesController;
import com.nis.model.Employees;

/**
 * Servlet implementation class FinalEditDeleteEmployee
 */
@WebServlet("/FinalEditDeleteEmployee")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)//Max Size 50 MB
public class FinalEditDeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalEditDeleteEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		Employees E=new Employees();
		String eid=request.getParameter("eid");
		String submit=request.getParameter("btn");
		if(submit.equals("DELETE"))
		{
			boolean st=EmployeesController.deleteRecord(Integer.parseInt(eid));
			response.sendRedirect("DisplayAllEmployees");
		}
		else if(submit.equals("UPDATE"))
		{
			
			E.setEmployeeid(request.getParameter("eid"));
			E.setEmployeename(request.getParameter("en"));
			E.setGender(request.getParameter("eg"));
			E.setDob(request.getParameter("edob"));
	        E.setAddress(request.getParameter("eadd"));
	       
	        if(request.getParameter("estate").equals("--Select--") && request.getParameter("ecity").equals("--Select--"))
    		{E.setState(request.getParameter("stateid"));
    		E.setCity(request.getParameter("cityid"));}
    		else
    		{
    			E.setState(request.getParameter("estate"));
        		E.setCity(request.getParameter("ecity"));	
    			
    		}
	        E.setDesignation(request.getParameter("edes"));
	        E.setSalary(Long.parseLong(request.getParameter("esal")));
	        E.setEmail(request.getParameter("email"));
	        E.setMobileno(request.getParameter("emobile"));
	        E.setPassword(request.getParameter("epwd"));
	        boolean status=EmployeesController.updateRecord(E);
	        response.sendRedirect("DisplayAllEmployees");
		}
		else if(submit.equals("SAVE"))
		{
			Part P=request.getPart("picture");
	    	FileUpload F=new FileUpload(P,"F:/Eclipse Mars/eclipse/Parking/WebContent/images");
    		boolean st=EmployeesController.editPicture(Integer.parseInt(eid), F.filename);
    		 response.sendRedirect("DisplayAllEmployees");
		}
	}

}
