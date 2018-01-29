
<%@page import="Archivio.Persona"%>
<%@page import="Archivio.Archivio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
           <% 
            String nome, cognome, email, userID, password;
            Archivio archivio=(Archivio)application.getAttribute("archivio");
            if (archivio == null){
                archivio = new Archivio();
                application.setAttribute("archivio",archivio);
            }
            
           
            nome=request.getParameter("nome");
            cognome=request.getParameter("cognome");
            userID=request.getParameter("userID");
            password=request.getParameter("password");
            email=request.getParameter("email");
            
            if(archivio.isUserIDTaken(userID)){
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
            }
            
            archivio.aggiungi(new Persona(nome,cognome,userID,password,email));
            
            application.setAttribute("archivio", archivio);

            out.write("<br>");
          
            out.write(archivio.lista());
            
           %> 
           
            <div>
            <br>
            <input class="button" type="button" value="Torna a Login" onclick="window.location.href='index.jsp'">
            </div>
            
    </body>
</html>
