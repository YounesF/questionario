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
public class VisualizzaServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {

        try{	    
            HttpSession session = request.getSession(true);
            Questionario currentQuest = (Questionario) (session.getAttribute("Questionario"));
            ArrayList<Domanda> questionarioVisual = new ArrayList<Domanda>();
            VisualizzaDAO.insertDomanda(currentQuest,questionarioVisual);
            
        }

        catch (Throwable theException){
            System.out.println(theException); 
        }
    }
}
