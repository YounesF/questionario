
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->

        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" type="text/css" href="css/registra.css">
        <title>Registra</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- <link rel="stylesheet" href="https://jqueryvalidation.org/files/demo/site-demos.css">
         VEDI PER CSS EMAIL VALIDATION
        -->
        <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="js/jquery_validate.js"></script>
        <script src="js/jquery_add.js"></script>

    </head>
    <body>
        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
                    <div class="login100-form-title" style="background-image: url(images/img3.png)">
                        <span class="login100-form-title-1">
                            REGISTRATI
                        </span>
                    </div>

                    <form class="login100-form validate-form" action="RegistraServlet" id="checkemailform">
                        <div class="wrap-input100 validate-input m-b-26" data-validate="Nome is required">
                            <span class="label-input100">Nome</span>
                            <input class="inputRegistra" type="text" name="nome" placeholder="Inserisci nome">
                            <span class="focus-input100"></span>
                        </div>

                        <div class="wrap-input100 validate-input m-b-18" data-validate = "Cognome is required">
                            <span class="label-input100">Cognome</span>
                            <input class="inputRegistra" type="text" name="cognome" placeholder="Inserisci cognome">
                            <span class="focus-input100"></span>
                        </div>

                        <div class="wrap-input100 validate-input m-b-18" id="email" data-validate = "Email is required">
                            <span class="label-input100">Email</span>
                            <input class="inputRegistra" type="email" name="email" placeholder="Inserisci email">
                            <span class="focus-input100"></span>
                        </div>

                        <div class="wrap-input100 validate-input m-b-26" data-validate="Password is required">
                            <span class="label-input100">Password</span>
                            <input class="inputRegistra" type="password" name="password" placeholder="Inserisci password">
                            <span class="focus-input100"></span>
                        </div>

                        <div class="wrap-input100 validate-input m-b-26" data-validate="ConfermaPassword is required">
                            <span class="label-input100">Conferma Password</span>
                            <input class="inputRegistra" type="password" name="confermaPassword" placeholder="Conferma password">
                            <span class="focus-input100"></span>
                        </div>

                        <div class="wrap-input100 validate-input m-b-18" data-validate = "NumeroCellulare is required">
                            <span class="label-input100">Cellulare</span>
                            <input class="inputRegistra" type="tel" name="cellulare" placeholder="Inserisci cellulare">
                            <span class="focus-input100"></span>
                        </div>

                        <div class="wrap-input100 validate-input m-b-18" data-validate = "DataDiNascita is required">
                            <span class="label-input100">Data di nascita</span>
                            <input class="inputRegistra" type="date" name="dataDiNascita">
                            <span class="focus-input100"></span>
                        </div>

                        <div class="container-registra100-form-btn">
                            <input type="submit" value="REGISTRA"   class="registra100-form-btn">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!--<script>
            $("#checkemailform").validate({
                rules: {
                    email: {
                        required: true,
                        email: true
                    }
                }
            });
        </script> -->
        <script>
        // just for the demos, avoids form submit
            jQuery.validator.setDefaults({
                debug: true,
                success: "valid"
            });
            $("#myform").validate({
                rules: {
                    field: {
                        required: true,
                        email: true
                    }
                }
            });
        </script>
    </body> 
</html>
