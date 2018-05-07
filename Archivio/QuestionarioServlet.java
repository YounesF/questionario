/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivio;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sala.stefano
 */
public class QuestionarioServlet  extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {

        try{	    

            Questionario q = new Questionario();
            HttpSession session = request.getSession(true);	    
            int contatore = 1;
            
            q.setNumeroDomande(Integer.parseInt(request.getParameter("numeroDomande")));
            q.setNome(request.getParameter("nome"));
            q.calcolaCosto(Integer.parseInt(request.getParameter("numeroDomande")));
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
