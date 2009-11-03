<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
	<head>
    <title>BGTracks - Home</title>
    
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		
		<%//  Include the head section.  This is where all css and js files are specified.%>
		<%@ include file="../modules/head.jspf" %> 	

	</head>
	<body>
	<!-- Begin #maincontainer: Outer container that keeps the page centered and contained in a fixed-width box in the screen -->
		<div id="maincontainer">	
			
			<!-- Begin #topsection: Container for header and breadcrumbs  -->	
			<div id="topsection">
			
				<!-- Begin #topsection .innertube: Contains anything that belongs in the header plus the breadcrumbs.  Most styling is done on this div rather than #topsection -->
				<div class="innertube ui-widget-header ui-corner-all">
					<table>
						<tr><td>
						<a href="viewDefault.htm"><img src="images/Logo-2-white.png" style="padding:5px;border:none;float:left;margin-right:10px;" alt="BGTracks" /></a>
						<h1>Home</h1>
						
						<!-- Begin .breadcrumbs: Display a trail back to the home page.  -->

						</td>
						<td class="jump-nav">
						<div class="block"><ul><li id="menu-firedrillreport"><a href="frameset?__report=emergencyroster.rptdesign">Emergency Roster<br /><span>Get an instant list of checked-in members</span></a></li></ul></div>
						</td>
						</tr>
					</table>
				<!--  end #topsection .innertube -->
				</div>
			<!-- end #topsection -->
			</div>
				<div class="breadcrumbs ui-widget-header ui-corner-all">
				<a href="viewDefault.htm">Home</a>  
			<!-- End .breadcrubms -->
			</div>

			<!-- Begin #contentwrapper: Wrapper for everything in the right content column. -->
			<div id="contentwrapper">
				<!-- Begin #contentcolumn: Container for content -->
				<div id="contentcolumn">
					<!-- Begin #contentcolumn .innertube: houses all of the content.  Most of the styling is done to this div rather than #contentcolumn -->
					<div class="innertube">
						<!-- Begin #accordion: Container for the accordion UI for the home page widgets.  Each <h3>/<div> combination below forms a box in the accordion.  Each box should be placed in a separate module and included rather than hard coded here. -->
						<div id="accordion" class="ui-helper-reset ui-accordion">
						
						   <% // Include activitycheckin widget module %>
			               <%@ include file="../modules/activitycheckin.jspf" %>
			               <% // Include masscheckin widget modlue %>
			               <%@ include file="../modules/masscheckin.jspf" %>
			               <% // Include staffclockin widget module %>
			               <%@ include file="../modules/staffclockin.jspf" %>
			             
						<!-- End #accordion -->
						</div>
					<!-- End #contentcolumn .innertube -->
					</div>
				<!-- End #contentcolumn -->
				</div>
			<!-- End #contentwrapper -->
			</div>
			
			<!-- Begin #leftcolumn: Container for everything in the left column e.g. navigation -->
			<div id="leftcolumn">
			  <!-- Begin #leftcolumn .innertube: houses all of the blocks in the column.  Each module in this section should begin with a div with class="block"  Blocks will be treated in much the same way that Drupal treats blocks. -->
			  <div class="innertube">
			  
                <%@ include file="../modules/navigation.jspf" %>
			  <!-- End #leftcolumn .innertube -->			
			  </div>
			<!-- End #leftcolumn -->
			</div>
			<!-- Begin #Footer: Straightforward.  Whatever is in the footer appears at the bottom of the page -->
			<div id="footer">
			
			
<a href="#" onclick="createShortcut();">Install Desktop Shortcut</a>

<script type="text/javascript"  src="http://code.google.com/apis/gears/gears_init.js"></script>

<script type="text/javascript" src="js/gearsdesktop.js">

</script>

			</div>
		<!-- End #maincontainer -->
		</div>



	</body>
</html>
