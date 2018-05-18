<%@page contentType="text/html" pageEncoding="UTF-8"%>


<html>
    <head>
        <title>Survily</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/styleFirstPage.css">
        <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/all.js" integrity="sha384-xymdQtn1n3lH2wcu0qhcdaOpQwyoarkgLVxC/wZ5q7h9gHtxICrpcaSUfygqZGOe" crossorigin="anonymous">
        </script>
    </head>
    <body background="images/backgroundhome4.jpg">

        <header>
            <ul>
                <li class="logoSurvily"><a href="index.jsp"><img class="logo" src="images/logo.png" width="90px" height="40px"></a></li>
                <li class="userLogReg" id="registratiButton"><a href="registra.jsp">Registrati</a></li>
                <li class="userLogReg"><a href="login.jsp">Login</a></li>
            </ul>
        </header>
        <div class="content">
            Crea e rispondi ai questionari
        </div>
        <div class="SpiegaUtenze">
            <div class="cellContainer">
            <div class="spiegaFree">
                <br><h1>Utenza Free</h1>
                -------------------------------
                <div class="testoSpiegaUtenze">
                    <ul class="listaSpiegazione">
                        <li>
                            Compila i questionari
                        </li>
                        <li>
                            Guadagna punti
                        </li>
                        <li>
                            Ottieni ricompense
                        </li>
                        <li>
                            <strike>Crea il tuo questionario</strike>
                        </li>
                        <li>
                            <strike>Ricevi i feedback</strike>
                        </li>
                    </ul>
                </div>
            </div>
            </div>
            <div class="cellContainer">
                <div class="spiegaPremium">
                    <br><h1>Utenza Premium</h1>
                    -------------------------------
                    <div class="testoSpiegaUtenze">
                        <ul class="listaSpiegazione">
                            <li>
                                Compila i questionari
                            </li>
                            <li>
                                Guadagna punti
                            </li>
                            <li>
                                Ottieni ricompense
                            </li>
                            <li>
                                Crea il tuo questionario
                            </li>
                            <li>
                                Ricevi i feedback
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <footer class="footer">
            <div class="container">
                <div class="logoFooter">
                    <img class="logo" src="images/logo.png" width="90px" height="40px">
                </div>
                <div class="infoFooter">
                    INFORMAZIONI<br>
                    <a href="chiSiamo.jsp">Chi siamo</a><br>
                    <a href="contattaci.jsp">Contattaci</a>
                </div>
                <div class="social">
                    <a href="http://instagram.com/survily" target="_blank"><i class="fab fa-instagram"></i></a>
                    <a href="https://www.facebook.com/survily" target="_blank"><i class="fab fa-facebook-f"></i></a>
                    <a href="https://www.twitter.com/survily"  target="_blank"><i class="fab fa-twitter"></i></a>
                </div>
            </div>
        </footer>
    </body>
</html>
