<%@page contentType="text/html" pageEncoding="UTF-8" import="Archivio.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        
        <%
            Cookie[] cookies=request.getCookies();
            String userName = "", password = "",rememberVal="";
            if (cookies != null) {
                 for (Cookie cookie : cookies) {
                   if(cookie.getName().equals("cookmail")) {
                     userName = cookie.getValue();
                   }
                   if(cookie.getName().equals("cookpass")){
                     password = cookie.getValue();
                   }
                   if(cookie.getName().equals("cookrem")){
                     rememberVal = cookie.getValue();
                   }
                }
            }
        %>
        
        <form action="<%=request.getContextPath()%>/LoginServlet" method="post"><br/>
            <input placeholder="email" type="text" name="email"><br>
            <input placeholder="password" type="password" name="password"><br>
            Ricordami <input name="Ricordami" type="checkbox" value="Ricordami" />
        <input class="button" type="submit" value="Entra">
        </form>
        <input class="button" type="button" value="Registrati" onclick="window.location.href='registra.jsp'">
        
        <input class="button" type="button" value="Hai dimenticato la password?" onclick="window.location.href='recupera.jsp'">
        
    </body>
</html>
