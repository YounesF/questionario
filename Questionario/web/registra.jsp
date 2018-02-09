
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
            <input placeholder="cellulare" type="number" name="cellulare"> <br>
            <input placeholder="password" type="password" name="password"> almeno 6 caratteri alfanumerici <br>
            <input placeholder="email" type="text" name="email"> <br>
            Giorno: <select id="giorno" name="giorno">
                <option value="1" selected> 1 </option>
                <%   
                    for(int i = 2; i <= 31; i++){ %>
                    <option value="<%  out.write(Integer.toString(i)); %>"> <% out.write(Integer.toString(i)); }%> </option>
                %>
            </select>
            
            Mese <select id="mese" name="mese">
                <option value="1" selected> 1 </option>
                <%   
                    for(int i = 2; i <= 12; i++){ %>
                    <option value="<%  out.write(Integer.toString(i)); %>"> <% out.write(Integer.toString(i)); }%> </option>
                %>
            </select>    
             
            Anno <select id="anno" name="anno">
                <option value="2018" selected> 2018 </option>
                <%   
                    for(Integer i = 2017; i <= 1900; i--){ %>
                    <option value="<%  out.write(Integer.toString(i)); %>"> <% out.write(Integer.toString(i)); }%> </option>
                %>
            </select>

            <br>
            <input class="button" type="submit" value="Registra" name="submit">
            <input class="button" type="button" value="Torna Login" onclick="window.location.href='index.jsp'">
    </body>
</html>
