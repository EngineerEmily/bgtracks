$(function() {

	/*
	 * Mask phone numbers in forms using the jquery maskedinput plugin from
	 * http://digitalbush.com/projects/masked-input-plugin/.
	 */
	$(".phone-mask").mask("(999) 999-9999");

	/*
	 * Mask zip codes to accept numbers only. Could have done it inline, but
	 * since the plugin is already here...
	 */
	$("input[name='zip']").mask("99999");
	
	$(".time-mask").mask("99:99 am");
	/*
	 * Accordion function for home page. Simply sets every h3/div combo within
	 * the #accordion div as a box in the accordion. autoHeight:false means that
	 * each box will be the heigh of its contents rather than setting one height
	 * for all boxes.
	 */
	$("#accordion").accordion( {
		autoHeight : false
	});

	/*
	 * Hides the exatTime field so that both it and currTime are not showing at
	 * the same time. This is done here rather than in css so that if a user has
	 * JS turned off, they can see either option. Graceful degredation.
	 */
	$(".exactTime").hide();
	$(".massExactTime").hide();

	/*
	 * When the user clicks current time, the current time box fades in and the
	 * exact time box disappears, and the value of the fields are made null.
	 */
	$("input[name='time'][value='currTime']").click(function() {
		
		$(".exactTime").hide();
		$("input[name='exactTimeField']").val(null);
		$("input[name='exactTimeDateField']").val(null);
	});
	$("input[name='massTime'][value='currTime']").click(function() {
		
		$(".massExactTime").hide();
		$("input[name='massExactTimeField']").val(null);
		$("input[name='massExactTimeDateField']").val(null);
	});
	/*
	 * When the user clicks exact time, the exact time box fades in and the
	 * current time box disappears, and the values of the fields are made null.
	 */

	$("input[name='time'][value='exactTime']").click(function() {
		$(".exactTime").fadeIn("fast");

	});
	$("input[name='massTime'][value='exactTime']").click(function() {
		$(".massExactTime").fadeIn("fast");

	});

	/*
	 * Makes any field with the class datepicker use the jquery ui datepicker.
	 */
	$("input[class='datepicker']").datepicker();

	


}); // end of $(function())


