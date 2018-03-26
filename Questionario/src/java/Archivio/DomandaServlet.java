package Archivio;

import java.io.IOException;
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

            System.out.println(d.toString());
            DomandaDAO.insertDomanda(d);
            //response.sendRedirect("questionarioRegistrato.jsp");
        } 

        catch (Throwable theException){
            System.out.println(theException); 
        }
    }
}
