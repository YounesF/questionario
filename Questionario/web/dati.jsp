
<%@page import="java.sql.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="Archivio.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
        <jsp:useBean id="p" class="Utente"/>
        <jsp:setProperty name="p" property="*"/>
    <body>
           <% 
                 
            /*if(archivio.isUserIDTaken(userID)){
               response.sendRedirect("registra.jsp"); 
            }
            if(archivio.isEmailTaken(email)){
               response.sendRedirect("registra.jsp"); 
            }
            if(!(password.length()>6&& password.matches(".*\\d+.*"))){
               response.sendRedirect("registra.jsp");  
            }
            if(!(email.contains("@"))){
                response.sendRedirect("registra.jsp"); 
            }*/
            
            UtenteDAO.insertUtente(p);
            out.write("<br>");
                      
           %> 
           
            <div>
            <br>
            <input class="button" type="button" value="Torna a Login" onclick="window.location.href='index.jsp'">
            </div>
            
    </body>
</html>
