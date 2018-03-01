/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivio;

/**
 *
 * @author ceriani.gabriele
 */import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class QuestionarioServlet extends HttpServlet {


public void doGet(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {

try
{	    
    
     Questionario quest = new Questionario();
     quest.setDomanda(request.getParameter("domanda"));
     
     int i = 1;
     while(request.getParameter("r"+i) != null){
         quest.getRisposte().add(request.getParameter("r"+i));
         i++;
     }
  
      QuestionarioDAO.insertQuestionario(quest);
      response.sendRedirect("questionarioRegistrato.jsp");
} 
		
		
catch (Throwable theException) 	    
{
     System.out.println(theException); 
}
       }
	}
