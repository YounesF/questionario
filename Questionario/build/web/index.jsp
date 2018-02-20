<%@page contentType="text/html" pageEncoding="UTF-8" import="Archivio.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="LoginServlet"><br/>
            <input placeholder="email" type="text" name="email"><br>
            <input placeholder="password" type="password" name="password"><br>
        <input class="button" type="submit" value="submit">
        </form>
        <input class="button" type="button" value="Registrati" onclick="window.location.href='registra.jsp'">
        
        
        
    </body>
</html>
