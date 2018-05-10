<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/main.css" type="text/css"/>
        <title>Questionario</title>
    </head>
    <body>	
        <div class="limiter">
            <div class = "container-login100 validate-input m-b-26" id="creaQuestionario">
                <div class="wrap-login100" >
                    <div class="login100-form-title" style="background-image: url(images/img2.png)">
                        <span class="login100-form-title-1">

                        </span>
                    </div>
                    <form action="QuestionarioServlet" class="creaQ-form">
                        <div class="textTitolo1">
                            <h2>Benvenuto in Survily</h2>
                        </div>
                        <div class="textTitolo">
                            Dai un titolo al tuo sondaggio<br>
                        </div>
                        <div class="wrap-input100 validate-input m-b-26" data-validate="Title is required">
                            <input class="input100" type="text" name="nome" placeholder="Inserisci titolo">
                        </div>
                        <div class="wrap-input100 validate-input m-b-26" data-validate="Numbeer is required">
                            <div class="textTitolo">
                                Inserisci il numero di domande
                            </div>
                            <input type="number" name="numeroDomande" class="input100" placeholder="Inserisci il numero domande">
                        </div>
                        <input type = "submit" value = "Crea" class="creaQ-btn">
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
