
<%@page import="Archivio.Persona"%>
<%@page import="Archivio.Archivio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        
        
        <% 
            String username="", password="";
            session.setMaxInactiveInterval(18000);
            
            Persona p = new Persona();

            Archivio archivio = (Archivio)application.getAttribute("archivio");
            
            if(archivio == null){
                archivio = new Archivio();
                application.setAttribute("archivio",archivio);
            }
            if(request.getParameter("userID") !=null && request.getParameter("password") !=null){
                username=request.getParameter("userID");
                password=request.getParameter("password");
                session.setAttribute("userID", username);
                session.setAttribute("password", password);
                p = new Persona("","",request.getParameter("userID"),request.getParameter("password"),"");
                session.setAttribute("persona", p);

            }
            
            if(archivio.isPersona((Persona) session.getAttribute("persona"))){      
                session.setAttribute(username,"userID");
                session.setAttribute(password,"password");
                out.write("login effettuato");
                %>
                
             <input class="button" type="button" value="Torna a Login" onclick="window.location.href='index.jsp'">
             
                <%
            }
            else if(username==null && password==null ){
                response.sendRedirect("index.jsp");
            } 
            else
                response.sendRedirect("index.jsp"); 
        %>

       
        
    </body>
</html>
