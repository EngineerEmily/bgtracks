<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<title>BGTracks - Configure</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<%
	//  Include the head section.  This is where all css and js files are specified.
%>
<%@ include file="../modules/head.jspf"%>
<link rel="stylesheet" href="css/validationEngine.jquery.css"
	type="text/css" media="screen" charset="utf-8" />

<script type='text/javascript' src='js/jquery.validationEngine.js'></script>

</head>
<body>
<!-- Begin #maincontainer: Outer container that keeps the page centered and contained in a fixed-width box in the screen -->
<div id="maincontainer"><!-- Begin #topsection: Container for header and breadcrumbs  -->
<div id="topsection"><!-- Begin #topsection .innertube: Contains anything that belongs in the header plus the breadcrumbs.  Most styling is done on this div rather than #topsection -->
<div class="innertube ui-widget-header ui-corner-all">
<table>
	<tr>
		<td><a href="viewDefault.htm"><img src="images/Logo-2-white.png" style="padding: 5px; border: none; float: left; margin-right: 10px;" alt="BGTracks" /></a>
		<h1>Configure</h1>


		</td>
		<td class="jump-nav">
		<div class="block">
		<ul>
			<li id="menu-firedrillreport"><a
				href="frameset?__report=emergencyroster.rptdesign">Emergency
			Roster<br />
			<span>Get an instant list of checked-in members</span></a></li>
		</ul>
		</div>
		</td>
	</tr>
</table>
<!--  end #topsection .innertube --></div>
<!-- end #topsection --></div>
<div class="breadcrumbs ui-widget-header ui-corner-all"><a
	href="viewDefault.htm">Home</a> &gt; <a href="configure.htm">Configure</a>
<!-- End .breadcrubms --></div>
<!-- Begin #contentwrapper: Wrapper for everything in the right content column. -->
<div id="contentwrapper"><!-- Begin #contentcolumn: Container for content -->
<div id="contentcolumn"><!-- Begin #contentcolumn .innertube: houses all of the content.  Most of the styling is done to this div rather than #contentcolumn -->
<div class="innertube"><!-- Begin #accordion: Container for the accordion UI for the home page widgets.  Each <h3>/<div> combination below forms a box in the accordion.  Each box should be placed in a separate module and included rather than hard coded here. -->

<div class="demo">
<div id="tabs">
<ul>
	<li><a href="#tabs-1">Member Management</a></li>
	<li><a href="#tabs-2">Staff Management</a></li>

</ul>
<div id="tabs-1" class="tabs" style="padding: 0px;">
<p><input type="text" size="20" id="txtSearchMember"></input><a
	class="utility-link"
	href="javascript:searchGrid('tblNewMember','txtSearchMember');">Search</a><a
	class="utility-link"
	href="javascript:$('#txtSearchMember').val('');searchGrid('tblNewMember','txtSearchUser');">Reset</a></p>
<table id="tblNewMember" class="scroll" cellpadding="0" cellspacing="0"></table>
<div id="dvNewMember" class="scroll" style="text-align: center;"></div>
</div>
<div id="tabs-2" class="tabs" style="padding: 0px;">
<p><input type="text" size="20" id="txtSearchUser"></input><a
	class="utility-link"
	href="javascript:searchGrid('tblNewMember','txtSearchUser');">Search</a><a
	class="utility-link"
	href="javascript:$('#txtSearchUser').val('');searchGrid('tblNewMember','txtSearchUser');">Reset</a></p>
<table id="tblNewEmployee" class="scroll" cellpadding="0" cellspacing="0"></table>
<div id="dvNewUser" class="scroll" style="text-align: center;"></div>

</div>
</div>
</div>
<!-- End demo -->
<div style="display: none" class="demo-description">
<p>Click tabs to swap between content that is broken into logical
sections.</p>
</div>
<!-- End demo-description --> <!-- End #contentcolumn .innertube --></div>
<!-- End #contentcolumn --></div>
<!-- End #contentwrapper --></div>

<!-- Begin #leftcolumn: Container for everything in the left column e.g. navigation -->
<div id="leftcolumn"><!-- Begin #leftcolumn .innertube: houses all of the blocks in the column.  Each module in this section should begin with a div with class="block"  Blocks will be treated in much the same way that Drupal treats blocks. -->
<div class="innertube"><%@ include
	file="../modules/navigation.jspf"%> <!-- End #leftcolumn .innertube -->
</div>
<!-- End #leftcolumn --></div>
<!-- Begin #Footer: Straightforward.  Whatever is in the footer appears at the bottom of the page -->
<div id="footer"></div>
<!-- End #maincontainer --></div>

<script type="text/javascript">
	$(document).ready(function() {

		$("#tabs").tabs( {
			selected : 0,
			select : function(event, ui) {

				if (ui.index == 0) {

					createGrid('tblNewMember', 'dvNewMember', true);
				} else {

					createGrid('tblNewEmployee', 'dvNewUser', false);
				}
			}

		});
		createGrid('tblNewMember', 'dvNewMember', true);

	});

	function searchGrid(container, element, isReset) {
		jQuery("#" + container).setGridParam( {
			page : 1,
			search : true
		});

		jQuery("#" + container).setPostData( {
			searchValue : jQuery("#" + element).val()
		});

		jQuery("#" + container).trigger('reloadGrid');

	}

	var currentlyIsMember = false;
	function createGrid(container, pager, isMember) {
		currentlyIsMember = isMember;
		jQuery("#" + container).GridUnload();
		jQuery("#" + container)
				.jqGrid(
						{
							pager : jQuery("#" + pager),
							rowNum : 10,
							//autowidth : true,
							rowList : [ 10, 20, 30 ],
							sortname : currentlyIsMember === true ? 'firstName' :'username',
							viewrecords : true,
							sortorder : "asc",
							gridview : true,
							datatype : function(postdata) {
								var searchValue = postdata['searchValue'] !== undefined ? postdata.searchValue
										: '';
								if (currentlyIsMember === true) {
									MemberService
											.loadMembers(
													postdata.page,
													postdata.rows,
													postdata.sidx,
													postdata.sord,
													searchValue,
													function(data) {
														var thegrid = jQuery("#tblNewMember")[0];
														thegrid
																.addJSONData(data);
													});
								} else {
									EmployeeService
											.loadEmployees(
													postdata.page,
													postdata.rows,
													postdata.sidx,
													postdata.sord,
													searchValue,
													function(data) {
														var thegrid = jQuery("#tblNewEmployee")[0];
														thegrid
																.addJSONData(data);
													});
								}

							},
							jsonReader : {
								root : "rows",
								page : "page",
								total : "total",
								records : "records",
								repeatitems : false,
								cell : "",
								id : currentlyIsMember === true ? "memberId"
										: "id"
							},
							height : 300,
							width : $('#tabs').width() - 2,
							gridComplete : function() {
								var ids = $("#" + container).getDataIDs();

								for ( var i = 0; i < ids.length; i++) {
									var cl = ids[i];

									if (currentlyIsMember === true) {

										userId = $("#" + container).getRowData(
												cl)['memberId'];
										if (userId !== undefined
												&& userId !== null
												&& userId != 'system') {
											be = "<table ><tr><td style='border:0'><span class='ui-icon ui-icon-wrench' style='cursor:pointer;' onclick=\"editMember("
													+ userId + ")\"/></td>";
											de = "<td style='border:0'><span class='ui-icon ui-icon-trash' style='cursor:pointer;' onclick=\"deleteMember("
													+ userId
													+ ")\"/></td></tr></table>";
											$("#" + container).setRowData(
													ids[i], {
														act : be + de
													});
										}
									} else {
										userId = $("#" + container).getRowData(
												cl)['id'];
										if (userId !== undefined
												&& userId !== null
												&& userId != 'system') {
											be = "<table ><tr><td style='border:0'><span class='ui-icon ui-icon-wrench' style='cursor:pointer;' onclick=\"editEmployee("
													+ userId + ")\"/></td>";
											de = "<td style='border:0'><span class='ui-icon ui-icon-trash' style='cursor:pointer;' onclick=\"deleteEmployee("
													+ userId
													+ ")\"/></td></tr></table>";
											$("#" + container).setRowData(
													ids[i], {
														act : be + de
													});
										}
									}
								}
							},
							colNames : [ '', ' ', '', 'User Name',
									'First Name', 'Last Name', 'Enabled',
									 'Gender', 'Birth Date' ],
							colModel : [ {
								name : 'act',
								index : 'act',
								width : 46,
								fixed : true,
								sortable : false,
								resizable : false
							}, {
								name : 'memberId',
								index : 'memberId',
								hidden : true
							}, {
								name : 'id',
								index : 'id',
								hidden : true
							}, {
								name : 'username',
								index : 'username',
								width : 60,
								sorttype : "text",
								align : "left",
								hidden : currentlyIsMember
							}, {
								name : 'firstName',
								index : 'firstName',
								width : 60,
								sorttype : "text",
								align : "left"
							}, {
								name : 'lastName',
								index : 'lastName',
								width : 90,
								sorttype : "text",
								align : "left"
							}, {
								name : 'enabled',
								index : 'enabled',
								width : 100,
								sorttype : "text",
								align : "left",
								hidden : currentlyIsMember
							}, {
								name : 'sexString',
								index : 'sexString',
								width : 80,
								align : "left",
								sorttype : "text",
								hidden : !currentlyIsMember
							}, {
								name : 'birthDate',
								index : 'birthDate',
								width : 100,
								align : "left",
								sorttype : "date",
								datefmt : 'Y-m-d',
								hidden : !currentlyIsMember
							} ]
						}).navGrid("#" + pager, {
					edit : false,
					add : false,
					del : false,
					search : false
				}).navButtonAdd("#" + pager, {
					caption : "",
					buttonicon : "ui-icon-plus",
					onClickButton : function() {
						if (currentlyIsMember == true) {
							showNewMember();
						} else {
							showNewEmployee();
						}
					},
					position : "last"
				});

	}
	function editMember(memberId) {
		MemberService.findMemberById(memberId, loadExistingMemberResponse);
	}

	function editEmployee(employeeId) {
		EmployeeService.findEmployeeById(employeeId,
				loadExistingEmployeeResponse);
	}

	function deleteMember(memberId) {
		MemberService.deleteMember(memberId, 'deleteMemberResponse',
				BaseSuccessDelegate);
	}

	function deleteEmployee(employeeId) {
		EmployeeService.deleteEmployee(employeeId, deleteEmployeeResponse);
	}
	var isMemberAdd = false;
	function showMemberDialog(isAdd) {
		isMemberAdd = isAdd;
		$("#frmNewMember").validationEngine( {
			success : true,
			failure : function() {
			}
		});
		// open .createNewMember dialog
		$(".createNewMember").dialog(
				{
					bgiframe : true,
					width : 500,
					modal : true,
					close : function(ev, ui) {
						$('div.formError').remove();
						$(this).dialog('destroy');
					},
					// TODO finish out the createNewMember dialog
					buttons : {

						Cancel : function() {
							$(this).dialog('close');
						},
						Ok : function() {
							if ($.validationEngine.submitValidation(this,
									$.validationEngine.settings) == false) {
								if (isMemberAdd === true) {
									addNewMember();
								} else {
									updateExistingMember();
								}
							}
						}
					}
				});
	}
	var isUserAdd = false;
	function showEmployeeDialog(isAdd) {
		isUserAdd = isAdd;
		$("#frmNewUser").validationEngine( {
			success : true,
			failure : function() {
			}
		});

		// open .createNewMember dialog
		$(".createNewUser").dialog(
				{
					bgiframe : true,
					width : 500,
					modal : true,
					close : function(ev, ui) {
						$('div.formError').remove();
						$(this).dialog('destroy');
					},
					// TODO finish out the createNewMember dialog
					buttons : {

						Cancel : function() {
							$(this).dialog('close');
						},
						Ok : function() {

							if ($.validationEngine.submitValidation(this,
									$.validationEngine.settings) == false) {
								if (isUserAdd === true) {

									addNewUser();
								} else {
									updateExistingEmployee();
								}
							}
						}
					}

				});
	}

	function showNewEmployee() {
		$('#txtUserFirstName').val('');
		$('#txtUserLastName').val('');
		$('#txtUserUserName').val('');
		$('#txtUserPassword').val('');
		$('#txtUserConfirmPassword').val('');
		$('#txtUserEmail').val('');
		$('#cbLoginEnabled').attr("checked", "");

		showEmployeeDialog(true);
	}

	function showNewMember() {
		$('#hfMemberId').val('');
		$('#txtFirstName').val('');
		$('#txtLastName').val('');
		$('#txtBirthDate').val('');
		$('#txtNickName').val('');

		$('#txtAddress1').val('');
		$('#txtAddress2').val('');
		$('#txtCity').val('');
		$('#txtState').val('');
		$('#txtZip').val('');
		$('#txtHomePhone').val('');
		$('#txtCellPhone').val('');
		showMemberDialog(true);
	}

	function updateExistingEmployee(employee) {
		var employee = {
			id : $('#hfUserId').val(),
			firstName : $('#txtUserFirstName').val(),
			lastName : $('#txtUserLastName').val(),
			username : $('#txtUserUserName').val(),
			email : $('#txtUserEmail').val(),
			enabled : $('#cbLoginEnabled').attr("checked")
		};
		EmployeeService.updateEmployee(employee, 'updateEmployeeResponse',BaseSuccessDelegate);
	}

	// This function assumes that the
	// dwr javascript reference has been added to the page
	function addNewUser() {
		var employee = {
			firstName : $('#txtUserFirstName').val(),
			lastName : $('#txtUserLastName').val(),
			username : $('#txtUserUserName').val(),
			password : $('#txtUserPassword').val(),
			email : $('#txtUserEmail').val(),
			enabled : $('#cbLoginEnabled').attr("checked")
		};

		EmployeeService.addEmployee(employee, 'addNewEmployeeResponse',BaseSuccessDelegate);

	}

	function updateEmployeeResponse(data) {
			$(".createNewUser").dialog('close');
			jQuery("#tblNewEmployee").trigger('reloadGrid');
			$.jGrowl("Employee successfully updated.");
	}

	function addNewEmployeeResponse(data) {
			$(".createNewUser").dialog('close');
			jQuery("#tblNewEmployee").trigger('reloadGrid');
			$.jGrowl("Employee successfully created.");
	}

	function deleteMemberResponse(data) {
		jQuery("#tblNewMember").trigger('reloadGrid');
		$.jGrowl("Member Deleted created.");
	}
	function deleteEmployeeResponse(data) {
			jQuery("#tblNewEmployee").trigger('reloadGrid');
			$.jGrowl("Employee Deleted created.");
	}
	function loadExistingMemberResponse(member) {

		$('#selMemberSite').val(1);
		$('#hfMemberId').val(member.memberId);
		$('#txtFirstName').val(member.firstName);
		$('#txtLastName').val(member.lastName);
		$('#txtBirthDate').val('');
		if(member.siteId !== undefined && member.siteId !== null){
			$('#selMemberSite').val(member.siteId);
		}
		if(member.birthDate !== null)
		{
			$('#txtBirthDate').val(member.birthDate);
		}
		$('#txtNickName').val(member.nickName);

		$('#txtAddress1').val(member.address1);
		$('#txtAddress2').val(member.address2);
		$('#txtCity').val(member.city);
		$('#txtState').val(member.state);
		$('#txtZip').val(member.zip);
		$('#txtHomePhone').val(member.homePhone);
		$('#txtCellPhone').val(member.cellPhone);
		showMemberDialog(false);
	}

	function loadExistingEmployeeResponse(employee) {
		$('#hfUserId').val(employee.id);
		$('#txtUserFirstName').val(employee.firstName);
		$('#txtUserLastName').val(employee.lastName);
		$('#txtUserUserName').val(employee.username);
		$('#txtUserPassword').val('');
		$('#txtUserConfirmPassword').val('');
		$('#txtUserEmail').val(employee.email);
		$('#cbLoginEnabled').val(employee.enabled);

		showEmployeeDialog(false);
	}

	// This function assumes that the
	// dwr javascript reference has been added to the page
	function addNewMember() {
		MemberService.addMember(populateMember(), 'addNewMemberResponse',
				BaseSuccessDelegate);

	}

	String.prototype.trim = function() {
		return this.replace(/^\s+|\s+$/g, "");
	};

	function populateMember() {
		var member = {
			memberId : $('#hfMemberId').val(),
			siteId : $('#selMemberSite').val(),
			firstName : $('#txtFirstName').val(),
			lastName : $('#txtLastName').val(),
			birthDate : $('#txtBirthDate').val().trim().length == 0 ? null
					: new Date($('#txtBirthDate').val()),
			sexString : $("input[@name='rbGender']:checked").val(),
			nickName : $('#txtNickName').val(),
			ethnicityCd : $("#selEthnicity option:selected").text(),
			address1 : $('#txtAddress1').val(),
			address2 : $('#txtAddress2').val(),
			city : $('#txtCity').val(),
			state : $('#txtState').val(),
			zip : $('#txtZip').val(),
			homePhone : $('#txtHomePhone').val(),
			cellPhone : $('#txtCellPhone').val()
		};
		return member;

	}

	function updateExistingMember() {
		MemberService.updateMember(populateMember(),
				'updateExistingMemberResponse', BaseSuccessDelegate);
	}

	function updateExistingMemberResponse(data) {
		jQuery("#tblNewMember").trigger('reloadGrid');
		$(".createNewMember").dialog('close');
		$.jGrowl("Member successfully updated.");
	}

	function addNewMemberResponse(data) {
		jQuery("#tblNewMember").trigger('reloadGrid');
		$(".createNewMember").dialog('close');
		$.jGrowl("Member successfully created.");
	}
</script>
<%@ include file="../modules/newmember.jspf"%>
<%@ include file="../modules/newuser.jspf"%>

</body>
</html>
