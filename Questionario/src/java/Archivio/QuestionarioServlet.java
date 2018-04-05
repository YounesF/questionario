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

/**
 *
 * @author sala.stefano
 */
public class QuestionarioServlet  extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {

        try{	    

            Questionario q = new Questionario();
            
            q.setNumeroDomande(Integer.parseInt(request.getParameter("numeroDomande")));
            q.setNumeroQuest(Integer.parseInt(request.getParameter("numeroQuest")));
            q.calcolaCosto(Integer.parseInt(request.getParameter("numeroDomande")));
            System.out.println(q.toString());
            QuestionarioDAO.insertQuestionario(q);
            //response.sendRedirect("questionarioRegistrato.jsp");
        } 

        catch (Throwable theException){
            System.out.println(theException); 
        }
    }
}
