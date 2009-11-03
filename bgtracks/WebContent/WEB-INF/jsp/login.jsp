<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>BGTracks - Welcome</title>

<%@ include file="../modules/head.jspf" %> 	
<script type="text/javascript">
	$().ready( function() {
		$('#left').height($(window).height() - 85);
	});
</script>
</head>
<body>
<div id="outer" style="background:url('images/Logo-standalone-white.png') no-repeat top left">
<%@ include file="masterfragment.jsp"%>

<div id="container">
<div id="center" class="column">
<form id="loginForm" name="loginForm" action="j_spring_security_check"
	method="post">
<center>
<table style="margin-top: 200px;">
	<tr>
		<th colspan="2">Welcome, Please sign in.</th>
	</tr>
	<tr>
		<td>Username</td>
		<td><input id="usernameField" type="text" name="j_username" /></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input id="passwordField" type="password" name="j_password" /></td>
	</tr>
	<tr>
		<td colspan="2" align="right"><input type="submit" value="Login" /></td>
	</tr>
</table>
</center>
</form>
</div>
<div id="left" class="column"><%@ include file="navigation.jsp"%></div>
<div id="right" class="column"></div>
</div>
</div>
</body>
</html>
