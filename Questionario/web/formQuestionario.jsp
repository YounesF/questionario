<%@page import="java.util.ArrayList"%>
<%@page import="Archivio.Domanda"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "mandaALogin.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Questionario</title>
    </head>
    <body>
        <div id="VisualizzaQuestionario">
            <form id="formQuestionario" action="RisposteUtenteServlet">
            <%
                ArrayList<Domanda> questionarioVisual = (ArrayList<Domanda>) (session.getAttribute("questionarioVisual"));
                for(Domanda d: questionarioVisual){
                    if(d.isAperta()){
                        out.write(d.getDomanda()+"<br> <input type='text' name='"+d.getIdDomanda()+"'><br>");
                        out.write("<br>");
                    }
                    else if(d.isMultipla()){
                        out.write(d.getDomanda()+"<br>");
                        for(String r: d.getRisposte()){
                            out.write("<input type='checkbox' name='"+d.getIdDomanda()+"' value='"+r+"'>"+ r +"<br>");
                            
                        }
                        out.write("<br>");
                    }
                    else{
                        out.write(d.getDomanda()+"<br>");
                        for(String r: d.getRisposte()){
                            out.write("<input type='radio' name='"+d.getIdDomanda()+"' value='"+r+"'>"+ r +"<br>");
                        }
                    }
                }
                
                out.write("<br><input type='submit' value='Invia' class='submit'>");

                %>
            </form>
        </div>
    </body>
</html>
