	function loadEmployeeIdData() {
		EmployeeService.findEmployeeById($("#txtStaffID").val(),
				loadEmployeeIdDataSuccessful);
	}
	function loadEmployeeIdDataSuccessful(data, status) {

		if (data !== undefined && data !== null) {
			var autoCompleteData = new Array();
			for (i = 0; i < data.length; i++) {
				if (data[i] !== undefined && data[i] !== null) {
					if (data[i].employeeId !== undefined
							&& data[i].employeeId !== null) {
						autoCompleteData[i] = data[i].employeeId + '';
					}
				}
			}

			try {
				$("#txtStaffID").autocomplete(autoCompleteData, {
					width : 320,
					max : 10

				});

			} catch (e) {
			}
		}

	}

	function checkInUser() {
		$('#lblOperationStatus').text('');
		CheckInService.checkInUser($('#txtStaffID').val(),0,
				'processCheckInUserResponse',BaseSuccessDelegate);
	}

	function processCheckInUserResponse(data) {
		$.jGrowl(data.firstName + " " + data.lastName + " was clocked in.");

	}

	function checkOutUser() {
		CheckInService.checkOutUser($('#txtStaffID').val(),
				'processCheckOutUserResponse',BaseSuccessDelegate);
	}

	function processCheckOutUserResponse(data) {
		$.jGrowl(data.firstName + " " + data.lastName + " was clocked out.");
			
	}