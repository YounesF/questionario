package Archivio;

import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class QuestionarioServlet  extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {

        try{
            Questionario q = new Questionario();
            HttpSession session = request.getSession(true);	    
            int contatore = 1;
            
            /* sistemare range
            Random rand = new Random();
            int range = 10 - 6 + 1;
            
            //numero casuale tra 6 e 10, ogni tot viene inserita domanda di sicurezza
            int randomNum =  rand.nextInt(range) + 5;
            */
            
            q.setNumeroDomande(Integer.parseInt(request.getParameter("numeroDomande")));
            q.setNome(request.getParameter("nome"));
            q.calcolaCosto(Integer.parseInt(request.getParameter("numeroDomande")));
            //q.setFrequenzaSic(randomNum);
            
            Utente currentUser = (Utente) (session.getAttribute("currentSessionUser")); 
            System.out.println(currentUser.getEmail());
            System.out.println(q.toString());
            q.setEmail(currentUser.getEmail());
            int id = QuestionarioDAO.insertQuestionario(q);
            q.setId(id);
            session.setAttribute("Questionario", q);
            session.setAttribute("contatore", contatore);
            response.sendRedirect("creazioneDomanda.jsp");
        }

        catch (Throwable theException){
            System.out.println(theException); 
        }
    }
}
