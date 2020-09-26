package com.nis.controller;

import java.sql.ResultSet;
import java.util.Calendar;

import com.nis.dao.DbHelper;
import com.nis.model.Floors;

public class FloorController {
	public static boolean addFloors(Floors F)
	{
		try{
			String query="insert into floors values("+F.getFloorno()+",'"+F.getFlorename()+"','"+F.getTotalspace()+"')";
			boolean status=DbHelper.executeUpdate(query);
			return(status);
		}catch(Exception e)
		{
			System.out.println("Error:addFloor()"+e);
		}
		return false;
	}
	 public static ResultSet fetchAllFloors()
	 {
		 try{
			 String query="Select * from floors";
			 ResultSet rs=DbHelper.executeQuery(query);
			 return(rs);
		 }catch(Exception e)
		 {
			 System.out.println("Error:fetchAllFloors+"+e);
		 }
		 return(null);
	 }
	 public static ResultSet fetchFloorById(int fid)
	 {
		 try{
			 Calendar C=Calendar.getInstance();
			 String cd=C.get(Calendar.YEAR)+"/"+(C.get(Calendar.MONTH)+1)+"/"+C.get(Calendar.DATE);
				String query="select f.totalspace,count(v.floorno) as totalvehicle,(f.totalspace-count(v.floorno)) as avl_space from floors f,vehicle v where v.floorno=f.floorno and  v.floorno="+fid+" and v.currentdate='"+cd+"' group by v.floorno";
				System.out.println(query);             
				ResultSet rs=DbHelper.executeQuery(query);
			 return(rs);
		 }catch(Exception e)
		 {
			 System.out.println("Error:fetchFloorById+"+e);
		 }
		 return(null);
	 }

}
