package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.FloorController;
import com.nis.model.Floors;

/**
 * Servlet implementation class FloorSubmit
 */
@WebServlet("/FloorSubmit")
public class FloorSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FloorSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		Floors F=new Floors();
		F.setFloorno(Integer.parseInt(request.getParameter("floorno")));
		F.setFlorename(request.getParameter("floorname"));
		F.setTotalspace(request.getParameter("totalspace"));
		Boolean status=FloorController.addFloors(F);
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
