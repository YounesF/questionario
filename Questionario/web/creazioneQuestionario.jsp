<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "mandaALogin.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Questionario</title>
    </head>
    <body>
        <div id="creaQuestionario" >
            <form action="QuestionarioServlet">
                Nome : <input type="text" name="nome"> <br>
                Numero domande: <input type="number" name="numeroDomande"> <br>
                <input type="submit" value="Invia" class="submit">
            </form>    
        </div>
    </body>
</html>
