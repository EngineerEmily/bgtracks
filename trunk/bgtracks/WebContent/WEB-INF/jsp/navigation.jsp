<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<ul
	style="list-style-type: none; font-size: 12px; margin: 0px; padding: 0px;">
	<%
		if (org.springframework.security.context.SecurityContextHolder
				.getContext().getAuthentication() != null) {
	%>
	<li><a href="<c:url value="/j_spring_security_logout"/>">Sign
	Out</a></li>
	
	<%
		}
	%>
</ul>