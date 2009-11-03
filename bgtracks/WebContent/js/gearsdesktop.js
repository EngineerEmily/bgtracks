
function createShortcut() {

	  if (!window.google || !google.gears) {
		    if (confirm("Installing the desktop shortcut requires Google Gears. Install now?")) {
		      // Use an absolute URL to allow this to work when run from a local file.
		      location.href = "http://gears.google.com/?action=install" +
                    "&return=<http://bgtracks.com:8080/org.nucsc480.projectsite/viewDefault.htm>";
		      return;
		    }
		  }else{
  var desktop = google.gears.factory.create("beta.desktop");
  var description = "This shortcut launches BGTracks";
 
  var icons = {
    "16x16": "images/bgtracks16x16.png",
    "32x32": "images/bgtracks32x32.png",
    "48x48": "images/bgtracks48x48.png",
    "128x128": "images/bgtracks128x128.png"
   };
 
  desktop.createShortcut("BGTracks",  // name
                         "http://bgtracks.com:8080/org.nucsc480.projectsite/viewDefault.htm",  // url
                         icons,  // icons (must specify at least one)
                         description);  // description (optional)
		  }
}
