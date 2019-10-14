import java.util.*;

public class Experiment{
   public static void main( String args[] ) {

 
     String timeZoneParam = "America/Los_Angeless";
     //TimeZone.setDefault(TimeZone.getTimeZone("Pacific/Fakaof"));
     TimeZone timeZone; 

     if(Arrays.asList(TimeZone.getAvailableIDs()).contains(timeZoneParam))timeZone = TimeZone.getTimeZone(timeZoneParam);
      else timeZone = TimeZone.getTimeZone("UTC");


     System.out.println(timeZone);
     

      // set time zone to default
        
      // checking default time zone
      System.out.println("Default time zone:" + timeZone);
      Asia%2FCalcutta  
      America%2FAnchorage

   }    
}



modified:   .idea/misc.xml
modified:   .idea/modules.xml
modified:   src/main/java/com/work/web/controllers/Authentication.java
modified:   src/main/java/com/work/web/controllers/ProcessController.java
deleted:    src/main/webapp/WEB-INF/appengine-generated/encoded_gs_key:L2dzL2ltYWdlcy5zYi5hLWN0aS5jb20vZnVsbF9zcGVjdHJ1bS9zaGFrdGkuY2hvdWRoYXJ5QGFueXdoZXJl
LmNvL3RyYW5zZmVycmVkRmlsZXMvL3V4a0hPQkNIM3JBTzgwOXkyLUxTM0E
modified:   src/main/webapp/css/admin-new.css
modified:   src/main/webapp/dist/adminPanel.bundle.js
modified:   src/main/webapp/js/admin/activity.js













