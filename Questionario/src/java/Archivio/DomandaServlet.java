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
public class DomandaServlet extends HttpServlet {

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
            Domanda d = new Domanda();
            d.setDomanda(request.getParameter("domanda"));
            int i = 1;
            while(request.getParameter("r"+i) != null){
                try{
                    d.getRisposte().add(request.getParameter("r"+i));
                }
                catch(NullPointerException e){
                }
                i++;
            }
            
            try{
                
                if(request.getParameter("multipla").equals("multipla")){
                    d.setMultipla(true);
                }
                else
                    d.setMultipla(false); 
            }
            catch(NullPointerException e){
            }
            
            domande.add(d);
            session.setAttribute("contatore", cont+1);
            d.setId_questionario(currentQuest.getId());
            //sistemare
            /*
            if(session.getAttribute("contatore").equals(currentQuest.getNumeroDomande())){
                DomandaDAO.insertDomanda(domande);
                currentQuest.DomandaInserita();
                response.sendRedirect("creazioneDomanda.jsp");
            }*/
            
            
            System.out.println(d);
        } 

        catch (Throwable theException){
            System.out.println(theException); 
        }
    }
}
