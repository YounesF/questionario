
<%@page import="java.sql.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="Archivio.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <body>
           <% 
              String nome, cognome, email, password, data;
              int cellulare, giorno, mese, anno;
              
              nome = request.getParameter("nome");
              cognome = request.getParameter("cognome");
              email = request.getParameter("email");
              password = request.getParameter("password");
              cellulare = Integer.parseInt(request.getParameter("cellulare"));
              giorno = Integer.parseInt(request.getParameter("giorno"));
              mese = Integer.parseInt(request.getParameter("mese"));
              anno = Integer.parseInt(request.getParameter("anno"));
              data = ConvertDate.convertDateToString(giorno, mese, anno);
              
              Utente utente = new Utente(nome,cognome,cellulare,email,password,data);
              
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
            
            UtenteDAO.insertUtente(utente);
            out.write(utente.toString());
                      
           %> 
           
            <div>
            <br>
            <input class="button" type="button" value="Torna a Login" onclick="window.location.href='index.jsp'">
            </div>
            
    </body>
</html>
