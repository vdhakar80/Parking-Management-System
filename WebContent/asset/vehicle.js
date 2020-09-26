$('document').ready(function()
{
	
	$('#btn').click(function()
	{
	     $.getJSON('searchVehicleByRFIDJSON',{ajax:true, rfidno:$('#rfidno').val()},function(data)
			{
	    	      
	    	    htm='<center><br><br><b><i><font color=green><h2>'+data[0].EMPLOYEENAME+"</h2></font></i></b><br>";
				htm+="<h2 style='color:blue;'><b><i>Vehicle Details</i></b></h2><table border=1 width=60%>";
				htm+="<tr class='table-primary'><td><b><i>Reg. NO.:</i></b></td><td>"+data[0].REGISTRATIONNO+"</td><td><b><i>Employee Id:</i></b></td><td>"+data[0].EMPLOYEEID+" </td></tr>";

				htm+="<tr class='table-active'><td><b><i>Vehicle Id:</i></b></td><td>"+data[0].VEHICLEID+"</td><td><b><i>RFID:</i></b></td><td>"+data[0].RFIDNO+"</td></tr>";
				htm+="<tr class='table-primary'><td><b><i>Mobile Number:</i></b></td><td>"+data[0].MOBILENO+"</td><td><b><i>Date/Time:</i></b></td><td>"+data[0].CURRENTDATE+' '+data[0].CURRENTTIME+'</td></tr>';
				htm+="<tr class='table-active'><td><b><i>Amount:</i></b></td><td>"+data[0].AMOUNT+"</td><td><b><i>Time(hours):</i></b></td><td>"+data[0].DURATION+' </td></tr>';
				htm+="<tr class='table-primary'><td><b><i>Floor No:</i></b></td><td>"+data[0].FLOORNO+"</td><td><b><i>Status:</i></b></td><td>"+data[0].STATUS+'</td></tr>';
	            htm+='</table></center>';
	            htm+="<form action='ExitVehicleSubmit'>"
	            htm+="<center><br><br><table width=60%><tr><input type='hidden' name='vid' id='vid' value='"+data[0].VEHICLEID+"'></tr>";
	            today=new Date();
	            cd=today.getFullYear()+"/"+today.getMonth()+"/"+today.getDate();           
	            ct=today.getHours()+":"+today.getMinutes()+":"+today.getSeconds();

	            htm+="<tr><td><b><i>Current Date:</i></b></td><td><input type='text' name='exitdate' id='exitdate' value='"+cd+"'></td>"
		        htm+="<td><b><i>Current Time:</i></b></td><td><input type='text' name='exittime' id='exittime' value='"+ct+"'></td></tr></table>"
		        htm+="<br><input type='submit' name='btn' class='btn btn-primary' value='Exit Vehicle'></form></center>";
			 $('#div1').html(htm);

			});
	});
	
	
	
	$('#btnsearchbetweendates').click(function()
			{
			     $.getJSON('SearchVehiclesBetweenDatesJSON',{ajax:true, fdate:$('#fdate').val(), ldate:$('#ldate').val()},function(data)
					{
			    	    
			    	 x=1; 
			    	     i=0;
						htm="<center><h2 style='color:blue;'><b><i>IN Vehicles</i></b></h2><table border=1>";
						htm+="<tr class='table-success'><th><b>S.No.</b></th><th><b>Vehicle ID</b></th><th><b>Registrartion No.</b></th><th><b>RFID no.</b></th><th><b>Transaction Id</b></th><th><b>Floor No</b></th><th><b>Status</b></th><th><b>Mobile No.</b></th><th><b>Entry Date/Entry Time</b></th><th><b>Exit Date/Exit Time</b></th><th><b>Emplyee Name(entry)</b></th><th><b>Emplyee Name(Exit)</b></th>";
					    $.each(data,function(i,item)
			    		{
					    	htm+="<tr class='table-primary'><td>"+x+"<td>"+data[i].VEHICLEID+"</td><td>"+data[i].REGISTRATIONNO+"</td><td>"+data[i].RFIDNO+"</td><td>"+data[i].TRANSACTIONID+"</td><td>"+data[i].FLOORNO+"</td><td>"+data[i].STATUS+"</td><td>"+data[i].MOBILENO+"</td><td>"+data[i].ENTRYDATE+"<br>"+data[i].ENTRYTIME+"</td><td>"+data[i].EXITDATE+"<br>"+data[i].EXITTIME+"</td><td>"+data[i].ENTRYEMPLOYEE+"</td><td>"+data[i].EXITEMPLOYEE+"</td></tr>";
						    x=x+1;
						    i=i+1;
						    
			    		});
					    htm+='</table></center>';
					    
			           $('#div1').html(htm);
					});
			});
	
	
	
	$('#btnsearchbyregno').click(function()
			{
			     $.getJSON('SearchVehicleByRegNoJSON',{ajax:true, regno:$('#regno').val()},function(data)
					{
			    	      
			    	 
						htm="<br><center><h2 style='color:blue;'><b><i>Vehicle Details</i></b></h2><table border=1 width=60%>";
						htm+="<tr class='table-primary'><td><b><i><font color=green>Reg. NO.:</font></i></b></td><td>"+data[0].REGISTRATIONNO+"</td><td><b><i><font color=green>Vehicle Id:</font></i></b></td><td>"+data[0].VEHICLEID+"</td></tr>";
						htm+="<tr class='table-active'><td><b><i><font color=green>Mobile Number:</font></i></b></td><td>"+data[0].MOBILENO+"</td><td><b><i><font color=green>RFID:</font></i></b></td><td>"+data[0].RFIDNO+"</td></tr>";
						htm+="<tr class='table-primary'><td><b><i><font color=green>Employee(Entry):</font></i></b></td><td>"+data[0].ENTRYEMPLOYEE+" </td><td><b><i><font color=green>Employee(Exit):</font></i></b></td><td>"+data[0].EXITEMPLOYEE+"</td></tr>";
						htm+="<tr class='table-active'><td><b><i><font color=green>Date/Time(Entry):</font></i></b></td><td>"+data[0].ENTRYDATE+' '+data[0].ENTRYTIME+"</td><td><b><i><font color=green>Date/Time:(Exit)</font></i></b></td><td>"+data[0].EXITDATE+' '+data[0].EXITTIME+'</td></tr>';
						htm+="<tr class='table-primary'><td><b><i><font color=green>Amount:</font></i></b></td><td>"+data[0].AMOUNT+"</td><td><b><i><font color=green>Time(hours):</font></i></b></td><td>"+data[0].DURATION+' </td></tr>';
						htm+="<tr class='table-active'><td><b><i><font color=green>Floor No:</font></i></b></td><td>"+data[0].FLOORNO+"</td><td><b><i><font color=green>Status:</font></i></b></td><td>"+data[0].STATUS+'</td></tr>';
						htm+="<tr class='table-active'><td><b><i><font color=green>Transaction Id</font></i></b></td><td>"+data[0].TRANSACTIONID+"</td><td></td>&nbsp;<td>&nbsp;</td></tr>";
						htm+='</table></center>';
	 	
					 $('#div1').html(htm);

					});
			});
	
	
	$('#btnsearchbymobileno').click(function()
			{
			     $.getJSON('SearchVehicleByMobileNoJSON',{ajax:true, mobileno:$('#mobileno').val()},function(data)
					{
			    	      
			    	 
						htm="<br><center><h2 style='color:blue;'><b><i>Vehicle Details</i></b></h2><table border=1 width=60%>";
						htm+="<tr class='table-primary'><td><b><i><font color=green>Reg. NO.:</font></i></b></td><td>"+data[0].REGISTRATIONNO+"</td><td><b><i><font color=green>Vehicle Id:</font></i></b></td><td>"+data[0].VEHICLEID+"</td></tr>";
						htm+="<tr class='table-active'><td><b><i><font color=green>Mobile Number:</font></i></b></td><td>"+data[0].MOBILENO+"</td><td><b><i><font color=green>RFID:</font></i></b></td><td>"+data[0].RFIDNO+"</td></tr>";
						htm+="<tr class='table-primary'><td><b><i><font color=green>Employee(Entry):</font></i></b></td><td>"+data[0].ENTRYEMPLOYEE+" </td><td><b><i><font color=green>Employee(Exit):</font></i></b></td><td>"+data[0].EXITEMPLOYEE+"</td></tr>";
						htm+="<tr class='table-active'><td><b><i><font color=green>Date/Time(Entry):</font></i></b></td><td>"+data[0].ENTRYDATE+' '+data[0].ENTRYTIME+"</td><td><b><i><font color=green>Date/Time:(Exit)</font></i></b></td><td>"+data[0].EXITDATE+' '+data[0].EXITTIME+'</td></tr>';
						htm+="<tr class='table-primary'><td><b><i><font color=green>Amount:</font></i></b></td><td>"+data[0].AMOUNT+"</td><td><b><i><font color=green>Time(hours):</font></i></b></td><td>"+data[0].DURATION+' </td></tr>';
						htm+="<tr class='table-active'><td><b><i><font color=green>Floor No:</font></i></b></td><td>"+data[0].FLOORNO+"</td><td><b><i><font color=green>Status:</font></i></b></td><td>"+data[0].STATUS+'</td></tr>';
						htm+="<tr class='table-active'><td><b><i><font color=green>Transaction Id</font></i></b></td><td>"+data[0].TRANSACTIONID+"</td><td></td>&nbsp;<td>&nbsp;</td></tr>";
						htm+='</table></center>';
	 	
					 $('#div1').html(htm);

					});
			});
	
	
	$('#btnsearchbyeidanddates').click(function()
			{
			     $.getJSON('SearchVehicleByEmployeeIdAndDatesJSON',{ajax:true, eid:$('#eid').val(), fdate:$('#fdate').val(), ldate:$('#ldate').val()},function(data)
					{
			    	    
			    	 x=1; 
			    	     i=0;
				    	 htm='<center><br><br><b><i><h2>Employee Name:</h2><br><font color=green><h2>'+data[0].EMPLOYEENAME+"</h2></font></i></b><br>";

						htm+="<center><h2 style='color:blue;'><b><i>Vehicles</i></b></h2><table border=1>";
						htm+="<tr class='table-success'><th><b>S.No.</b></th><th><b>Vehicle ID</b></th><th><b>Registrartion No.</b></th><th><b>RFID no.</b></th><th><b>Transaction Id</b></th><th><b>Floor No</b></th><th><b>Status</b></th><th><b>Mobile No.</b></th><th><b>Entry Date/Entry Time</b></th><th><b>Exit Date/Exit Time</b></th><th><b>Emplyee Name</b></th><th><b>Emplyee Id</b></th>";
					    $.each(data,function(i,item)
			    		{
					    	htm+="<tr class='table-primary'><td>"+x+"<td>"+data[i].VEHICLEID+"</td><td>"+data[i].REGISTRATIONNO+"</td><td>"+data[i].RFIDNO+"</td><td>"+data[i].TRANSACTIONID+"</td><td>"+data[i].FLOORNO+"</td><td>"+data[i].STATUS+"</td><td>"+data[i].MOBILENO+"</td><td>"+data[i].ENTRYDATE+"<br>"+data[i].ENTRYTIME+"</td><td>"+data[i].EXITDATE+"<br>"+data[i].EXITTIME+"</td><td>"+data[i].EMPLOYEENAME+"</td><td>"+data[i].EMPLOYEEID+"</td></tr>";
						    x=x+1;
						    i=i+1;
						    
			    		});
			            htm+='</table></center>';
			           $('#div1').html(htm);
					});
			});
	
	
	
});