
<%@page import="java.sql.SQLException"%>
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
            
            String email=null, password=null;
            session.setMaxInactiveInterval(18000);
            if(request.getParameter("email") !=null && request.getParameter("password") !=null){
               email=request.getParameter("email");
               password=request.getParameter("password");
            }
            Connection c = PostgreSQLJDBC.getConn();
            Utente p = new Utente();
            Statement statement= c.createStatement();
            ResultSet resultSet = null;
            try{
                String sql = "SELECT * FROM utente WHERE email ='"+ email+"'";
                resultSet = statement.executeQuery(sql);
            }
            catch(SQLException e){
                response.sendRedirect("index.jsp");
            }
            
            if(resultSet.next()){
                if(resultSet.getString("password").equals(password)){
                    session.setAttribute(email,"email");
                    session.setAttribute(password,"password");
                    out.write(resultSet.getString("password"));
                }
                else
                    response.sendRedirect("index.jsp");
            }
            else
                response.sendRedirect("index.jsp"); 
            
           /* if (session.getAttribute("username") == null || session.getAttribute("username").equals("") || session.getAttribute("passowrd") == null || session.getAttribute("password").equals(""))
                response.sendRedirect("index.jsp"); 
                */
        %>
        
        

       
        
    </body>
</html>
