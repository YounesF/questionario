package Archivio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
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
            else{
                domande = (ArrayList<Domanda>) (session.getAttribute("domande"));
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
            
            /*try{
                if(currentQuest.getFrequenzaSic() == cont){
                    int temp = currentQuest.getFrequenzaSic() - 5;
                    Random rand = new Random();
                    int range = temp - currentQuest.getFrequenzaSic() + 1;
                    int randomNum =  rand.nextInt(range) + currentQuest.getFrequenzaSic();
                    
                    //mettere domanda sicurezza in posizione randomNum
                    int tempCont = cont;
                    cont = randomNum;
                    String s1 = "Qual é il primo mese dell’anno?";
                    String s2 = "In quale sport viene usata una pallina gialla?";
                    String s3 = "Quale lingua si parla in Inghilterra?";
                    
                    
                    
                    cont = tempCont;
                    
                    QuestionarioDAO.modificaQuestionario(currentQuest);
                    currentQuest.setNumeroDomande(currentQuest.getNumeroDomande() + 1);
                    currentQuest.setFrequenzaSic(currentQuest.getFrequenzaSic() + 10);
                }                    
            }
            catch(NullPointerException e){
            }*/
            
            domande.add(d);
            session.setAttribute("contatore", cont+1);
            d.setId_questionario(currentQuest.getId());
           
            if(currentQuest.getNumeroDomande()==1){
                DomandaDAO.insertDomanda(domande);
                response.sendRedirect("paypal.jsp");
            }
            else{
                currentQuest.DomandaInserita();
                response.sendRedirect("creazioneDomanda.jsp");
            }
            
            System.out.println(d);
        } 

        catch(Throwable theException){
            System.out.println(theException); 
        }
    }
}
