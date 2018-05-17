package Archivio;

import java.io.IOException;
import java.util.ArrayList;
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
            ArrayList<Domanda> domande = new ArrayList<Domanda>();
            int cont = (Integer)session.getAttribute("contatore");
            
            if(cont == 1){
                session.setAttribute("domande", domande);
            }
            else{
                domande = (ArrayList<Domanda>) (session.getAttribute("domande"));
            }
            
            Domanda d = new Domanda();
            d.setDomanda(request.getParameter("domanda"));
            int i = 1;
            
            d.setAperta(true);
            d.setMultipla(false);
            session.setAttribute("contatore", cont+1);
            
            domande.add(d);
            
            d.setId_questionario(currentQuest.getId());
            System.out.println(d.toString());
            
            if(currentQuest.getNumeroDomande()==1){
                DomandaDAO.insertDomanda(domande);
                response.sendRedirect("paypal.jsp");
            }
            
            currentQuest.DomandaInserita();
            response.sendRedirect("creazioneDomanda.jsp");
        } 

        catch (Throwable theException){
            System.out.println(theException); 
        }
    }
}
