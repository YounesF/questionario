<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="login.jsp" method="post"><br/>
            <input placeholder="email" type="text" name="email"><br>
            <input placeholder="password" type="password" name="password"><br>
        <input class="button" type="submit" value="Entra" name="submit">
        <input class="button" type="button" value="Registrati" onclick="window.location.href='registra.jsp'">
        
        </form>
        
    </body>
</html>
