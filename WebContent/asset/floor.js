$('document').ready(function()
{
	$.getJSON('FetchAllFloorsJSON',{ajax:true},function(data)
	{
		$('#floorno').append($('<option>').text('-Select-'));	

		$.each(data,function(i,item)
		{
			$('#floorno').append($('<option>').text(item.FLOORNAME).val(item.FLOORNO));
		});
		
	});
	
	
	
	$('#floorno').change(function()
	{
		
		
		$.getJSON('FetchFloorByIdJSON',{ajax:true, floorno:$('#floorno').val()},function(data)
		 			{
		 	    	if(data.length==0){
		 	    		 $('#fdiv').html('<b><i><font color=red>Parking is empty...</font></i></b>');
		 	    	}			
		 	    	
		 	    	else{
			
		 	    		totalspace=data[0].TOTALSPACE;
		 	  		 avl_space=data[0].AVL_SPACE;
		 	  		 tv=data[0].TOTALVEHICLE;
		 			 $('#fdiv').html('<font color=green><b><i>Total Space:'+totalspace+"<br>Available Space:"+avl_space+"<br>"+"Total Vehicle:"+tv+"</i></b></font>");
		 	    	}
		 	    	
				
			});
	});
});