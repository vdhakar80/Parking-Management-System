package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.nis.controller.VehiclesController;
import com.nis.dao.DbHelper;

/**
 * Servlet implementation class SearchVehiclesBetweenDatesJSON
 */
@WebServlet("/SearchVehiclesBetweenDatesJSON")
public class SearchVehiclesBetweenDatesJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchVehiclesBetweenDatesJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				PrintWriter out=response.getWriter();
				try{
					 ResultSet rs=VehiclesController.searchVehicleBetweenDates("2018-11-01","2018-12-01");
					if(!rs.isBeforeFirst())
					{
						JSONObject obj=new JSONObject();
						obj.put("MESSAGE", "No Vehicle Exist");
						out.println(obj);
					}
					 else
						 {ArrayList<JSONObject> obj=DbHelper.JsonEngine(rs);
					out.println(obj);}
				}catch(Exception e){
					 out.println(e);  
				   }	}
	

}
