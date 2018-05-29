<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" type="text/css" href="css/recuperaPwd.css">
        <meta charset="ISO-8859-1">
        <title>Recupero Password</title>
    </head>
    <body>
        <div class="limiter">
            <div class="container-login100" >
                <div class="wrap-login100">
                    <div class="login100-form-title" style="background-image: url(images/img4.png)">
                        <span class="login100-form-title-1">
                            Recupera password
                        </span>
                    </div>
                    <form class="login100-form" action="RecuperaServlet"><br/>
                        <div class="wrap-input100">
                            <span class="label-inputRecuperaPwd">Inserisci l'Email</span>
                            <input class="inputRecuperaPwd" placeholder="email" type="text" name="email"><br>
                            <span class="focus-input100"></span>
                        </div>
                        <div class="container-login100-form-btn">
                            <input type="submit" class="recuperaPwd-form-btn" value="INVIA">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>