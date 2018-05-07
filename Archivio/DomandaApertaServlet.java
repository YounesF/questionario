package Archivio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class DomandaApertaServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {

        try{	    
            HttpSession session = request.getSession(true);
            Questionario currentQuest = (Questionario) (session.getAttribute("Questionario"));
            Domanda d = new Domanda();
            d.setDomanda(request.getParameter("domanda"));
            int i = 1;

            int cont = (Integer)session.getAttribute("contatore");
            session.setAttribute("contatore", cont+1);
            
            try{
            if(request.getParameter("multipla").equals("multipla")){
                d.setMultipla(true);
            }
            else
                d.setMultipla(false); }
            catch(NullPointerException e){
                
                }
            
            System.out.println(d.toString());
            d.setId_questionario(currentQuest.getId());
            DomandaDAO.insertDomandaAperta(d);
            currentQuest.DomandaInserita();
            response.sendRedirect("creazioneDomanda.jsp");
        } 

        catch (Throwable theException){
            System.out.println(theException); 
        }
    }
}
