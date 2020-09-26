package com.nis.controller;

import java.sql.ResultSet;

import com.nis.dao.DbHelper;
import com.nis.model.ExitVehicle;
import com.nis.model.Vehicle;

public class ExitVehicleController {
	public static boolean addNewRecord(ExitVehicle V)
	{try{
	 String query="insert into exitvehicles(employeeid,vehicleid,exitdate,exittime)values("+V.getEmployeeid()+","+V.getVehicleid()+",'"+V.getExitdate()+"','"+V.getExittime()+"')";
			  
	 System.out.println(query);
	 boolean status=DbHelper.executeUpdate(query);
	 return(status);
		
	}catch(Exception e)
	{ System.out.println("Error:addNewRecord()"+e);
		}
	return(false);	

	}


}
