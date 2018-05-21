/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivio;

import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sala.stefano
 */
public class RisposteUtenteServlet  extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {

        try{
            
            HttpSession session = request.getSession(true);
            ArrayList<Domanda> questionarioVisual = (ArrayList<Domanda>) (session.getAttribute("questionarioVisual"));
            Utente utente=(Utente) session.getAttribute("currentSessionUser");
            ArrayList<Domanda> risposteDate = new ArrayList<Domanda>();
            Domanda temp = new Domanda();
            ArrayList<String> risposte = new ArrayList<String>();
            
            for(Domanda d:questionarioVisual){
                temp.setIdDomanda(d.getIdDomanda());
                try{
                    risposte = new ArrayList(Arrays.asList(request.getParameterValues(Integer.toString(d.getIdDomanda()))));
                    temp.setRisposte(risposte);
                }
                catch(NullPointerException e){
                    temp.setNoRisposte(true);
                }
                
                System.out.println(temp);
                risposteDate.add(temp);
                 
            }
            for(Domanda d:risposteDate){
                System.out.println(d.toString());
            }
            
            RisposteUtenteDAO.insertDomanda(risposteDate, questionarioVisual.get(1).getId_questionario(), utente.getEmail());
            
        } 

        catch (Throwable theException){
            System.out.println(theException); 
        }
    }
}
