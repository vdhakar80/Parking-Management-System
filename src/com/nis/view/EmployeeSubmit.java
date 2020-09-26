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
 * Servlet implementation class EmployeeSubmit
 */
@WebServlet("/EmployeeSubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)//Max Size 50 MB
public class EmployeeSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeSubmit() {
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
		E.setEmployeename(request.getParameter("en"));
		E.setGender(request.getParameter("eg"));
		E.setDob(request.getParameter("edob"));
        E.setAddress(request.getParameter("eadd"));
        E.setState(request.getParameter("estate"));
        E.setCity(request.getParameter("ecity"));
        E.setDesignation(request.getParameter("edes"));
        E.setSalary(Long.parseLong(request.getParameter("esal")));
        E.setEmail(request.getParameter("email"));
        E.setMobileno(request.getParameter("emobile"));
        Part P=request.getPart("epic");
    	FileUpload F=new FileUpload(P,"F:/Eclipse Mars/eclipse/Parking/WebContent/images");
    	
    	E.setPicture(F.filename);
        
        
        E.setPassword(request.getParameter("epwd"));
        boolean status=EmployeesController.addRecord(E);
        String employeeid=EmployeesController.getEmployeeId(request.getParameter("emobile"));
        out.println("<html>");
        if(status)
        {
           out.println("Record submmited<br>");
           out.println("Employee ID:"+employeeid+"");
        }else
        {
        	out.println("Failed to submit record");
        }
        out.println("</html>");
	}

}
