
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
            String email=request.getParameter("email"), password="";
            session.setMaxInactiveInterval(18000);
            Connection c = PostgreSQLJDBC.getConn();
            Utente p = new Utente();
            Statement statement= c.createStatement();
            ResultSet resultSet = null;
            String sql = "select * from utente where email =" + email;
            resultSet = statement.executeQuery(sql);
            
            if(request.getParameter("email") !=null && request.getParameter("password") !=null){
                email=request.getParameter("email");
                password=request.getParameter("password");
                session.setAttribute("email", email);
                session.setAttribute("password", password);

            }
            
            /*if(){      
                session.setAttribute(email,"email");
                session.setAttribute(password,"password");
                out.write("login effettuato");*/
                %>
                
             <input class="button" type="button" value="Torna a Login" onclick="window.location.href='index.jsp'">
             
                <%
            }
            else if(email==null && password==null ){
                response.sendRedirect("index.jsp");
            } 
            else
                response.sendRedirect("index.jsp"); 
        %>

       
        
    </body>
</html>
