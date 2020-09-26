package com.nis.controller;

import java.sql.ResultSet;

import com.nis.dao.DbHelper;

public class StateCityController {
	public static ResultSet fetchAllStates()
	{
	    try{
	    	ResultSet rs=DbHelper.executeQuery("select * from states");
	    	return rs;
	    	
	    }
	    catch(Exception e)
	    {
	    	System.out.println("Error:fetchAllState"+e);
	    }
	    return (null);
	}
	public static ResultSet fetchAllCities(int stateid)
	{
	    try{
	    	ResultSet rs=DbHelper.executeQuery("select * from cities where stateid="+stateid);
	    	return rs;
	    	
	    }
	    catch(Exception e)
	    {
	    	System.out.println("Error:fetchAllCities"+e);
	    }
	    return (null);
	}
}
