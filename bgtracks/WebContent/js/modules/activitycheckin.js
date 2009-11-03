

function checkInMember() {

	if ($("input[name='time']:checked").val() == 'exactTime') {
		var datetime = new Date($('input[name="exactTimeDateField"]').val() 
							   + " " 
							   + $('input[name="exactTimeField"]').val()
						   );

		
		ActivityCheckinService.checkInExact($('#singleMemberUnit option:selected').val(),
				$('#singleMemberActivity option:selected').val(), datetime,
				$('#singleMemberNumber').val(),
				'notifyCheckIn',BaseSuccessDelegate);
		
	} else {
		ActivityCheckinService.checkIn($('#singleMemberUnit option:selected').val(),
				$('#singleMemberActivity option:selected').val(),
				$('#singleMemberNumber').val(),
				'notifyCheckIn',BaseSuccessDelegate);

	}
}
//
//function checkInMemberResponse(data) {
//	if (data) {
//		MemberService.findMemberById($('#singleMemberNumber').val(),
//				notifyCheckIn);
//	} else
//		callDialog("Error", data, "cancel-dialog");
//}

function notifyCheckIn(data) {
	$.jGrowl(data.firstName + " " + data.lastName + " was checked in to "+
			$('#singleMemberActivity option:selected').text() +
			".");
}

function checkOutMember() {
	
		if ($("input[name='time']:checked").val() == 'exactTime') {
			var datetime = new Date($('input[name="exactTimeDateField"]').val() 
					   + " " 
					   + $('input[name="exactTimeField"]').val()
				   );

			ActivityCheckinService.checkOutExact($('#singleMemberUnit option:selected').val(),
					$('#singleMemberActivity option:selected').val(), datetime,
					$('#singleMemberNumber').val(),
					'notifyCheckOut',BaseSuccessDelegate);
		} else {
			ActivityCheckinService.checkOut($('#singleMemberUnit option:selected').val(),
					$('#singleMemberActivity option:selected').val(),
					$('#singleMemberNumber').val(),
					'notifyCheckOut',BaseSuccessDelegate);
		}
}
//
//function checkOutMemberResponse(data) {
//	if (data) {
//		MemberService.findMemberById($('#singleMemberNumber').val(),
//				notifyCheckOut);
//	} else
//		callDialog("Error", data, "cancel-dialog");
//}
function notifyCheckOut(data) {
	$.jGrowl(data.firstName + " " + data.lastName + " was checked out of "+
			$('#singleMemberActivity option:selected').text() +
			".");
}