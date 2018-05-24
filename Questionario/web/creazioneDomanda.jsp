<%@page import="Archivio.Questionario"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" type="text/css" href="css/creazioneDomanda.css">
        <title>Domanda</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/all.js" integrity="sha384-xymdQtn1n3lH2wcu0qhcdaOpQwyoarkgLVxC/wZ5q7h9gHtxICrpcaSUfygqZGOe" crossorigin="anonymous"></script>
    </head>
    <body>
        <%

            Questionario currentQuest = (Questionario) (session.getAttribute("Questionario"));
            int numeroMaxDomande = currentQuest.getNumeroDomande();

            if (currentQuest.getNumeroDomande() == 0) {
                response.sendRedirect("userLogged.jsp");
            }
        %>
        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
                    <div class="login100-form-title" style="background-image: url(images/img3.png)">
                        <span class="login100-form-title-1">
                            CREA DOMANDA
                        </span>
                    </div>
                    <form id="formDomanda" class="creazioneDomanda-form validate-form" action="DomandaServlet">
                        <span> Domanda numero <span id="numeroDomanda"> <% out.write(Integer.toString((Integer) session.getAttribute("contatore")));%> </span>:</span>
                        <input type="button" class="cambiaDomanda-form-btn" id="creaDomandaAperta" value="crea una domanda aperta">
                        <div id="domanda" class="wrapCreazioneDomande-input100"><input class="input100" placeholder="Inserire testo domanda..."  type="text" id="testoDomanda" name="domanda"></div>
                        <div id="risposta1" class="wrap-input100-creazioneDomande"><input class="inputCreazioneDomande" placeholder="Inserire testo risposta..." type="text" name="r1"><span class="focus-input100-creazioneDomande"></span></div>
                        <div id="risposta2" class="wrap-input100-creazioneDomande"><input class="inputCreazioneDomande" placeholder="Inserire testo risposta..." type="text" name="r2"><span class="focus-input100-creazioneDomande"></span></div>
                        <div id="risposta3" class="wrap-input100-creazioneDomande"><input class="inputCreazioneDomande" placeholder="Inserire testo risposta..." type="text" name="r3"><span class="focus-input100-creazioneDomande"></span></div>
                        <div id="risposta4" class="wrap-input100-creazioneDomande"><input class="inputCreazioneDomande" placeholder="Inserire testo risposta..." type="text" name="r4"><span class="focus-input100-creazioneDomande"></span></div><br>
                        <div><input type="checkbox" id="checkbox" name="multipla" value="multipla"> Risposta multipla</div>
                        <input type="button" id="aggiungiRisposta"class="creazioneDomanda-form-btn" value="aggiungi risposta">
                        <input type="submit" class="creazioneDomandaInvio-form-btn" class="submit">
                        <div id="limiteRisposte"></div>
                    </form>
                </div>
            </div>
        </div>
        <script>
            /*
             //non permette l'inserimento nell'input number numDomande dei caratteri e,+,-
             document.querySelector("#numDomande").addEventListener("keypress", function (evt) {
             if (evt.which != 8 && evt.which != 0 && evt.which < 48 || evt.which > 57)
             {
             evt.preventDefault();
             }
             });
             */



            //aggiunge una casella di risposta al aclick di #aggiungiRisposta
            var num = 4;
            $('#aggiungiRisposta').on('click', function () {
                if (num + 1 <= 10) {
                    $('#risposta' + num).after('<div id="risposta' + (num + 1) + '" class="wrap-input100-creazioneDomande"><input class="inputCreazioneDomande" placeholder="Inserire testo risposta..." type="text" id="r' + (num + 1) + '" name="r' + (num + 1) + '"><span class="focus-input100-creazioneDomande"></span><div id="' + (num + 1) + '" class="elimina" ><i class="far fa-times-circle"></i></div></div>');
                    $('#' + num).remove();
                    num++;
                } else {
                    $('#limiteRisposte').html('limite massimo di risposte raggiunto');
                }
            });

            //al click di .elimina elimina l'ultima casella di risposta
            $('form').on('click', '.elimina', function () {
                $('#risposta' + this.id).remove();
                $('#' + this.id).remove();
                num--;
                if (num > 4)
                    $('#r' + num).after('<div id="' + (num) + '" class="elimina" ><i class="far fa-times-circle"></i></div>');
            });
            //cambia da domanda chiusa a domanda aperta
            $('form').on('click', '#creaDomandaAperta', function () {
                $('#formDomanda').attr('action', 'DomandaApertaServlet');
                $('form').html('<span> Domanda numero <span id="numeroDomanda">  <% out.write(Integer.toString((Integer) session.getAttribute("contatore")));%> </span>:</span><input type="button" id="creaDomandaChiusa" class="cambiaDomanda-form-btn" value="crea una domanda chiusa"><br><div id="domanda" class="wrapCreazioneDomande-input100"><input class="input100" placeholder="Inserire testo domanda..."  type="text" id="testoDomanda" name="domanda"></div><br>\n\
                <input type="submit" class="creazioneDomandaInvio-form-btn" class="submit">');
                $('#aggiungiRisposta').remove();
                num = 4;

            });

            //cambia da domanda aperta a domanda a risposta multipla
            $('form').on('click', '#creaDomandaChiusa', function () {
                $('#formDomanda').attr('action', 'DomandaServlet');
                $('form').html('<span> Domanda numero <span id="numeroDomanda">  <% out.write(Integer.toString((Integer) session.getAttribute("contatore")));%> </span>:</span>\n\
                <input type="button" class="cambiaDomanda-form-btn" id="creaDomandaAperta" value="crea una domanda aperta"><br>\n\
                <div id="domanda" class="wrapCreazioneDomande-input100"><input class="input100" placeholder="Inserire testo domanda..."  type="text" id="testoDomanda" name="domanda"></div>\n\
                <div id="risposta1" class="wrap-input100-creazioneDomande"><input type="text" class="inputCreazioneDomande" placeholder="Inserire testo risposta..." name="r1"><span class="focus-input100-creazioneDomande"></span></div>\n\
                <div id="risposta2" class="wrap-input100-creazioneDomande"><input type="text" class="inputCreazioneDomande" placeholder="Inserire testo risposta..." name="r2"><span class="focus-input100-creazioneDomande"></span></div>\n\
                <div id="risposta3" class="wrap-input100-creazioneDomande"><input type="text" class="inputCreazioneDomande" placeholder="Inserire testo risposta..." name="r3"><span class="focus-input100-creazioneDomande"></span></div>\n\
                <div id="risposta4" class="wrap-input100-creazioneDomande"><input type="text" class="inputCreazioneDomande" placeholder="Inserire testo risposta..." name="r4"><span class="focus-input100-creazioneDomande"></span></div><br>\n\
                <div><input type="checkbox" id="checkbox" name="multipla" value="multipla"> Risposta multipla</div>\n\
                <input type="button" id="aggiungiRisposta"class="creazioneDomanda-form-btn" value="aggiungi risposta">\n\
                <input type="submit" class="creazioneDomandaInvio-form-btn" class="submit">\n\
                <div id="limiteRisposte"></div>');
                //aggiunge una casella di risposta al aclick di #aggiungiRisposta

                $('#aggiungiRisposta').on('click', function () {
                    if (num + 1 <= 10) {
                        $('#risposta' + num).after('<div id="risposta' + (num + 1) + '"  class="wrap-input100-creazioneDomande"><input type="text" id="r' + (num + 1) + '" class="inputCreazioneDomande" placeholder="Inserire testo risposta..." name="r' + (num + 1) + '"><span class="focus-input100-creazioneDomande"></span><div id="' + (num + 1) + '" class="elimina" ><i class="far fa-times-circle"></i></div></div>');
                        $('#' + num).remove();
                        num++;
                    } else {
                        $('#limiteRisposte').html('limite massimo di risposte raggiunto');
                    }
                });
            });








        </script>
    </body>
</html>
