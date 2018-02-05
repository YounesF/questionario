<%-- 
    Document   : success
    Created on : 2-feb-2018, 11.48.12
    Author     : sala.stefano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="prova.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="obj" class="prova.CustomerBean"/>
        <jsp:setProperty name="obj" property="*"/>
        
        <%
             CustomerDAO.insertCustomer(obj);
       
        %>
            
    </body>
</html>
