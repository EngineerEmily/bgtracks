<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
  <head>
    <title>BGTracks - Reports</title>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    
    <%@ include file="../modules/head.jspf" %>   

  </head>
  <body>
    <div id="maincontainer">    
			<!-- Begin #topsection: Container for header and breadcrumbs  -->	
			<div id="topsection">
			
				<!-- Begin #topsection .innertube: Contains anything that belongs in the header plus the breadcrumbs.  Most styling is done on this div rather than #topsection -->
				<div class="innertube ui-widget-header ui-corner-all">
					<table>
						<tr><td>
						<a href="viewDefault.htm"><img src="images/Logo-2-white.png" style="padding:5px;border:none;float:left;margin-right:10px;" /></a>
						<h1>Reports</h1>
						
		
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
				<a href="viewDefault.htm">Home</a> &gt; <a href="viewReports.htm">Reports</a> 
			<!-- End .breadcrubms -->
			</div>
      <div id="contentwrapper">
        <div id="contentcolumn">
          <div class="innertube">
            <div id="accordion" class="ui-helper-reset ui-accordion">
              <%@ include file="../modules/reports.jspf" %>
            </div>
          </div>
        </div>
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
      
      <div id="footer"></div>
      
    </div>
  </body>
</html>
