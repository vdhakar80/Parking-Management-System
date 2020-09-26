package com.nis.controller;

import java.sql.ResultSet;

import com.nis.dao.DbHelper;
import com.nis.model.Employees;
import com.nis.model.Vehicle;

public class VehiclesController {
	public static boolean addVehicle(Vehicle V)
	{
		try{
			String query="insert into vehicle(employeeid,vehicleid,RFIDno,registrationno,mobileno,currentdate,currenttime,amount,duration,status,floorno) values("+V.getEmployeeid()+","+V.getVehicleno()+",'"+V.getRFIDno()+"','"+V.getRegistrationno()+"','"+V.getMobileno()+"','"+V.getCurrentdate()+"','"+V.getCurrenttime()+"',"+V.getAmount()+","+V.getDuration()+",'"+V.getStatus()+"',"+V.getFloorno()+")";
			System.out.println(query);
			boolean status=DbHelper.executeUpdate(query);
			return(status);
		}catch(Exception e)
		{
			System.out.println("Error:addRecord()");
		}
		return false;
	}
	
	
	
	
	
	
	public static ResultSet displayAll()
	{try{
	 String query="select * from vehicle";
	 ResultSet rs=DbHelper.executeQuery(query);
	 return(rs);
		
	}catch(Exception e)
	{ System.out.println("Error:displayAll()"+e);
		}
	return(null);	

	}
	
	
	
	
	
	public static Vehicle displayAllVehiclesByID(int vid)
	{try{
	 String query="select * from vehicle where vehicleid="+vid;
	 ResultSet rs=DbHelper.executeQuery(query);
	 if(rs.next())
	 {
		 Vehicle V=new Vehicle();
		 V.setEmployeeid(Integer.parseInt(rs.getString(1)));
		 V.setVehicleno(Integer.parseInt(rs.getString(2)));
		 V.setRFIDno(rs.getString(3));
		 V.setRegistrationno(rs.getString(4));
		 V.setMobileno(rs.getString(5));
		 V.setCurrentdate(rs.getString(6));
		 V.setCurrenttime(rs.getString(7));
		 V.setAmount(Integer.parseInt(rs.getString(8)));
		 V.setDuration(Integer.parseInt(rs.getString(9)));
		 V.setStatus(rs.getString(10));
		 V.setFloorno(Integer.parseInt(rs.getString(11)));
		return(V);
		 	 
	 }
	 return null;
	}catch(Exception e)
	{ System.out.println("Error:displayAllVehiclesByID()"+e);
		}
	return(null);	

	}
	
	
	
	
	
	
	public static boolean updateRecord(Vehicle V)
	{
		try{
			String query="update vehicle set employeeid="+V.getEmployeeid()+",RFIDno='"+V.getRFIDno()+"',registrationno='"+V.getRegistrationno()+"',mobileno='"+V.mobileno+"',currentdate='"+V.getCurrentdate()+"',currenttime='"+V.getCurrenttime()+"',amount="+V.getAmount()+",duration="+V.getDuration()+",status='"+V.getStatus()+"',floorno="+V.getFloorno()+" where vehicleid="+V.getVehicleno();
			boolean status=DbHelper.executeUpdate(query);
			System.out.println(query);
			return(status);
		}catch(Exception e)
		{
			System.out.println("Error:updatevehicleRecord()");
		}
		return false;
	}
	
	
	
	
	
	
	public static boolean deleteRecord(int vid)
	{
		try{
			String query="delete from vehicle where vehicleid="+vid;
			boolean status=DbHelper.executeUpdate(query);
			return(status);
		}catch(Exception e)
		{
			System.out.println("Error:deleteVehicleRecord()");
		}
		return false;
	}
	
	
	
	
	
	public static ResultSet searchVehicleByRFID(String RFID)
	{try{
		String query="select e.employeename,v.employeeid,v.registrationno,v.vehicleid,v.rfidno,v.duration,v.mobileno,v.currentdate,v.currenttime,v.amount,v.status,v.floorno from vehicle v ,employees e where v.employeeid=e.employeeid and v.rfidno='"+RFID+"'and v.status='IN'";	 
				ResultSet rs=DbHelper.executeQuery(query);
				System.out.println(query);
	 return(rs);
		
	}catch(Exception e)
	{ System.out.println("Error:searchVehicleByRFID()"+e);
		}
	return(null);	

	}
	
	
	
	
	
	public static boolean updateStatus(int vid)
	{
		try{
			String query="update vehicle set status='OUT' where vehicleid="+vid;
			boolean status=DbHelper.executeUpdate(query);
			System.out.println(query);
			return(status);
		}catch(Exception e)
		{
			System.out.println("Error:updateStatus()");
		}
		return false;
	}
	
	
	
	
	
	public static ResultSet searchVehicleBetweenDates(String fdate,String ldate)
	{try{
		String query="select v.employeeid,v.registrationno,v.vehicleid,v.rfidno,v.duration,v.mobileno,v.currentdate as entrydate,v.currenttime as entrytime,v.amount,v.status,v.floorno,ev.exitdate,ev.exittime,ev.transactionid,(select employeename from employees e where e.employeeid=v.employeeid) as entryemployee,(select employeename from employees e where e.employeeid=ev.employeeid) as exitemployee from vehicle v LEFT JOIN exitvehicles ev ON v.vehicleid=ev.vehicleid where currentdate between '"+fdate+"' and '"+ldate+"'";	 
				ResultSet rs=DbHelper.executeQuery(query);
				System.out.println(query);
	 return(rs);
		
	}catch(Exception e)
	{ System.out.println("Error:searchVehicleByRFID()"+e);
		}
	return(null);	

	}
	
	public static ResultSet searchVehicleByRegNo(String regno)
	{try{
		String query="select v.employeeid,v.registrationno,v.vehicleid,v.rfidno,v.duration,v.mobileno,v.currentdate as entrydate,v.currenttime as entrytime,v.amount,v.status,v.floorno,ev.exitdate,ev.exittime,ev.transactionid,(select employeename from employees e where e.employeeid=v.employeeid) as entryemployee,(select employeename from employees e where e.employeeid=ev.employeeid) as exitemployee from vehicle v LEFT JOIN exitvehicles ev ON v.vehicleid=ev.vehicleid where v.registrationno='"+regno+"'";	 
				ResultSet rs=DbHelper.executeQuery(query);
				System.out.println(query);
	 return(rs);
		
	}catch(Exception e)
	{ System.out.println("Error:searchVehicleByRegNo()"+e);
		}
	return(null);	

	}
	
	public static ResultSet searchVehicleByMobileNo(String mobileno)
	{try{
		String query="select v.employeeid,v.registrationno,v.vehicleid,v.rfidno,v.duration,v.mobileno,v.currentdate as entrydate,v.currenttime as entrytime,v.amount,v.status,v.floorno,ev.exitdate,ev.exittime,ev.transactionid,(select employeename from employees e where e.employeeid=v.employeeid) as entryemployee,(select employeename from employees e where e.employeeid=ev.employeeid) as exitemployee from vehicle v LEFT JOIN exitvehicles ev ON v.vehicleid=ev.vehicleid where v.mobileno='"+mobileno+"'";	 
				ResultSet rs=DbHelper.executeQuery(query);
				System.out.println(query);
	 return(rs);
		
	}catch(Exception e)
	{ System.out.println("Error:searchVehicleByMobileNo()"+e);
		}
	return(null);	

	}
	
	
	public static ResultSet searchVehicleByEmployeeIdAndDates(int eid,String fdate,String ldate)
	{try{
		String query="select v.employeeid,v.registrationno,v.vehicleid,v.rfidno,v.duration,v.mobileno,v.currentdate as entrydate,v.currenttime as entrytime,v.amount,v.status,v.floorno,(select exitdate from exitvehicles ev where ev.employeeid=v.employeeid and v.vehicleid=ev.vehicleid and currentdate between '"+fdate+"' and '"+ldate+"') as exitdate,(select exittime from exitvehicles ev where ev.employeeid=v.employeeid and v.vehicleid=ev.vehicleid and currentdate between '"+fdate+"' and '"+ldate+"') as exittime,(select transactionid from exitvehicles ev where ev.employeeid=v.employeeid and v.vehicleid=ev.vehicleid) as transactionid,(select employeename from employees e where e.employeeid=v.employeeid) as employeename from vehicle v  where v.employeeid="+eid+" and currentdate between '"+fdate+"' and '"+ldate+"'";	 
				ResultSet rs=DbHelper.executeQuery(query);
				System.out.println(query);
	 return(rs);
		
	}catch(Exception e)
	{ System.out.println("Error:searchVehicleByEmployeeIdAndDates()"+e);
		}
	return(null);	

	}

	public static String  ReadRFID()
	{try{
	 String query="select * from rfid";
	 ResultSet rs=DbHelper.executeQuery(query);
	 if(rs.next())
	 {return(rs.getString(1));}
	 else
	 {
	 return("");}
	 
	  
	 
	}catch(Exception e)
	{ System.out.println("Error:displayByID()"+e);
		}
	return(null);
	 }

	public static boolean RemoveRFID()
	{
		try{
			String query="delete from rfid";
			
			//System.out.println(query);
			boolean status=DbHelper.executeUpdate(query);
			return(status);
		}catch(Exception e){System.out.println("Error:editRecord"+e);}
		return(false);
	}

}
