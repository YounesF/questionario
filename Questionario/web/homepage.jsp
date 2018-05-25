
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="Archivio.*"%>
<!DOCTYPE html>
  <html>

      <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
        <title>   Survily-Home   </title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/styleHome.css">
        <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/all.js" integrity="sha384-xymdQtn1n3lH2wcu0qhcdaOpQwyoarkgLVxC/wZ5q7h9gHtxICrpcaSUfygqZGOe" crossorigin="anonymous">
        </script>
      </head>
	
      <body>
          <header>
            <ul>
                <li class="logoSurvily"><a href="homepage.jsp"><img class="logo" src="images/logo.png" width="90px" height="40px"></a></li>
                <li class="userLogout" id="logoutButton"><a href="${pageContext.request.contextPath}/logout" >Logout</a></li>
            </ul>
          </header>
          <div class="content">
            <input class="button" type="button" value="Crea Questionario" onclick="window.location.href='creazioneQuestionario.jsp'">
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

            <% 
                try{
                    session.getAttribute("currentSessionUser").toString();
                }
                catch(NullPointerException e){
                    response.sendRedirect("login.jsp");
                }
                
                Utente currentUser = (Utente) (session.getAttribute("currentSessionUser"));  
                
                ArrayList<Questionario> lista = new ArrayList<Questionario>();
                
                lista = ListaQuestionariDAO.lista();
                
                for(Questionario q: lista){
                    out.write("<div><a href='http://localhost:8080/Questionario/visualizzaServlet?idquestionario="+q.getId()+"'>"+ q.getNome() +"</a></div><br>");
                }

            %>
      </body>
   </html>
