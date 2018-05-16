
<%@page import="Archivio.Questionario"%>
<%@page import="Archivio.Utente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "mandaALogin.jsp" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            // già presente in mandaALogin 
            //Utente currentUser = (Utente) (session.getAttribute("currentSessionUser"));
            Questionario currentQuest = (Questionario)(session.getAttribute("Questionario"));
        %>
        <form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
            <input type="hidden" name="cmd" value="_xclick">
            <input type="hidden" name="currency_code" value="EUR" />
            <input type="hidden" name="lc" value="IT" />
            <% out.write("<input type='hidden' name='custom' value='" + currentUser.getEmail() + "' />");%>
            <% out.write("<input type='hidden' name='amount' value='" + currentQuest.getCosto() + "' />");%>
            <input type="hidden" name="business" value="stesala98.ss60@gmail.com" />
            <!url al quale inviare notifica di pagamento > <input type="hidden" name="notify_url" value="http://www.tuoSito.com/urlDelListener.php" />
            <!bho <input type="hidden" name="custom" value="<?php echo $data; ?>
            <input type="submit" value="PAGA ADESSO" />
        </form>

    </body>
</html>
