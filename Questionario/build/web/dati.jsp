
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="Archivio.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <body>
           <% 
              String nome, cognome, email, password, dataString;
              int cellulare;
              Date date;
              EmailSessionBean emailSender = new EmailSessionBean();
              
              nome = request.getParameter("nome");
              cognome = request.getParameter("cognome");
              email = request.getParameter("email");
              password = request.getParameter("password");
              cellulare = Integer.parseInt(request.getParameter("cellulare"));
              out.write(request.getParameter("nascita"));
              dataString = request.getParameter("nascita");
              date = ConvertString.convertStringToDate(dataString);
              out.write(date.toString());
              
              Utente utente = new Utente(nome,cognome,cellulare,email,password,date);
              
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
            emailSender.sendEmail(utente.getEmail(), "Verifica email", "codice di accesso");
            
                      
           %> 
           
            <div>
            <br>
            <input class="button" type="button" value="Torna a Login" onclick="window.location.href='index.jsp'">
            </div>
            
    </body>
</html>
