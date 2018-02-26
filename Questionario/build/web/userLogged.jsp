<%-- 
    Document   : userLogged
    Created on : 20-feb-2018, 17.04.55
    Author     : youne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Archivio.*"%>
<!DOCTYPE html>
  <html>

      <head>
         <meta http-equiv="Content-Type" 
            content="text/html; charset=windows-1256">
         <title>   User Logged Successfully   </title>
      </head>
	
      <body>

            <% 
               try{
                session.getAttribute("currentSessionUser").toString();
               }
               catch(NullPointerException e){
                   response.sendRedirect("index.jsp");
               }
                
                Utente currentUser = (Utente) (session.getAttribute("currentSessionUser")); 
                
               
            %>
			
     

      </body>
	
   </html>
