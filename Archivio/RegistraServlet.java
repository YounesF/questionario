/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivio;

/**
 *
 * @author youne
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class RegistraServlet extends HttpServlet {


public void doGet(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {

try
{	    
    String dataString;
    
     Utente user = new Utente();
     user.setEmail(request.getParameter("email"));
     user.setPassword(request.getParameter("password"));
     user.setCellulare(Integer.parseInt(request.getParameter("cellulare")));
     user.setCognome(request.getParameter("cognome"));
     user.setNome(request.getParameter("nome"));
     dataString = request.getParameter("nascita");
     user.setData(ConvertString.convertStringToDate(dataString));

      UtenteDAO.insertUtente(user);
	   		    
     response.sendRedirect("userRegistrato.jsp");
} 
		
		
catch (Throwable theException) 	    
{
     System.out.println(theException); 
}
       }
	}
