function massCheckInMember() {
	
	var unitID=$('#massUnit option:selected').val();
	var activityID=$('#massActivity option:selected').val();
	// if exact time
	if ($("input[name='massTime']:checked").val() == 'exactTime') {
		// build the date and time string
		var datetime = new Date($('input[name="massExactTimeDateField"]').val() 
						   + " " 
						   + $('input[name="massExactTimeField"]').val()
					   );

		// iterate through the memberID input boxes
		for(var i = 1;i < 15; i++){
			// only process the box if it is not null
		    if($("input[name='memberID" + i + "']").val()){ 
		    	
		    	// set the value of the box to the variable memberID
		    	var memberID=$("input[name='memberID" + i + "']").val();


		    	// check the current member in.
				ActivityCheckinService.checkInExact(unitID,
						activityID,
						datetime,
						memberID,
						'massNotifyCheckIn',BaseSuccessDelegate);
		    }
		}
		// end if exact time
		
	} else {
		for(var i = 1;i < 15; i++){
		    if($("input[name='memberID" + i + "']").val()){  
		    	var memberID=$("input[name='memberID" + i + "']").val();


				ActivityCheckinService.checkIn(unitID,
						activityID,
						memberID,
						'massNotifyCheckIn',BaseSuccessDelegate);
		    }
		}
	}
}



function massNotifyCheckIn(data) {
	$.jGrowl(data.firstName + " " + data.lastName + " was checked in to "+
			$('#massActivity option:selected').text() +
			".");
}

function massCheckOutMember() {
	var unitID=$('#massUnit option:selected').val();
	var activityID=$('#massActivity option:selected').val();	
	// if exact time
	if ($("input[name='massTime']:checked").val() == 'exactTime') {
		// build the date and time string
		var datetime = new Date($('input[name="massExactTimeDateField"]').val() 
						   + " " 
						   + $('input[name="massExactTimeField"]').val()
					   );
		// iterate through the memberID input boxes
		for(var i = 1;i < 15; i++){
			// only process the box if it is not null
		    if($("input[name='memberID" + i + "']").val()){  
		    	// set the value of the box to the variable memberID
		    	var memberID=$("input[name='memberID" + i + "']").val();		    	
		    	// check the current member in.
				ActivityCheckinService.checkOutExact(unitID,
						activityID,
						datetime,
						memberID,
						'massNotifyCheckOut',BaseSuccessDelegate);
		    }
		}
		// end if exact time
		} else {
			for(var i = 1;i < 15; i++){
			    if($("input[name='memberID" + i + "']").val()){  
			    	var memberID=$("input[name='memberID" + i + "']").val();

					ActivityCheckinService.checkOut(unitID,
							activityID,
							memberID,
							'massNotifyCheckOut',BaseSuccessDelegate);
			    }
			}
		}
}


function massNotifyCheckOut(data) {
	$.jGrowl(data.firstName + " " + data.lastName + " was checked out of "+
			$('#massActivity option:selected').text() +
			".");
}