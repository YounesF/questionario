
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- <link rel="stylesheet" href="https://jqueryvalidation.org/files/demo/site-demos.css">
         VEDI PER CSS EMAIL VALIDATION
        -->
        <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
        <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
        
    </head>
    <body>
        <form id="checkemailform">
            
            <input placeholder="nome" type="text" name="nome"> <br>
            <input placeholder="cognome" type="text" name="cognome"> <br>
            <input placeholder="cellulare" type="text" name="cellulare"> <br>
            <input placeholder="password" type="password" name="password"> almeno 6 caratteri alfanumerici <br>
            <label for="field">Required, email: </label>
            <input placeholder="email" id="email" name="email"> <br>
            <input type="date" id="nascita" name="nascita" min="1900-01-01">

            <br>
            <input class="button" type="button" value="RegistraServlet" onclick="window.location.href='RegistraServlet.java'">
            <input class="button" type="button" value="Torna Login" onclick="window.location.href='index.jsp'">
            <script>
            // just for the demos, avoids form submit
            jQuery.validator.setDefaults({
                debug: true,
                success: "valid"
              });
              $( "#checkemailform" ).validate({
                rules: {
                  email: {
                    required: true,
                    email: true
                  }
                }
              });
        </script>
    </body>
</html>
