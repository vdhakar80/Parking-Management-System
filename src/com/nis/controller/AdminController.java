package com.nis.controller;

import java.sql.ResultSet;

import com.nis.dao.DbHelper;
import com.nis.model.Admin;

public class AdminController {
	public static Admin checkAdmin(int adminid,String password)
	{
		try{
			String query="select * from admin where adminid="+adminid+" and password='"+password+"'";
			ResultSet rs=DbHelper.executeQuery(query);
			if(rs.next())
			{
				Admin A=new Admin();
				A.setAdminid(rs.getInt(1));
				A.setAdminname(rs.getString(2));
				A.setPicture(rs.getString(3));
				A.setPassword(rs.getString(4));
				return A;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Error:checkAdmin"+e);
		}
		return null;
		
	}

}
