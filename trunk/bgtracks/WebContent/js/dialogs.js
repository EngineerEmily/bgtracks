/*
 * call a dialog with a special status.
 * Currently, valid statuses are cancel-dialog and success-dialog
 */
function callDialog(divTitle,divText,divStatus){
	$("body").append('<div id="dialogDiv" title="'+divTitle+'" style="display:none;"><p>'+divText+'</p></div>');
	$("#dialogDiv").dialog({
        bgiframe: true,    
        modal: true,
        dialogClass: divStatus,
        buttons:{
        	OK: function() {
                $(this).dialog('close');
                $("#dialogDiv").remove();
            } // end of OK button
		}
	});
	
};

