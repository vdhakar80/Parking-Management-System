package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.controller.EmployeesController;
import com.nis.model.Employees;

/**
 * Servlet implementation class CheckOtp
 */
@WebServlet("/CheckOtp")
public class CheckOtp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOtp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
	String otp=request.getParameter("otp");
	String uotp=request.getParameter("uotp");
	System.out.println(otp+""+uotp);
	if(otp.equals(uotp))
	{ Employees E=EmployeesController.displayAllByID(Integer.parseInt(request.getParameter("id")));
	HttpSession ses=request.getSession();
	ses.putValue("ID", E.getEmployeeid());
	ses.putValue("NAME", E.getEmployeename());
	ses.putValue("PICTURE", E.getPicture());
	ses.putValue("LTIME", new Date());
	response.sendRedirect("EmployeesHome");


		
	}
	else
	{
	out.println("<html>Invalid Otp</html>");	
		
	}
	
	
	
	
	}

}
