<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Archivio.PostgreSQLJDBC"%>
<%@page import="Archivio.Utente"%>
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
            
            String email=request.getParameter("email"), password=request.getParameter("password");
            if(email == null || password == null){
                response.sendRedirect("index.jsp"); 
            }    
            session.setMaxInactiveInterval(18000);
            Connection c = PostgreSQLJDBC.getConn();
            Utente p = new Utente();
            Statement statement= c.createStatement();
            ResultSet resultSet = null;
            String sql = "SELECT * FROM utente WHERE email =" + email;
            resultSet = statement.executeQuery(sql);
            
            if(resultSet != null && resultSet.getString("password").equals(password))
            {
                session.setAttribute(email,"email");
                session.setAttribute(password,"password");
            }
            else
                response.sendRedirect("index.jsp"); 
            
            if (session.getAttribute("Username") == null || session.getAttribute("Username").equals(""))
                response.sendRedirect("index.jsp"); 
            
            out.write("Ok");
        %>
        
        

       
        
    </body>
</html>
