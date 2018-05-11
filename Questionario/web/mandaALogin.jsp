
<%@page import="Archivio.Utente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            try{
                session.getAttribute("currentSessionUser").toString();
            }
            
            catch(NullPointerException e){
                response.sendRedirect("login.jsp");
            }

            Utente currentUser = (Utente) (session.getAttribute("currentSessionUser"));
             
            %>
    </body>
</html>
