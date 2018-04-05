<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Questionario</title>
    </head>
    <body>
        <div id="creaQuestionario" >
            <form action="QuestionarioServlet">
                Numero domande: <input type="number" name="numeroDomande"> <br>
                Numero totale di questionari: <input type="number" name="numeroQuest"> <br>
            </form>    
        </div>
    </body>
</html>
