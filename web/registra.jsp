
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="dati.jsp" method="post"> 
            <input placeholder="nome" type="text" name="nome"> <br>
            <input placeholder="cognome" type="text" name="cognome"> <br>
            <input placeholder="cellulare" type="text" name="cellulare"> <br>
            <input placeholder="password" type="password" name="password"> almeno 6 caratteri alfanumerici <br>
            <input placeholder="email" type="text" name="email"> <br>
            <input type="date" id="nascita" name="nascita" min="1900-01-01">

            <br>
            <input class="button" type="submit" value="Registra" name="submit">
            <input class="button" type="button" value="Torna Login" onclick="window.location.href='index.jsp'">
    </body>
</html>
