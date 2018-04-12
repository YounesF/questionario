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
        <title>Domanda</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    </head>
    <body>
        <%

            try {
                session.getAttribute("Questionario").toString();

            } catch (NullPointerException e) {
                response.sendRedirect("creazioneQuestionario.jsp");
            }

            Questionario currentQuest = (Questionario) (session.getAttribute("Questionario"));
            int numeroMaxDomande = currentQuest.getNumeroDomande();

            if (currentQuest.getNumeroDomande() == 0) {
                response.sendRedirect("userLogged.jsp");
            }
        %>
        <div id="creaDomanda" >
            <form action="DomandaServlet">
                <span> Domanda numero <span id="numeroDomanda"> <% out.write(Integer.toString((Integer) session.getAttribute("contatore")));%> </span>:</span><input type="button" id="creaDomandaAperta" value="crea una domanda aperta"><br>
                <input type="text" name="domanda" id="testoDomanda" placeholder="Testo Domanda"><br>
                <div id="risposta1"><input type="text" name="r1"></div>
                <div id="risposta2"><input type="text" name="r2"></div>
                <div id="risposta3"><input type="text" name="r3"></div>
                <div id="risposta4"><input type="text" name="r4"></div>
                <input type="button" id="aggiungiRisposta" value="aggiungi risposta"><br>
                <input type="submit" class="submit">
                <div id="limiteRisposte"></div>
            </form>
            

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
                    $('#risposta' + num).after('<div id="risposta' + (num + 1) + '"><input type="text" id="r' + (num + 1) + '" name="r' + (num + 1) + '"><input type="button" id="' + (num + 1) + '" class="elimina" value="X"></div>');
                    $('#' + num).remove();
                    num++;
                } else {
                    $('#limiteRisposte').html('limite massimo di risposte raggiunto');
                }
            });

            //al click di .elimina elimina l'ultima casella di risposta
            $('form').on('click', '.elimina', function () {
                $('#risposta' + this.id).remove();
                num--;
                $('#r' + num).after('<input type="button" id="' + num + '" class="elimina" value="X">');
            });
            //cambia da domanda chiusa a domanda aperta
            $('form').on('click', '#creaDomandaAperta', function () {
                $('form').html('<span> Domanda numero <span id="numeroDomanda">  <% out.write(Integer.toString((Integer) session.getAttribute("contatore")));%> </span>:</span><input type="button" id="creaDomandaChiusa" value="crea una domanda chiusa"><br><input type="text" id="testoDomanda" placeholder="Testo Domanda"><br>\n\
                <input type="submit" class="submit">');
                $('#aggiungiRisposta').remove();
                num = 4;
            });

            //cambia da domanda aperta a domanda a risposta multipla
            $('form').on('click', '#creaDomandaChiusa', function () {
                $('form').html('<span> Domanda numero <span id="numeroDomanda">  <% out.write(Integer.toString((Integer) session.getAttribute("contatore")));%> </span>:</span><input type="button" id="creaDomandaAperta" value="crea una domanda aperta"><br>\n\
                <input type="text" id="testoDomanda" placeholder="Testo Domanda"><br>\n\
                <div id="risposta1"><input type="text"></div>\n\
                <div id="risposta2"><input type="text"></div>\n\
                <div id="risposta3"><input type="text"></div>\n\
                <div id="risposta4"><input type="text"></div>\n\
                <input type="button" id="aggiungiRisposta" value="aggiungi risposta"><br>\n\
                <input type="submit" class="submit">\n\
                <div id="limiteRisposte"></div>');
                //aggiunge una casella di risposta al aclick di #aggiungiRisposta

                $('#aggiungiRisposta').on('click', function () {
                    if (num + 1 <= 10) {
                        $('#risposta' + num).after('<div id="risposta' + (num + 1) + '"><input type="text" id="r' + (num + 1) + '" name="r' + (num + 1) + '"><input type="button" id="' + (num + 1) + '" class="elimina" value="X"></div>');
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
